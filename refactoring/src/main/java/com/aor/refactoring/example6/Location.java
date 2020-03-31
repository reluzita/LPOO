package com.aor.refactoring.example6;

public class Location {
    public String latitude;
    public String longitude;
    public String name;

    public Location(String locationLatitude, String locationLongitude, String locationName){
        this.latitude = locationLatitude;
        this.longitude = locationLongitude;
        this.name = locationName;
    }

    public String toString() {
        return this.latitude + "," + this.longitude + " (" + this.name + ")";
    }
}
