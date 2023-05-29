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
@Table(name = "jersey_number")
public class JerseyNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long jerseyNumberId;
    @Column(name = "jerseynumber")
    private int jerseyNumber;
    @OneToOne
    @JoinColumn(name = "playersId")
    @JsonBackReference
    private Players players;

}
