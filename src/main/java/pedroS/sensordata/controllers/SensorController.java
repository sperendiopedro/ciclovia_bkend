package pedroS.sensordata.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pedroS.sensordata.models.entities.SensorEntity;
import pedroS.sensordata.mqtt.DTOs.FrontDTO;
import pedroS.sensordata.mqtt.services.FrontendService;
import pedroS.sensordata.repositories.DataRepository;
import pedroS.sensordata.repositories.EntityRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("sensors/api")
public class SensorController {

    private final FrontendService sensorService;

    public SensorController(FrontendService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping("/summary")
    public ResponseEntity<FrontDTO> getSensorSummary() {
        return ResponseEntity.ok(sensorService.getSensorSummary());
    }
}
