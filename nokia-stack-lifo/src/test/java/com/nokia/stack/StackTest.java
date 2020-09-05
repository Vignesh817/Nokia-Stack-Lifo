package com.nokia.stack;

import com.nokia.stack.service.DbOperation;
import com.nokia.stack.service.Stack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * The Class StackTest.
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StackTest {

  /** The stack. */
  @InjectMocks
  private Stack stack;

  /** The db operation. */
  @Mock
  private DbOperation dbOperation;

  /**
   * Test my stack.
   */
  @Test
  public void testMyStack() {
    stack.myStack(10);
  }

  /**
   * Test push maria.
   */
  @Test
  public void testPushMaria() {
    stack.myStack(10);
    stack.push(10, "Maria");
  }

  /**
   * Test push postgre.
   */
  @Test
  public void testPushPostgre() {
    stack.myStack(10);
    stack.push(10, "Postgre");
  }

  /**
   * Test push wrong.
   */
  @Test
  public void testPushWrong() {
    stack.myStack(10);
    stack.push(10, "Wrong");
  }

  /**
   * Test push stack full.
   */
  @Test
  public void testPushStackFull() {
    stack.push(10, "Maria");
  }

  /**
   * Test pop.
   */
  @Test
  public void testPop() {
    stack.pop();
  }

  /**
   * Test pop maria.
   */
  @Test
  public void testPopMaria() {
    stack.myStack(10);
    stack.push(10, "Maria");
    stack.pop();
  }

  /**
   * Test pop postgre.
   */
  @Test
  public void testPopPostgre() {
    stack.myStack(10);
    stack.push(10, "Postgre");
    stack.pop();
  }

  /**
   * Test pop wrong.
   */
  @Test
  public void testPopWrong() {
    stack.myStack(10);
    stack.push(10, "Wrong");
    stack.pop();
  }
}
