package com.example.paint_backend.ShapesCreator;

import org.json.JSONObject;

public class Square implements Shapes {
    int shapeId;
    double xEnd;
    double yEnd;
    double xStart;
    double yStart;
    String firstColor;
    String secondColor;
    int lineWidth;
    double side;
    String shapeType;
    public Square(JSONObject json) {
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
        double length = Math.abs(xEnd - xStart);
        double width = Math.abs(yEnd - yStart);
        this.side = Math.min(length, width);
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
        json.put("side", this.side);    
        json.put("xStart", this.xStart);
        json.put("yStart", this.yStart);
        json.put("firstColor", this.firstColor);
        json.put("secondColor", this.secondColor);
        json.put("lineWidth", this.lineWidth);  
        json.put("shapetype", this.shapeType);
        return json;
    }
}
