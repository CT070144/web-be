package com.kma.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {
    
    private Long id;
    private String tenMon;
    private String maMon;
    private Integer soTinChi;
    private Integer hocKy;
    private String moTa;
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 