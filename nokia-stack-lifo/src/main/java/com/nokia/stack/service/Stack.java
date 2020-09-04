package com.nokia.stack.service;

import com.nokia.stack.constants.Constants;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Class Stack.
 */
@Service
public class Stack {

  /** The db operation. */
  @Autowired
  private DbOperation dbOperation;

  /** The db name. */
  private String dbName;

  /** The stack array. */
  private int[] stackArray;

  /** The count. */
  private int count = -1;

  /** The size. */
  private int size;

  /**
   * My stack.
   *
   * @param arraySize the array size
   */
  public void myStack(int arraySize) {
    size = arraySize;
    stackArray = new int[size];
  }

  /**
   * Push.
   *
   * @param value the value
   * @param db the db
   * @return the string
   */
  public String push(int value, String db) {
    dbName = db;
    if (isStackFull()) {
      return "Stack Full";
    } else {
      String result = "";
      stackArray[++count] = value;
      if (dbName.equalsIgnoreCase(Constants.MARIA_PERSISTENCE_UNIT_NAME.getValue())) {
        result = dbOperation.saveToMariaDb(value);
      } else if (dbName.equalsIgnoreCase(Constants.POSTGRE_PERSISTENCE_UNIT_NAME.getValue())) {
        result = dbOperation.saveToPostgreDb(value);
      } else {
        return "Wrond db name entered";
      }
      return "Pushed value " + result + " : " + Arrays.toString(stackArray);
    }
  }

  /**
   * Pop.
   *
   * @return the string
   */
  public String pop() {
    if (isStackEmpty()) {
      return "Stack Empty";
    } else {
      String result = "";
      int pop = stackArray[count--];
      if (dbName.equalsIgnoreCase(Constants.MARIA_PERSISTENCE_UNIT_NAME.getValue())) {
        result = dbOperation.savePopedValueToMariaDb(pop);
      } else if (dbName.equalsIgnoreCase(Constants.POSTGRE_PERSISTENCE_UNIT_NAME.getValue())) {
        result = dbOperation.savePopedValueToPostgreDb(pop);
      } else {
        return "Wrond db name entered";
      }
      return "Poped value " + result + " : " + pop;
    }
  }

  /**
   * Checks if is stack full.
   *
   * @return true, if is stack full
   */
  public boolean isStackFull() {
    return (count == size - 1);
  }

  /**
   * Checks if is stack empty.
   *
   * @return true, if is stack empty
   */
  public boolean isStackEmpty() {
    return (count == -1);
  }
}
