package com.project.coches.persistance.crud;

import com.project.coches.persistance.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClienteCrudRepository extends JpaRepository<ClienteEntity, String> {

    Optional<ClienteEntity> findByEmail(String email);
}
