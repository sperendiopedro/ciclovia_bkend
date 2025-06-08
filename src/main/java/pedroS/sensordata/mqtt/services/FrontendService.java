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
        LocalDateTime thirtyMinutesAgo = LocalDateTime.now().minusMinutes(30);
        
        Double avgTemp = dataRepo.calculateAverageBySensorAndPeriod(
            SensorType.DHT_TEMPERATURA , thirtyMinutesAgo, LocalDateTime.now());
        
        Double avgHumidity = dataRepo.calculateAverageBySensorAndPeriod(
            SensorType.DHT_UMIDADE, thirtyMinutesAgo, LocalDateTime.now());
        
        Double currentLight = dataRepo.findLatestValueBySensor(SensorType.LDR);
        
        return new FrontDTO(
            avgTemp,
            avgHumidity,
            currentLight,
            LocalDateTime.now()
        );
    }
	
	
}
