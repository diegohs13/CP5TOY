package com.example.cp5sec.repository;

import com.example.cp5sec.domain.Brinquedo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrinquedoRepository extends JpaRepository<Brinquedo, Integer> {
}
