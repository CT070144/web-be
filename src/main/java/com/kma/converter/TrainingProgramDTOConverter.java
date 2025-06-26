package com.kma.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kma.models.TrainingProgramDTO;
import com.kma.models.TrainingProgramRequestDTO;
import com.kma.models.SubjectDTO;
import com.kma.models.SubjectRequestDTO;
import com.kma.repository.entities.TrainingProgram;
import com.kma.repository.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TrainingProgramDTOConverter {
    
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    @Autowired
    private SubjectDTOConverter subjectDTOConverter;
    
    public TrainingProgramDTO toDTO(TrainingProgram entity) {
        if (entity == null) return null;
        
        TrainingProgramDTO dto = new TrainingProgramDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setDuration(entity.getDuration());
        dto.setCampus(entity.getCampus());
        dto.setAdmissionPeriod(entity.getAdmissionPeriod());
        dto.setOverview(entity.getOverview());
        dto.setImageUrl(entity.getImageUrl());
        dto.setDomesticTuition(entity.getDomesticTuition());
        dto.setInternationalTuition(entity.getInternationalTuition());
        dto.setTuitionNotes(entity.getTuitionNotes());
        dto.setIsActive(entity.getIsActive());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        
        // Convert JSON strings to lists
        try {
            if (entity.getRequirements() != null) {
                dto.setRequirements(objectMapper.readValue(entity.getRequirements(), new TypeReference<List<String>>() {}));
            }
            if (entity.getMaterials() != null) {
                dto.setMaterials(objectMapper.readValue(entity.getMaterials(), new TypeReference<List<String>>() {}));
            }
            if (entity.getCareers() != null) {
                dto.setCareers(objectMapper.readValue(entity.getCareers(), new TypeReference<List<String>>() {}));
            }
            if (entity.getOutcomes() != null) {
                dto.setOutcomes(objectMapper.readValue(entity.getOutcomes(), new TypeReference<List<TrainingProgramDTO.LearningOutcome>>() {}));
            }
        } catch (JsonProcessingException e) {
            // Handle exception or log error
        }
        
        // Convert subjects
        if (entity.getSubjects() != null) {
            List<SubjectDTO> subjectDTOs = entity.getSubjects().stream()
                    .map(subjectDTOConverter::toDTO)
                    .collect(Collectors.toList());
            dto.setSubjects(subjectDTOs);
        }
        
        return dto;
    }
    
    public TrainingProgram toEntity(TrainingProgramRequestDTO dto) {
        if (dto == null) return null;
        
        TrainingProgram entity = new TrainingProgram();
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setDuration(dto.getDuration());
        entity.setCampus(dto.getCampus());
        entity.setAdmissionPeriod(dto.getAdmissionPeriod());
        entity.setOverview(dto.getOverview());
        entity.setImageUrl(dto.getImageUrl());
        entity.setDomesticTuition(dto.getDomesticTuition());
        entity.setInternationalTuition(dto.getInternationalTuition());
        entity.setTuitionNotes(dto.getTuitionNotes());
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        
        // Convert lists to JSON strings
        try {
            if (dto.getRequirements() != null) {
                entity.setRequirements(objectMapper.writeValueAsString(dto.getRequirements()));
            }
            if (dto.getMaterials() != null) {
                entity.setMaterials(objectMapper.writeValueAsString(dto.getMaterials()));
            }
            if (dto.getCareers() != null) {
                entity.setCareers(objectMapper.writeValueAsString(dto.getCareers()));
            }
            if (dto.getOutcomes() != null) {
                entity.setOutcomes(objectMapper.writeValueAsString(dto.getOutcomes()));
            }
        } catch (JsonProcessingException e) {
            // Handle exception or log error
        }
        
        return entity;
    }
    
    public TrainingProgram updateEntity(TrainingProgram entity, TrainingProgramRequestDTO dto) {
        if (entity == null || dto == null) return entity;
        
        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getCode() != null) entity.setCode(dto.getCode());
        if (dto.getDuration() != null) entity.setDuration(dto.getDuration());
        if (dto.getCampus() != null) entity.setCampus(dto.getCampus());
        if (dto.getAdmissionPeriod() != null) entity.setAdmissionPeriod(dto.getAdmissionPeriod());
        if (dto.getOverview() != null) entity.setOverview(dto.getOverview());
        if (dto.getImageUrl() != null) entity.setImageUrl(dto.getImageUrl());
        if (dto.getDomesticTuition() != null) entity.setDomesticTuition(dto.getDomesticTuition());
        if (dto.getInternationalTuition() != null) entity.setInternationalTuition(dto.getInternationalTuition());
        if (dto.getTuitionNotes() != null) entity.setTuitionNotes(dto.getTuitionNotes());
        if (dto.getIsActive() != null) entity.setIsActive(dto.getIsActive());
        
        // Update JSON strings
        try {
            if (dto.getRequirements() != null) {
                entity.setRequirements(objectMapper.writeValueAsString(dto.getRequirements()));
            }
            if (dto.getMaterials() != null) {
                entity.setMaterials(objectMapper.writeValueAsString(dto.getMaterials()));
            }
            if (dto.getCareers() != null) {
                entity.setCareers(objectMapper.writeValueAsString(dto.getCareers()));
            }
            if (dto.getOutcomes() != null) {
                entity.setOutcomes(objectMapper.writeValueAsString(dto.getOutcomes()));
            }
        } catch (JsonProcessingException e) {
            // Handle exception or log error
        }
        
        return entity;
    }
}
