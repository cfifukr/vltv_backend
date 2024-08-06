package com.example.vltv.models.enums;

public enum GameStage {
    GROUP_STAGE("Group stage"),
    ONE_SIXTEEN_FINAL("1/16"),
    ONE_EIGHT_FINAL("1/8"),
    QUATERFINAL("1/4"),
    SEMIFINAL("1/2"),
    THIRD_PLACE_GAME("Third place game"),
    FINAL("final");
    private String stage;

    GameStage(String stage){
        this.stage = stage;
    }
    public String getStage(){
        return stage;
    }

}
