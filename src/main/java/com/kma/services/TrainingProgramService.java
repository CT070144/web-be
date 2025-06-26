package com.kma.services;

import com.kma.models.TrainingProgramDTO;
import com.kma.models.TrainingProgramRequestDTO;
import java.util.List;

public interface TrainingProgramService {
    
    List<TrainingProgramDTO> getAllActivePrograms();
    
    TrainingProgramDTO getProgramById(Long id);
    
    TrainingProgramDTO getProgramByCode(String code);
    
    List<TrainingProgramDTO> searchPrograms(String keyword);
    
    TrainingProgramDTO createProgram(TrainingProgramRequestDTO request);
    
    TrainingProgramDTO updateProgram(Long id, TrainingProgramRequestDTO request);
    
    void deleteProgram(Long id);
    
    void deactivateProgram(Long id);
}
