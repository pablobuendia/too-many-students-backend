package com.pablobuendia.universitymanager.entities.address.city;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class CityRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(City city) {
        entityManager.persist(city);
    }
}
