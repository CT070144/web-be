package com.kma.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "subject")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "ten_mon", nullable = false)
    private String tenMon;
    
    @Column(name = "ma_mon", nullable = false, unique = true)
    private String maMon;
    
    @Column(name = "so_tin_chi")
    private Integer soTinChi;
    
    @Column(name = "hoc_ky")
    private Integer hocKy;
    
    @Column(name = "mo_ta", columnDefinition = "TEXT")
    private String moTa;
    
    @Column(name = "category")
    private String category;
    
    @ManyToMany(mappedBy = "subjects")
    private Set<TrainingProgram> trainingPrograms;
} 