package com.example.paint_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.paint_backend.dto.ShapeDTO;
import com.example.paint_backend.dto.shape_creation_request.ShapeFinalizeRequest;
import com.example.paint_backend.dto.shape_creation_request.ShapeRequest;
import com.example.paint_backend.dto.shape_creation_request.ShapeUpdateRequest;
import com.example.paint_backend.service.ShapeCreationService;

@RestController
@RequestMapping("/api/shapes/")
@CrossOrigin(origins = "${app.cors.allowed-origins}")
public class ShapesCreatorController {

    private final ShapeCreationService shapeService;

    public ShapesCreatorController(ShapeCreationService shapeService) {
        this.shapeService = shapeService;
    }

    @PostMapping("/create")
    public ResponseEntity<ShapeDTO> createShape(@RequestBody ShapeRequest shapeRequest) {
        System.out.println("Received shape creation request: " + shapeRequest);
        ShapeDTO createdShape = shapeService.createShape(shapeRequest);
        return ResponseEntity.ok(createdShape);
    }

    @PutMapping("/{shapeId}")
    public ResponseEntity<ShapeDTO> updateShape(
            @PathVariable Long shapeId,
            @RequestBody ShapeUpdateRequest request) {
        System.out.println("Received shape update request for ID: " + shapeId);
        ShapeDTO updatedShape = shapeService.updateShape(shapeId, request);
        return ResponseEntity.ok(updatedShape);
    }

    @PutMapping("/{shapeId}/finalize")
    public ResponseEntity<ShapeDTO> finalizeShape(
            @PathVariable Long shapeId,
            @RequestBody ShapeFinalizeRequest request) {
        System.out.println("Received shape finalization request for ID: " + shapeId);
        ShapeDTO finalizedShape = shapeService.finalizeShape(shapeId, request);
        return ResponseEntity.ok(finalizedShape);
    }

}