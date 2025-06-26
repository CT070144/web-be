package com.kma.converter;

import com.kma.models.SubjectDTO;
import com.kma.models.SubjectRequestDTO;
import com.kma.repository.entities.Subject;
import org.springframework.stereotype.Component;

@Component
public class SubjectDTOConverter {
    
    public SubjectDTO toDTO(Subject entity) {
        if (entity == null) return null;
        
        SubjectDTO dto = new SubjectDTO();
        dto.setId(entity.getId());
        dto.setTenMon(entity.getTenMon());
        dto.setMaMon(entity.getMaMon());
        dto.setSoTinChi(entity.getSoTinChi());
        dto.setHocKy(entity.getHocKy());
        dto.setMoTa(entity.getMoTa());
        dto.setCategory(entity.getCategory());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        
        return dto;
    }
    
    public Subject toEntity(SubjectRequestDTO dto) {
        if (dto == null) return null;
        
        Subject entity = new Subject();
        entity.setTenMon(dto.getTenMon());
        entity.setMaMon(dto.getMaMon());
        entity.setSoTinChi(dto.getSoTinChi());
        entity.setHocKy(dto.getHocKy());
        entity.setMoTa(dto.getMoTa());
        entity.setCategory(dto.getCategory());
        
        return entity;
    }
    
    public Subject updateEntity(Subject entity, SubjectRequestDTO dto) {
        if (entity == null || dto == null) return entity;
        
        if (dto.getTenMon() != null) entity.setTenMon(dto.getTenMon());
        if (dto.getMaMon() != null) entity.setMaMon(dto.getMaMon());
        if (dto.getSoTinChi() != null) entity.setSoTinChi(dto.getSoTinChi());
        if (dto.getHocKy() != null) entity.setHocKy(dto.getHocKy());
        if (dto.getMoTa() != null) entity.setMoTa(dto.getMoTa());
        if (dto.getCategory() != null) entity.setCategory(dto.getCategory());
        
        return entity;
    }
} 