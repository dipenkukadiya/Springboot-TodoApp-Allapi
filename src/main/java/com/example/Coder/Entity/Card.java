package com.example.Coder.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity
public class Card {
    @Id
    @Column(name = "card_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_name")
    private String name;

    @Column(name = "card_key") 
    private String cardKey;

    @Column(name = "card_index") 
    private Long cardIndex;

    @Column(name = "is_archive")
    private Boolean archive;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}

