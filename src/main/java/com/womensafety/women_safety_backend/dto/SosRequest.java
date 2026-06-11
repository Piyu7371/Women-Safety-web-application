package com.womensafety.women_safety_backend.dto;

import com.womensafety.women_safety_backend.entity.User;

public class SosRequest {

    private User user;
    private Double latitude;
    private Double longitude;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
