package org.kishorev.poc.banking.service.impl;

import org.kishorev.poc.banking.entity.TradingBookInfo;

public interface TradingBookService {

    Iterable<TradingBookInfo> getAllTradingBooks();
}
