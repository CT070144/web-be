package com.kma.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingProgramDTO {
    
    private Long id;
    private String name;
    private String code;
    private String duration;
    private String campus;
    private String admissionPeriod;
    private String overview;
    private String imageUrl;
    private String domesticTuition;
    private String internationalTuition;
    private String tuitionNotes;
    private List<String> requirements;
    private List<String> materials;
    private List<String> careers;
    private List<LearningOutcome> outcomes;
    private List<SubjectDTO> subjects;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LearningOutcome {
        private String id;
        private String title;
        private String content;
    }
}
