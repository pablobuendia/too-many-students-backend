package com.pablobuendia.universitymanager.entities.address.city;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class CityRepositoryImpl {

  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  public void save(City city) {
    entityManager.persist(city);
  }
}
