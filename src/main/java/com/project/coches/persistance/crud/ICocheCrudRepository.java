package com.project.coches.persistance.crud;

import com.project.coches.persistance.entity.CocheEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICocheCrudRepository extends JpaRepository<CocheEntity, Integer> {

    List<CocheEntity> findAllByMarcaCocheId(Integer id);

    List<CocheEntity> findAllByPriceLessThanOrderByPriceDesc(Double price);


}