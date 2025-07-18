package com.kma.repository;

import com.kma.repository.entities.Lop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface lopRepo extends JpaRepository<Lop, Integer> {
    Lop findByTenLop(String tenLop);

    boolean existsByTenLop(String tenLop);

    //JPQL
    @Query("SELECT lop FROM Lop lop " +
            "WHERE lop.tenLop LIKE :tenLop " +
            "ORDER BY lop.tenLop ASC")
    Page<Lop> findByAllCondition(@Param("tenLop") String tenLop, Pageable pageable);
}
