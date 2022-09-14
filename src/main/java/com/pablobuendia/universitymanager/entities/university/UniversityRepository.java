package com.pablobuendia.universitymanager.entities.university;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {

  // Join fetch all the associated entities so it gets all retrieved on the same query
  @Query("SELECT university FROM University university " +
      "JOIN FETCH university.students students " +
      "JOIN FETCH students.address address " +
      "JOIN FETCH address.city city " +
      "JOIN FETCH city.country country " +
      "where university.id = ?1")
  Optional<University> retrieveById(Long id);
}
