package com.example.road.status;

public enum StreetStatus {
    Doing(0),Use(1),Fixing(2);
    private int value;

    StreetStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public static StreetStatus of(int value){
        for (StreetStatus status : StreetStatus.values()){
            if (status.getValue() == value){
                return status;
            }
        }
        return StreetStatus.Fixing;
    }
}
