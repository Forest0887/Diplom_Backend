package com.jewelry.jew.repository;

import com.jewelry.jew.entity.Jewelry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewelryRepository extends CrudRepository<Jewelry, Long> {
}
