package com.mallon.cardatabase.domain.dao;

import com.mallon.cardatabase.domain.dto.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long>{

    public Owner findOwnerByFirstname(String firstname);
}
