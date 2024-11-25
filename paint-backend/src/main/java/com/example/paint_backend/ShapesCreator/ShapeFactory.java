package com.example.paint_backend.ShapesCreator;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
@Service

   public class ShapeFactory {
    
    // Factory method to create objects based on the input
    public Shapes getShape(String shapeType , JSONObject json) {

        if (shapeType == null) {
            return null;
        }
        switch (shapeType.toLowerCase()) {
            case "circle":
                return new Circle(json);
            case "rectangle":
                return new Rectangle(json);
            case "square":
                return new Square(json);
            case "ellipse":
                return new Ellipse(json);   
            case "line":
                return new Line(json);
            // case "triangle":
            //     return new Triangle(json);
            default:
                return null;
        }
    }
}


