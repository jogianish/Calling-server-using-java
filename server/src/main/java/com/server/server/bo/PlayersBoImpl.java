package com.server.server.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.server.Dao.PlayersRepository;
import com.server.server.entity.Address;
import com.server.server.entity.JerseyNumber;
import com.server.server.entity.PlayerRole;
import com.server.server.entity.Players;

@Service
public class PlayersBoImpl implements PlayersBo {
    @Autowired
    private PlayersRepository playersRepository;

    @Override
    public List<Players> getAllPlayers() {

        return playersRepository.findAll();
    }

    @Override
    public Players createPlayers(Players players) {

        return playersRepository.save(players);
    }

    @Override
    public Players updatePlayers(Players players, long id) {

        Optional<Players> existingPlayers = playersRepository.findById(id);
        if (existingPlayers.isPresent()) {
            Players currentPlayer = existingPlayers.get();
            currentPlayer.setPlayerFirstName(players.getPlayerFirstName());
            currentPlayer.setPlayerLastName(players.getPlayerLastName());
            currentPlayer.setPlayerPhoneNumber(players.getPlayerPhoneNumber());
            currentPlayer.setPlayerEmail(players.getPlayerEmail());

            Address addresses = players.getAddress();

            currentPlayer.setAddress(addresses);

            JerseyNumber jerseyNumber = players.getJerseyNumbers();
            currentPlayer.setJerseyNumbers(jerseyNumber);

            PlayerRole playerRole = players.getPlayerRole();
            currentPlayer.setPlayerRole(playerRole);
            return playersRepository.save(currentPlayer);

        } else {
            throw new IllegalArgumentException("Player not found with id: " + id);
        }

    }

    @Override
    public void deletePlayres(long id) {

        Optional<Players> existingPlayers = playersRepository.findById(id);
        if (existingPlayers.isPresent()) {
            playersRepository.deleteById(id);
        }
    }

}
