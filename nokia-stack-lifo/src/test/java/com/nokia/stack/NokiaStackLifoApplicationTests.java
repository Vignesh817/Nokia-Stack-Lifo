package com.nokia.stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * The Class NokiaStackLifoApplicationTests.
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class NokiaStackLifoApplicationTests {

  /** The app. */
  @InjectMocks
  private NokiaStackLifoApplication app;

  /**
   * Main test.
   */
  @Test
  public void mainTest() {
    String args[] = {"1", "2"};
    NokiaStackLifoApplication.main(args);
  }

}
