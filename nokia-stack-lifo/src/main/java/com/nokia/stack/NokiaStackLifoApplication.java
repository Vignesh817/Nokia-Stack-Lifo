package com.nokia.stack;

import com.nokia.stack.constants.Constants;
import com.nokia.stack.service.Stack;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * The Class NokiaStackLifoApplication.
 */
@SpringBootApplication
public class NokiaStackLifoApplication {

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(NokiaStackLifoApplication.class, args);
    String str = context.getEnvironment().getProperty(Constants.STACK_SIZE.getValue());
    context.getBean(Stack.class).myStack(Integer.valueOf(str));
  }

}
