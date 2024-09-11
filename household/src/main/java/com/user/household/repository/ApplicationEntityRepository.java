package com.user.household.repository;

import com.user.household.model.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationEntityRepository extends JpaRepository<ApplicationEntity, Integer> {

    @Query("select details from ApplicationEntity details where details.brand=?1")
    List<ApplicationEntity> findByApplicationName(String name);
}
