package pedroS.sensordata.mqtt.DTOs;

import java.time.LocalDateTime;

public class FrontDTO {
	    private Double averageTemperature;
	    private Double averageHumidity;
	    private Double currentLight;
	    private LocalDateTime lastUpdate;

	    public FrontDTO(Double averageTemperature, 
	                               Double averageHumidity, 
	                               Double currentLight, 
	                               LocalDateTime lastUpdate) {
	        this.averageTemperature = averageTemperature;
	        this.averageHumidity = averageHumidity;
	        this.currentLight = currentLight;
	        this.lastUpdate = lastUpdate;
	    }

	    // Getters
	    public Double getAverageTemperature() {
	        return averageTemperature;
	    }

	    public Double getAverageHumidity() {
	        return averageHumidity;
	    }

	    public Double getCurrentLight() {
	        return currentLight;
	    }

	    public LocalDateTime getLastUpdate() {
	        return lastUpdate;
	    }
	
}
