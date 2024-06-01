package com.example.springmsentra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springmsentra.entities.Appeal;

import java.util.List;

public interface AppealRepository extends JpaRepository<Appeal, String> {
    List<Appeal> findAllByNric(String nric);
}
