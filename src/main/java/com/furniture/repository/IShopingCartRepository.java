package com.furniture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furniture.entity.Cart;

@Repository
public interface IShopingCartRepository extends JpaRepository<Cart,Integer>
{

}
