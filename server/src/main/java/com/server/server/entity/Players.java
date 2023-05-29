package com.server.server.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "players")
public class Players {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "firstname", nullable = false)
    private String playerFirstName;
    @Column(name = "lastname", nullable = false)
    private String playerLastName;
    @Column(name = "phonenumber", nullable = false)
    private long playerPhoneNumber;
    @Column(name = "email", nullable = false)
    private String playerEmail;
    @OneToOne(mappedBy = "players", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Address address;
    @OneToOne(mappedBy = "players", cascade = CascadeType.ALL)
    @JsonManagedReference
    private JerseyNumber jerseyNumbers;
    @OneToOne(mappedBy = "players", cascade = CascadeType.ALL)
    @JsonManagedReference
    private PlayerRole playerRole;
    @OneToOne(mappedBy = "players", cascade = CascadeType.ALL)
    @JsonManagedReference
    private NumberOfPoints numberOfPoints;

}
