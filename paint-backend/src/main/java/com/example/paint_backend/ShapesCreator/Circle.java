package com.example.paint_backend.ShapesCreator;

import org.json.JSONObject;

public class Circle implements Shapes  {
    int shapeId;

    double xEnd;
    double yEnd;
    double xStart;
    double yStart;
    String firstColor;
    String secondColor;
    int lineWidth;
    double radius;
    String shapeType;

    public Circle(JSONObject json) {
        this.shapeId = json.getInt("shapeId");
        this.xEnd = json.getDouble("xEnd");
        this.yEnd = json.getDouble("yEnd");
        this.xStart = json.getDouble("xStart");
        this.yStart = json.getDouble("yStart");
        this.firstColor = json.getString("firstColor");
        this.secondColor = json.getString("secondColor");
        this.lineWidth = json.getInt("lineWidth");  
        this.shapeType = json.getString("shapetype");
    }
    @Override
    public void setEndPoints( double xEnd, double yEnd){
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }   
    @Override
    public void DemensionCalculate() {
        this.radius = Math.sqrt((xEnd - xStart) * (xEnd - xStart) + (yEnd - yStart) * (yEnd - yStart));
    }
    @Override
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        json.put("shapeId", this.shapeId);
        json.put("radius", this.radius);
        json.put("xStart", this.xStart);
        json.put("yStart", this.yStart);
        json.put("firstColor", this.firstColor);
        json.put("secondColor", this.secondColor);
        json.put("lineWidth", this.lineWidth);  
        json.put("shapetype", this.shapeType);
        return json;
    }
}

