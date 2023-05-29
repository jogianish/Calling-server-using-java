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
@Table(name = "players_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long addressId;
    @Column(name = "address_1", length = 1000)
    private String address_1;
    @Column(name = "address_2", length = 1000)
    private String address_2;
    @Column(name = "district", length = 1000)
    private String district;
    @Column(name = "state", length = 1000)
    private String state;
    @Column(name = "country", length = 1000)
    private String country;
    @Column(name = "pincode", length = 1000)
    private String pincode;
    @OneToOne
    @JoinColumn(name = "playersId")
    @JsonBackReference
    private Players players;

}
