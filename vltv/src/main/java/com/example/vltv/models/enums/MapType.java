package com.example.vltv.models.enums;

public enum MapType {
    ASCENT("Ascent"),
    FRACTURE("Fracture"),
    HEAVEN("Heaven"),
    BIND("Bind");

    private String name;

    MapType(String nameMap){
        this.name = nameMap;
    }

    public String getName() {
        return name;
    }
}
