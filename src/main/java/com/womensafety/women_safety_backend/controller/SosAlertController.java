package com.womensafety.women_safety_backend.controller;

import com.womensafety.women_safety_backend.dto.SosRequest;
import com.womensafety.women_safety_backend.entity.SosAlert;
import com.womensafety.women_safety_backend.service.SosAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sos")
public class SosAlertController {

    @Autowired
    private SosAlertService sosAlertService;

    // 🔴 Trigger SOS alert
    @PostMapping("/trigger")
    public SosAlert triggerSos(@RequestBody SosRequest request) {
        return sosAlertService.createSos(
                request.getUser(),
                request.getLatitude(),
                request.getLongitude()
        );
    }

    // 🟢 Get all ACTIVE SOS alerts
    @GetMapping("/active")
    public List<SosAlert> getActiveAlerts() {
        return sosAlertService.getActiveAlerts();
    }
}
