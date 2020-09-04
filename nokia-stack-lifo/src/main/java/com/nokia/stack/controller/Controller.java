package com.nokia.stack.controller;

import com.nokia.stack.constants.Constants;
import com.nokia.stack.service.Stack;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class Controller.
 */
@RestController
public class Controller {
  
  /** The stack. */
  @Autowired
  private Stack stack;

  /**
   * Push value.
   *
   * @param value the value
   * @return the string
   */
  @PostMapping("/push")
  public String pushValue(@RequestBody String value) {
    JSONObject json = new JSONObject(value);
    return stack.push(json.getInt(Constants.VALUE.getValue()), json.getString(Constants.SPECIFY_DB.getValue()));

  }

  /**
   * Pop value.
   *
   * @return the string
   */
  @GetMapping("/pop")
  public String popValue() {
    return stack.pop();

  }

}
