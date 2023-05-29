package com.server.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "number_of_points")
public class NumberOfPoints {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "attacks", nullable = false)
    private int attacks;
    @Column(name = "drops", nullable = false)
    private int drops;
    @Column(name = "serve", nullable = false)
    private int serve;
    @Column(name = "total_points", nullable = false)
    private int totalPoints;

    @OneToOne
    @JoinColumn(name = "playersId")
    @JsonBackReference
    private Players players;

    @PrePersist
    @PreUpdate
    private void calculateTotalPoints() {
        totalPoints = attacks + drops + serve;
    }

}
