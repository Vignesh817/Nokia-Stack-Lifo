package com.nokia.stack.maria.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity

/**
 * Instantiates a new maria request entity.
 *
 * @param id the id
 * @param pushedValue the pushed value
 * @param popedValue the poped value
 */
@AllArgsConstructor

/**
 * Instantiates a new maria request entity.
 */
@NoArgsConstructor
@Table(name = "MariaStackStore")
public class MariaRequestEntity {

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
