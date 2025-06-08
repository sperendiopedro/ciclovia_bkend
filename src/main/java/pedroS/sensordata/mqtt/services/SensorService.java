package pedroS.sensordata.mqtt.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pedroS.sensordata.models.entities.SensorData;
import pedroS.sensordata.models.entities.SensorEntity;
import pedroS.sensordata.models.enums.SensorType;
import pedroS.sensordata.mqtt.DTOs.JsonDTO;
import pedroS.sensordata.repositories.DataRepository;
import pedroS.sensordata.repositories.EntityRepository;

@Service
public class SensorService {

	@Autowired
	private EntityRepository entityRepo; 
	@Autowired
	private DataRepository dataRepo; 
	
	protected void saveSensorData(SensorEntity sensor, double value, LocalDateTime timeStamp) {
		if (Double.isNaN(value) || Double.isInfinite(value)) {
	        System.err.println("Valor inválido recebido para o sensor " + sensor.getSensorNm());
	        return;
		}
		
		SensorData sensorData = new SensorData(); 
		sensorData.setSensorId(sensor);
		sensorData.setValue(value);
		sensorData.setTimeStamp(timeStamp);
		dataRepo.save(sensorData); 
	}
	
	protected SensorEntity getOrCreateSensorEntity(SensorType sensorType, String sensorName, String unit) {
		SensorEntity sensor = entityRepo.findBySensor(sensorType);
		if(sensor == null) {
			sensor = new SensorEntity(); 
			sensor.setSensor(sensorType);
			sensor.setSensorNm(sensorName); 
			sensor.setUnit(unit);
			sensor = entityRepo.save(sensor); 
		}
			
		return sensor; 
	}
		
	@Transactional
	public void processSensorData(JsonDTO sensorData) {
        saveSensorData(
                getOrCreateSensorEntity(SensorType.LDR, "Luminosidade", "Lux"),
                sensorData.getLuzAsDouble(),
                sensorData.getHorarioInfo()
            );

        saveSensorData(
                getOrCreateSensorEntity(SensorType.DHT_UMIDADE, "Umidade DHT22", "%"),
                sensorData.getUmidadeAsDouble(),
                sensorData.getHorarioInfo()
            );

            saveSensorData(
                getOrCreateSensorEntity(SensorType.DHT_TEMPERATURA, "Temperatura DHT22", "°C"),
                sensorData.getTemperaturaAsDouble(),
                sensorData.getHorarioInfo()
            );
	}
	
	
}
