package com.project.coches.persistance.crud;

import com.project.coches.persistance.entity.MarcaCocheEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMarcaCocheCrudRepository extends JpaRepository<MarcaCocheEntity, Integer> {
}
