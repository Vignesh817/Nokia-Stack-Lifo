package com.nokia.stack.service;

import com.nokia.stack.constants.Constants;
import com.nokia.stack.maria.entity.MariaRequestEntity;
import com.nokia.stack.maria.repository.RepositoryMaria;
import com.nokia.stack.postgre.entity.PostgreRequestEntity;
import com.nokia.stack.postgre.repository.RepositoryPostgre;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The Class DbOperation.
 */
@Component
@Log4j2
public class DbOperation {
  
  /** The maria repo. */
  @Autowired
  private RepositoryMaria mariaRepo;

  /** The postgre repo. */
  @Autowired
  private RepositoryPostgre postgreRepo;

  /**
   * Save to maria db.
   *
   * @param value the value
   * @return the string
   */
  public String saveToMariaDb(int value) {

    MariaRequestEntity entity = new MariaRequestEntity();
    entity.setPushedValue(value);
    mariaRepo.save(entity);
    log.info(Constants.SAVED_INTO_MARIA.getValue());
    return Constants.SAVED_INTO_MARIA.getValue();
  }

  /**
   * Save poped value to maria db.
   *
   * @param popedValue the poped value
   * @return the string
   */
  public String savePopedValueToMariaDb(int popedValue) {

    MariaRequestEntity entity = new MariaRequestEntity();
    entity.setPopedValue(popedValue);
    mariaRepo.save(entity);
    log.info(Constants.SAVED_INTO_MARIA.getValue());
    return Constants.SAVED_INTO_MARIA.getValue();
  }

  /**
   * Save to postgre db.
   *
   * @param value the value
   * @return the string
   */
  public String saveToPostgreDb(int value) {

    PostgreRequestEntity entity = new PostgreRequestEntity();
    entity.setPushedValue(value);
    postgreRepo.save(entity);
    log.info(Constants.SAVED_INTO_POSTGRE.getValue());
    return Constants.SAVED_INTO_POSTGRE.getValue();
  }

  /**
   * Save poped value to postgre db.
   *
   * @param value the value
   * @return the string
   */
  public String savePopedValueToPostgreDb(int value) {

    PostgreRequestEntity entity = new PostgreRequestEntity();
    entity.setPopedValue(value);
    postgreRepo.save(entity);
    log.info(Constants.SAVED_INTO_POSTGRE.getValue());
    return Constants.SAVED_INTO_POSTGRE.getValue();
  }

}
