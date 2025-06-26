package com.kma.repository;

import com.kma.repository.entities.TrainingProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TrainingProgramRepo extends JpaRepository<TrainingProgram, Long> {
    
    @Query("SELECT DISTINCT tp FROM TrainingProgram tp LEFT JOIN FETCH tp.subjects WHERE tp.isActive = true")
    List<TrainingProgram> findByIsActiveTrueWithSubjects();
    
    @Query("SELECT tp FROM TrainingProgram tp LEFT JOIN FETCH tp.subjects WHERE tp.id = :id AND tp.isActive = true")
    Optional<TrainingProgram> findByIdAndIsActiveTrueWithSubjects(@Param("id") Long id);
    
    @Query("SELECT tp FROM TrainingProgram tp LEFT JOIN FETCH tp.subjects WHERE tp.code = :code AND tp.isActive = true")
    Optional<TrainingProgram> findByCodeAndIsActiveTrueWithSubjects(@Param("code") String code);
    
    @Query("SELECT DISTINCT tp FROM TrainingProgram tp LEFT JOIN FETCH tp.subjects WHERE tp.isActive = true AND (tp.name LIKE %:keyword% OR tp.code LIKE %:keyword%)")
    List<TrainingProgram> searchActiveProgramsWithSubjects(@Param("keyword") String keyword);
    
    boolean existsByCodeAndIdNot(String code, Long id);
    
    boolean existsByCode(String code);
}
