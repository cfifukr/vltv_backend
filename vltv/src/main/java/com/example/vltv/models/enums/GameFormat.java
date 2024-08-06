package com.example.vltv.models.enums;

public enum GameFormat {
    BO1("BO1", 1),
    BO2("BO2", 2),
    BO3("BO3", 3),
    BO5("BO5", 5),
    BO7("BO7", 7);

    private String shortName;
    private Integer maxMaps;

    GameFormat(String shortName, Integer maxMaps){
        this.shortName = shortName;
        this.maxMaps = maxMaps;
    }

    public String getShortName() {
        return shortName;
    }

    public Integer getMaxMaps() {
        return maxMaps;
    }
}
