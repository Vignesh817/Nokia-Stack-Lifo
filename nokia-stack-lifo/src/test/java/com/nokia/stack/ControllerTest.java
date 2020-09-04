package com.nokia.stack;

import com.nokia.stack.controller.Controller;
import com.nokia.stack.service.Stack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ControllerTest {

  @InjectMocks
  private Controller controller;

  @Mock
  private Stack stack;

  @Test
  public void testPush() {
    String body = "{\r\n" +
      "  \"Value\": 147,\r\n" +
      "  \"SpecifyDb\": \"Postgre\"\r\n" +
      "}";
    controller.pushValue(body);
  }

  @Test
  public void testPop() {
    controller.popValue();
  }

}
