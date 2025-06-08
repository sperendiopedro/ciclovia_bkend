package pedroS.sensordata.mqtt.DTOs;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonDTO {
	@JsonProperty("luz")
	public String luz;
	@JsonProperty("umidade")
	public String umidade;
	@JsonProperty("temperatura")
	public String temperatura;
	@JsonProperty("horarioInformacao")
	public LocalDateTime horarioInfo;
	
	public String getLuz() {
		return luz;
	}
	public void setLuz(String luz) {
		this.luz = luz;
	}
	public String getUmidade() {
		return umidade;
	}
	public void setUmidade(String umidade) {
		this.umidade = umidade;
	}
	public String getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}
	public LocalDateTime getHorarioInfo() {
		return horarioInfo;
	}
	public void setHorarioInfo(LocalDateTime horarioInfo) {
		this.horarioInfo = horarioInfo;
	} 
	
    public Double getLuzAsDouble() {
        return extractNumber(luz);
    }

    public Double getUmidadeAsDouble() {
        return extractNumber(umidade);
    }

    public Double getTemperaturaAsDouble() {
        return extractNumber(temperatura);
    }
    
    public Double extractNumber(String value) {
    	if(value == null || value.isEmpty()) {
    		return 0.0; 
    	}
    	
    	String numericValue = value.replaceAll("[^0-9.-]", "");
    	try {
    		return Double.parseDouble(numericValue); 
    	}catch(Exception e) {
    		System.out.println("Erro no extract number" + value);
    		return 0.0;
    	}
    }
}
