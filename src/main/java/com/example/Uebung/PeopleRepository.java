package com.example.Uebung;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PeopleRepository extends JpaRepository<People, Long> {
}
