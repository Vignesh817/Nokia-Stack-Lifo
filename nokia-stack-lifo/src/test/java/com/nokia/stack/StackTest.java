package com.nokia.stack;

import com.nokia.stack.service.DbOperation;
import com.nokia.stack.service.Stack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StackTest {

  @InjectMocks
  private Stack stack;

  @Mock
  private DbOperation dbOperation;

  @Test
  public void testMyStack() {
    stack.myStack(10);
  }

  @Test
  public void testPushMaria() {
    stack.myStack(10);
    stack.push(10, "Maria");
  }

  @Test
  public void testPushPostgre() {
    stack.myStack(10);
    stack.push(10, "Postgre");
  }

  @Test
  public void testPushWrong() {
    stack.myStack(10);
    stack.push(10, "Wrong");
  }

  @Test
  public void testPushStackFull() {
    stack.push(10, "Maria");
  }

  @Test
  public void testPop() {
    stack.pop();
  }

  @Test
  public void testPopMaria() {
    stack.myStack(10);
    stack.push(10, "Maria");
    stack.pop();
  }

  @Test
  public void testPopPostgre() {
    stack.myStack(10);
    stack.push(10, "Postgre");
    stack.pop();
  }

  @Test
  public void testPopWrong() {
    stack.myStack(10);
    stack.push(10, "Wrong");
    stack.pop();
  }
}
