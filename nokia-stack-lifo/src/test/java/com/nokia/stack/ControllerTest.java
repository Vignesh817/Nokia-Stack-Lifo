package com.nokia.stack;

import com.nokia.stack.controller.Controller;
import com.nokia.stack.service.Stack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * The Class ControllerTest.
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ControllerTest {

  /** The controller. */
  @InjectMocks
  private Controller controller;

  /** The stack. */
  @Mock
  private Stack stack;

  /**
   * Test push.
   */
  @Test
  public void testPush() {
    String body = "{\r\n" +
      "  \"Value\": 147,\r\n" +
      "  \"SpecifyDb\": \"Postgre\"\r\n" +
      "}";
    controller.pushValue(body);
  }

  /**
   * Test pop.
   */
  @Test
  public void testPop() {
    controller.popValue();
  }

}
