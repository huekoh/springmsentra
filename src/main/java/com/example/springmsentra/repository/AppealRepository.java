package com.example.springmsentra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springmsentra.entities.Appeal;
import org.springframework.stereotype.Repository;

@Repository
public interface AppealRepository extends JpaRepository<Appeal, String> {
    Appeal findByNric(String nric);
}
