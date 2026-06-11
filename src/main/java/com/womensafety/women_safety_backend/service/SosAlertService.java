package com.womensafety.women_safety_backend.service;

import com.womensafety.women_safety_backend.entity.SosAlert;
import com.womensafety.women_safety_backend.entity.User;
import com.womensafety.women_safety_backend.repository.SosAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SosAlertService {

    @Autowired
    private SosAlertRepository sosAlertRepository;

    public SosAlert createSos(User user, Double latitude, Double longitude) {
        SosAlert sos = new SosAlert();
        sos.setUser(user);
        sos.setLatitude(latitude);
        sos.setLongitude(longitude);
        sos.setStatus("ACTIVE");

        return sosAlertRepository.save(sos);
    }

    public List<SosAlert> getActiveAlerts() {
        return sosAlertRepository.findByStatus("ACTIVE");
    }
}
