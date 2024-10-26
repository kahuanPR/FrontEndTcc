package com.example.Front_END_TCC.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Front_END_TCC.Model.Curriculum;

@Repository
public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {
    Curriculum findByFreelancerId(Long freelancerId);
}
