package com.example.paint_backend.ShapesCreator;

import org.json.JSONObject;

public interface Shapes {
    public void DemensionCalculate();
    public void setEndPoints( double xEnd, double yEnd);
    public JSONObject toJsonObject();
}
