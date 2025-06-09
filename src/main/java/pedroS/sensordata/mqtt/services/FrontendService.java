package pedroS.sensordata.mqtt.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pedroS.sensordata.models.enums.SensorType;
import pedroS.sensordata.mqtt.DTOs.FrontDTO;
import pedroS.sensordata.repositories.DataRepository;

@Service
public class FrontendService {
	@Autowired
	protected DataRepository dataRepo;

    @Transactional
    public FrontDTO getSensorSummary() {
        LocalDateTime twoMinutesAgo = LocalDateTime.now().minusMinutes(2);
        
        Double avgTemp = dataRepo.findLatestValueBySensor(SensorType.DHT_TEMPERATURA);
        
        Double avgHumidity = dataRepo.findLatestValueBySensor(SensorType.DHT_UMIDADE); 
        
        Double currentLight = dataRepo.findLatestValueBySensor(SensorType.LDR);
        
 
        return new FrontDTO(
            avgTemp,
            avgHumidity,
            currentLight,
            LocalDateTime.now()
        );
    }
	
	
}
