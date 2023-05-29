package com.server.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "player_role")
public class PlayerRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long playererRoleId;
    @Column(name = "role")
    private String playerRole;
    @OneToOne
    @JoinColumn(name = "playersId")
    @JsonBackReference
    private Players players;

}
