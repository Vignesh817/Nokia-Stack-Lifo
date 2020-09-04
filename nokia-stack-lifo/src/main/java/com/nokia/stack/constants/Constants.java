package com.nokia.stack.constants;

public enum Constants {

  STACK_SIZE("stack.array.size"),
  HIBERNATE_HBM2DDL("hibernate.hbm2ddl.auto"),
  HIBERNATE_DIALECT("hibernate.dialect"),
  
  MARIA_PERSISTENCE_UNIT_NAME("Maria"),
  MARIA_ENTITY_PACKAGE("com.nokia.stack.maria.entity"),
  SAVED_INTO_MARIA("Saved into MariaDb"),

  POSTGRE_PERSISTENCE_UNIT_NAME("Postgre"),
  POSTGRE_ENTITY_PACKAGE("com.nokia.stack.postgre.entity"),
  SAVED_INTO_POSTGRE("Saved into PostgreSql"),
  
  VALUE("Value"),
  
  SPECIFY_DB("SpecifyDb");
  
  private final String value;

  public String getValue() {
    return value;
  }

  private Constants(String value) {
    this.value = value;
  }

}
