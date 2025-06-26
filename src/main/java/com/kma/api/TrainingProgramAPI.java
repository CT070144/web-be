package com.kma.api;

import com.kma.dto.APIResponse;
import com.kma.models.TrainingProgramDTO;
import com.kma.models.TrainingProgramRequestDTO;
import com.kma.services.TrainingProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training-programs")

public class TrainingProgramAPI {
    
    @Autowired
    private TrainingProgramService trainingProgramService;
    
    @GetMapping
    public ResponseEntity<APIResponse<List<TrainingProgramDTO>>> getAllPrograms() {

        try {
            List<TrainingProgramDTO> programs = trainingProgramService.getAllActivePrograms();
            return ResponseEntity.ok(APIResponse.<List<TrainingProgramDTO>>builder()
                    .result(programs)
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(APIResponse.<List<TrainingProgramDTO>>builder()
                            .result(null)
                            .build());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<TrainingProgramDTO>> getProgramById(@PathVariable Long id) {
        try {
            TrainingProgramDTO program = trainingProgramService.getProgramById(id);
            return ResponseEntity.ok(APIResponse.<TrainingProgramDTO>builder()
                    .result(program)
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(APIResponse.<TrainingProgramDTO>builder()
                            .result(null)
                            .build());
        }
    }
    
    @GetMapping("/code/{code}")
    public ResponseEntity<APIResponse<TrainingProgramDTO>> getProgramByCode(@PathVariable String code) {
        try {
            TrainingProgramDTO program = trainingProgramService.getProgramByCode(code);
            return ResponseEntity.ok(APIResponse.<TrainingProgramDTO>builder()
                    .result(program)
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(APIResponse.<TrainingProgramDTO>builder()
                            .result(null)
                            .build());
        }
    }
    
    @GetMapping("/search")
    public ResponseEntity<APIResponse<List<TrainingProgramDTO>>> searchPrograms(@RequestParam String keyword) {
        try {
            List<TrainingProgramDTO> programs = trainingProgramService.searchPrograms(keyword);
            return ResponseEntity.ok(APIResponse.<List<TrainingProgramDTO>>builder()
                    .result(programs)
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(APIResponse.<List<TrainingProgramDTO>>builder()
                            .result(null)
                            .build());
        }
    }
    
    @PostMapping
    public ResponseEntity<APIResponse<TrainingProgramDTO>> createProgram(@RequestBody TrainingProgramRequestDTO request) {
        try {
            TrainingProgramDTO createdProgram = trainingProgramService.createProgram(request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(APIResponse.<TrainingProgramDTO>builder()
                            .result(createdProgram)
                            .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(APIResponse.<TrainingProgramDTO>builder()
                            .result(null)
                            .build());
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<TrainingProgramDTO>> updateProgram(@PathVariable Long id, @RequestBody TrainingProgramRequestDTO request) {
        try {
            TrainingProgramDTO updatedProgram = trainingProgramService.updateProgram(id, request);
            return ResponseEntity.ok(APIResponse.<TrainingProgramDTO>builder()
                    .result(updatedProgram)
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(APIResponse.<TrainingProgramDTO>builder()
                            .result(null)
                            .build());
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> deleteProgram(@PathVariable Long id) {
        try {
            trainingProgramService.deleteProgram(id);
            return ResponseEntity.ok(APIResponse.<Void>builder()
                    .result(null)
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(APIResponse.<Void>builder()
                            .result(null)
                            .build());
        }
    }
    
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<APIResponse<Void>> deactivateProgram(@PathVariable Long id) {
        try {
            trainingProgramService.deactivateProgram(id);
            return ResponseEntity.ok(APIResponse.<Void>builder()
                    .result(null)
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(APIResponse.<Void>builder()
                            .result(null)
                            .build());
        }
    }
}
