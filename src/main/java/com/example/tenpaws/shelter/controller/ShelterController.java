package com.example.tenpaws.shelter.controller;

import com.example.tenpaws.shelter.dto.ShelterRequestDTO;
import com.example.tenpaws.shelter.dto.ShelterResponseDTO;
import com.example.tenpaws.shelter.entity.Shelter;
import com.example.tenpaws.shelter.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shelters")
public class ShelterController {

    private final ShelterService shelterService;

    @Autowired
    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    // 전체 쉘터 조회
    @GetMapping
    public List<ShelterResponseDTO> getAllShelters() {
        return shelterService.getAllShelters();
    }

    // ID로 쉘터 조회
    @GetMapping("/{id}")
    public ShelterResponseDTO getShelterById(@PathVariable Long id) {
        return shelterService.getShelterById(id);
    }

    // 쉘터 등록
    @PostMapping
    public ShelterResponseDTO createShelter(@RequestBody ShelterRequestDTO shelterRequestDTO) {
        return shelterService.createShelter(shelterRequestDTO);
    }

    // 쉘터 정보 수정
    @PutMapping("/{id}")
    public ShelterResponseDTO updateShelter(@PathVariable Long id, @RequestBody ShelterRequestDTO shelterRequestDTO) {
        return shelterService.updateShelter(id, shelterRequestDTO);
    }

    // 쉘터 삭제
    @DeleteMapping("/{id}")
    public void deleteShelter(@PathVariable Long id) {
        shelterService.deleteShelter(id);
    }
}

