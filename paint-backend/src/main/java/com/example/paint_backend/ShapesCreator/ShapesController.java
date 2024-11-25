package com.example.paint_backend.ShapesCreator;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shapes")
public class ShapesController {

    int shapeId = 1;
    private List<Shapes> shapesList = new ArrayList<>();
    private JSONArray shapesArray = new JSONArray();

    @PostMapping("/create")
    public ResponseEntity<String> calculateRectangleDimensions(@RequestBody String rawRequest) {
        try {
            // Log the raw request body
            System.out.println("Received raw request: " + rawRequest);

            // Parse the raw request into a JSONObject
            JSONObject request = new JSONObject(rawRequest);
            Shapes shape ;  
            if (request.getInt("shapeId") == 0) {
            request.put("shapeId", shapeId);
                shape = new ShapeFactory().getShape(request.getString("shapetype"), request);
                shapeId++;  
            }else{
                shape= shapesList.get(request.getInt("shapeId"));
                shape.setEndPoints(request.getDouble("xEnd"), request.getDouble("yEnd"));
            }

            // Calculate dimensions
            shape.DemensionCalculate();
            shapesList.add(shape);
            JSONObject shapeJson = shape.toJsonObject();
            shapesArray.put(shapeJson);

            System.out.println("Rectangle dimensions: " + shapeJson.toString());
            return ResponseEntity.ok(shapeJson.toString());
        } catch (Exception e) {
            e.printStackTrace();
            JSONObject errorResponse = new JSONObject();
            errorResponse.put("error", "Invalid request: " + e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse.toString());
        }
    }

}
