package org.kishorev.poc.banking.dao;

import org.kishorev.poc.banking.entity.TradingBookInfo;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.PersistenceContext;

// unitName = oracleDb -> check this value "oracleDb" in OracleDBConfig.java class in persistenceUnit line of code
@PersistenceContext(unitName = "oracleDb")
public interface TradingBookInfoDAO extends CrudRepository<TradingBookInfo, Long> {
}
