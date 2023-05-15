package com.jewelry.jew.repository;

import com.jewelry.jew.entity.Jewelry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JewelryRepository extends CrudRepository<Jewelry, Long> {

//    List<Jewelry> findAll(); // хер его знает надо ли это тут
}
