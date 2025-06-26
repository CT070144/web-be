package com.kma.repository;

import com.kma.repository.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {
    
    Optional<Subject> findByMaMon(String maMon);
    
    boolean existsByMaMonAndIdNot(String maMon, Long id);
    
    boolean existsByMaMon(String maMon);
    
    @Query("SELECT s FROM Subject s JOIN s.trainingPrograms tp WHERE tp.id = :programId ORDER BY s.hocKy, s.tenMon")
    List<Subject> findSubjectsByProgramId(@Param("programId") Long programId);
    
    @Query("SELECT s FROM Subject s JOIN s.trainingPrograms tp WHERE tp.id = :programId AND s.hocKy = :hocKy ORDER BY s.tenMon")
    List<Subject> findSubjectsByProgramIdAndHocKy(@Param("programId") Long programId, @Param("hocKy") Integer hocKy);
    
    @Query("SELECT s FROM Subject s WHERE s.maMon IN :maMonList")
    Set<Subject> findByMaMonIn(@Param("maMonList") List<String> maMonList);
} 