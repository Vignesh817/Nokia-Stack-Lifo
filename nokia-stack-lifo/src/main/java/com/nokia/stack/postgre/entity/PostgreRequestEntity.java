package com.nokia.stack.postgre.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Entity

/**
 * Instantiates a new postgre request entity.
 */
@NoArgsConstructor
@Table(name="PostgreStackStore")
public class PostgreRequestEntity {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "ID")
  private int id;

  /** The pushed value. */
  @Column(
    name = "PUSHED_VALUE", nullable= false)
  private int pushedValue;
  
  /** The poped value. */
  @Column(
    name = "POPED_VALUE", nullable= false)
  private int popedValue;

}
