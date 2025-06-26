package com.kma.services.Impl;

import com.kma.converter.TrainingProgramDTOConverter;
import com.kma.models.TrainingProgramDTO;
import com.kma.models.TrainingProgramRequestDTO;
import com.kma.repository.TrainingProgramRepo;
import com.kma.repository.SubjectRepo;
import com.kma.repository.entities.TrainingProgram;
import com.kma.repository.entities.Subject;
import com.kma.services.TrainingProgramService;
import com.kma.utilities.buildErrorResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class TrainingProgramServImpl implements TrainingProgramService {
    
    @Autowired
    private TrainingProgramRepo trainingProgramRepo;
    
    @Autowired
    private SubjectRepo subjectRepo;
    
    @Autowired
    private TrainingProgramDTOConverter converter;
    
    @Override
    public List<TrainingProgramDTO> getAllActivePrograms() {
        List<TrainingProgram> programs = trainingProgramRepo.findByIsActiveTrueWithSubjects();
        return programs.stream()
                .map(converter::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public TrainingProgramDTO getProgramById(Long id) {
        TrainingProgram program = trainingProgramRepo.findByIdAndIsActiveTrueWithSubjects(id)
                .orElseThrow(() -> new RuntimeException("Chương trình đào tạo không tồn tại"));
        return converter.toDTO(program);
    }
    
    @Override
    public TrainingProgramDTO getProgramByCode(String code) {
        TrainingProgram program = trainingProgramRepo.findByCodeAndIsActiveTrueWithSubjects(code)
                .orElseThrow(() -> new RuntimeException("Chương trình đào tạo không tồn tại"));
        return converter.toDTO(program);
    }
    
    @Override
    public List<TrainingProgramDTO> searchPrograms(String keyword) {
        List<TrainingProgram> programs = trainingProgramRepo.searchActiveProgramsWithSubjects(keyword);
        return programs.stream()
                .map(converter::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public TrainingProgramDTO createProgram(TrainingProgramRequestDTO request) {
        // Validate unique code
        if (trainingProgramRepo.existsByCode(request.getCode())) {
            throw new RuntimeException("Mã chương trình đào tạo đã tồn tại");
        }
        
        TrainingProgram program = converter.toEntity(request);
        
        // Handle subjects if provided
        if (request.getSubjects() != null && !request.getSubjects().isEmpty()) {
            Set<Subject> subjects = request.getSubjects().stream()
                    .map(subjectRequest -> {
                        // Check if subject exists by maMon
                        Subject existingSubject = subjectRepo.findByMaMon(subjectRequest.getMaMon()).orElse(null);
                        if (existingSubject != null) {
                            return existingSubject;
                        } else {
                            // Create new subject
                            Subject newSubject = new Subject();
                            newSubject.setTenMon(subjectRequest.getTenMon());
                            newSubject.setMaMon(subjectRequest.getMaMon());
                            newSubject.setSoTinChi(subjectRequest.getSoTinChi());
                            newSubject.setHocKy(subjectRequest.getHocKy());
                            newSubject.setMoTa(subjectRequest.getMoTa());
                            newSubject.setCategory(subjectRequest.getCategory());
                            return subjectRepo.save(newSubject);
                        }
                    })
                    .collect(Collectors.toSet());
            program.setSubjects(subjects);
        }
        
        TrainingProgram savedProgram = trainingProgramRepo.save(program);
        return converter.toDTO(savedProgram);
    }
    
    @Override
    public TrainingProgramDTO updateProgram(Long id, TrainingProgramRequestDTO request) {
        TrainingProgram existingProgram = trainingProgramRepo.findByIdAndIsActiveTrueWithSubjects(id)
                .orElseThrow(() -> new RuntimeException("Chương trình đào tạo không tồn tại"));
        
        // Validate unique code if changed
        if (request.getCode() != null && !request.getCode().equals(existingProgram.getCode())) {
            if (trainingProgramRepo.existsByCodeAndIdNot(request.getCode(), id)) {
                throw new RuntimeException("Mã chương trình đào tạo đã tồn tại");
            }
        }
        
        TrainingProgram updatedProgram = converter.updateEntity(existingProgram, request);
        
        // Handle subjects if provided
        if (request.getSubjects() != null) {
            Set<Subject> subjects = request.getSubjects().stream()
                    .map(subjectRequest -> {
                        // Check if subject exists by maMon
                        Subject existingSubject = subjectRepo.findByMaMon(subjectRequest.getMaMon()).orElse(null);
                        if (existingSubject != null) {
                            return existingSubject;
                        } else {
                            // Create new subject
                            Subject newSubject = new Subject();
                            newSubject.setTenMon(subjectRequest.getTenMon());
                            newSubject.setMaMon(subjectRequest.getMaMon());
                            newSubject.setSoTinChi(subjectRequest.getSoTinChi());
                            newSubject.setHocKy(subjectRequest.getHocKy());
                            newSubject.setMoTa(subjectRequest.getMoTa());
                            newSubject.setCategory(subjectRequest.getCategory());
                            return subjectRepo.save(newSubject);
                        }
                    })
                    .collect(Collectors.toSet());
            updatedProgram.setSubjects(subjects);
        }
        
        TrainingProgram savedProgram = trainingProgramRepo.save(updatedProgram);
        return converter.toDTO(savedProgram);
    }
    
    @Override
    public void deleteProgram(Long id) {
        TrainingProgram program = trainingProgramRepo.findByIdAndIsActiveTrueWithSubjects(id)
                .orElseThrow(() -> new RuntimeException("Chương trình đào tạo không tồn tại"));
        trainingProgramRepo.delete(program);
    }
    
    @Override
    public void deactivateProgram(Long id) {
        TrainingProgram program = trainingProgramRepo.findByIdAndIsActiveTrueWithSubjects(id)
                .orElseThrow(() -> new RuntimeException("Chương trình đào tạo không tồn tại"));
        program.setIsActive(false);
        trainingProgramRepo.save(program);
    }
} 