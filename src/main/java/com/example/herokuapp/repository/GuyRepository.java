package com.example.herokuapp.repository;

import com.example.herokuapp.entity.Guy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuyRepository extends JpaRepository<Guy,Long>{

}