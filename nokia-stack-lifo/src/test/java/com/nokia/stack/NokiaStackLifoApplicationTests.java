package com.nokia.stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class NokiaStackLifoApplicationTests {

  @InjectMocks
  private NokiaStackLifoApplication app;

  @Test
  public void mainTest() {
    String args[] = {"1", "2"};
    NokiaStackLifoApplication.main(args);
  }

}
