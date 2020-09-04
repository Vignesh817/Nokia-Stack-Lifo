package com.nokia.stack.postgre.repository;

import com.nokia.stack.postgre.entity.PostgreRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface RepositoryPostgre.
 */
@Repository
public interface RepositoryPostgre extends JpaRepository<PostgreRequestEntity, Integer> {

}
