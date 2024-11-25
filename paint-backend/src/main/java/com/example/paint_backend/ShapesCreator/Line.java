package com.example.paint_backend.ShapesCreator;

import org.json.JSONArray;
import org.json.JSONObject;
public class Line implements Shapes {

    int shapeId;
    double xStart;
    double yStart;
    double xEnd;
    double yEnd;
    String firstColor;
    int lineWidth;
    String shapeType;

    public Line(JSONObject json) {
        this.shapeId = json.getInt("shapeId");
        this.xStart = json.getDouble("xStart");
        this.yStart = json.getDouble("yStart");
        this.xEnd = json.getDouble("xEnd");
        this.yEnd = json.getDouble("yEnd");
        this.firstColor = json.getString("firstColor");
        this.lineWidth = json.getInt("lineWidth");      
        this.shapeType = json.getString("shapetype");
    }

    @Override
    public void DemensionCalculate() {
        
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
        json.put("points", new JSONArray().put(this.xStart).put(this.yStart).put(this.xEnd).put(this.yEnd));
        json.put("firstColor", this.firstColor);
        json.put("lineWidth", this.lineWidth);
        json.put("shapetype", this.shapeType);
        return json;
    }

}
