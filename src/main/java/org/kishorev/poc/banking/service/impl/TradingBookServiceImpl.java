package org.kishorev.poc.banking.service.impl;

import org.kishorev.poc.banking.dao.TradingBookInfoDAO;
import org.kishorev.poc.banking.entity.TradingBookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradingBookServiceImpl implements TradingBookService {

    @Autowired private TradingBookInfoDAO dao;


    @Override
    public Iterable<TradingBookInfo> getAllTradingBooks() {
        return dao.findAll();
    }
}
