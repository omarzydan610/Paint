package com.example.paint_backend.ShapesCreator;

import org.json.JSONObject;

public class Ellipse implements Shapes {
    double xEnd;
    double yEnd;
    double xStart;
    double yStart;
    String firstColor;
    String secondColor;
    int lineWidth;
    double radiusX;
    double radiusY;
    int shapeId;
    String shapeType;
    public Ellipse(JSONObject json) {
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
    public void DemensionCalculate() {
        this.radiusX = Math.abs(xEnd - xStart);
        this.radiusY = Math.abs(yEnd - yStart);
    }
    @Override
    public void setEndPoints( double xEnd, double yEnd){
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }
    @Override
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        json.put("shapeId", this.shapeId);
        json.put("radiusX", this.radiusX);
        json.put("radiusY", this.radiusY);
        json.put("xStart", this.xStart);
        json.put("yStart", this.yStart);
        json.put("firstColor", this.firstColor);
        json.put("secondColor", this.secondColor);
        json.put("lineWidth", this.lineWidth);  
        json.put("shapetype", this.shapeType);
        return json;
    }
}
