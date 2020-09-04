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

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TestDbOperation {

  @InjectMocks

  private DbOperation dbOperation;

  @Mock
  private RepositoryMaria mariaRepo;

  @Mock
  private RepositoryPostgre postgreRepo;

  @Test
  public void testSaveToMariaDb() {
    dbOperation.saveToMariaDb(10);
  }

  @Test
  public void testSavePopedValueToMariaDb() {
    dbOperation.savePopedValueToMariaDb(10);
  }

  @Test
  public void testSaveToPostgreDb() {
    dbOperation.saveToPostgreDb(10);
  }

  @Test
  public void testSavePopedValueToPostgreDb() {
    dbOperation.savePopedValueToPostgreDb(10);
  }

}
