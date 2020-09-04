package com.nokia.stack.maria.repository;

import com.nokia.stack.maria.entity.MariaRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface RepositoryMaria.
 */
@Repository
public interface RepositoryMaria extends JpaRepository<MariaRequestEntity, Integer> {

}
