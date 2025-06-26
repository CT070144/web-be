package com.kma.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectRequestDTO {
    
    private String tenMon;
    private String maMon;
    private Integer soTinChi;
    private Integer hocKy;
    private String moTa;
    private String category;
}
 