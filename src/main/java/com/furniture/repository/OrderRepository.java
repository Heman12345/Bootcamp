package com.furniture.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furniture.entity.FurnitureOrder;

@Repository
public interface OrderRepository extends JpaRepository<FurnitureOrder, String> {

}