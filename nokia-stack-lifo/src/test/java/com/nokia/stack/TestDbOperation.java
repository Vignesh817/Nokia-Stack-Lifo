package com.nokia.stack;

import com.nokia.stack.maria.repository.RepositoryMaria;
import com.nokia.stack.postgre.repository.RepositoryPostgre;
import com.nokia.stack.service.DbOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * The Class TestDbOperation.
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TestDbOperation {

  /** The db operation. */
  @InjectMocks

  private DbOperation dbOperation;

  /** The maria repo. */
  @Mock
  private RepositoryMaria mariaRepo;

  /** The postgre repo. */
  @Mock
  private RepositoryPostgre postgreRepo;

  /**
   * Test save to maria db.
   */
  @Test
  public void testSaveToMariaDb() {
    dbOperation.saveToMariaDb(10);
  }

  /**
   * Test save poped value to maria db.
   */
  @Test
  public void testSavePopedValueToMariaDb() {
    dbOperation.savePopedValueToMariaDb(10);
  }

  /**
   * Test save to postgre db.
   */
  @Test
  public void testSaveToPostgreDb() {
    dbOperation.saveToPostgreDb(10);
  }

  /**
   * Test save poped value to postgre db.
   */
  @Test
  public void testSavePopedValueToPostgreDb() {
    dbOperation.savePopedValueToPostgreDb(10);
  }

}
