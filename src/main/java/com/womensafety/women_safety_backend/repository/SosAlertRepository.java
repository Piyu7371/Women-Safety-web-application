package com.womensafety.women_safety_backend.repository;

import com.womensafety.women_safety_backend.entity.SosAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SosAlertRepository extends JpaRepository<SosAlert, Long> {

    List<SosAlert> findByStatus(String status);
}
