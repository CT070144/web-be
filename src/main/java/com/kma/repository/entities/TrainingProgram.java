package com.kma.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "training_program")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingProgram extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "code", nullable = false, unique = true)
    private String code;
    
    @Column(name = "duration")
    private String duration;
    
    @Column(name = "campus")
    private String campus;
    
    @Column(name = "admission_period")
    private String admissionPeriod;
    
    @Column(name = "overview", columnDefinition = "TEXT")
    private String overview;
    
    @Column(name = "image_url")
    private String imageUrl;
    
    @Column(name = "domestic_tuition")
    private String domesticTuition;
    
    @Column(name = "international_tuition")
    private String internationalTuition;
    
    @Column(name = "tuition_notes", columnDefinition = "TEXT")
    private String tuitionNotes;
    
    @Column(name = "requirements", columnDefinition = "TEXT")
    private String requirements;
    
    @Column(name = "materials", columnDefinition = "TEXT")
    private String materials;
    
    @Column(name = "careers", columnDefinition = "TEXT")
    private String careers;
    
    @Column(name = "outcomes", columnDefinition = "TEXT")
    private String outcomes;
    
    @Column(name = "is_active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isActive = true;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "training_program_subject",
        joinColumns = @JoinColumn(name = "training_program_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjects;
}
