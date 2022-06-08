package org.kishorev.poc.banking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TRADING_BOOK")
@Getter
@Setter
public class TradingBookInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRADING_BOOK_SEQ")
    @SequenceGenerator(sequenceName = "trading_book_seq", allocationSize = 1, name = "TRADING_BOOK_SEQ")
    Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;
}
