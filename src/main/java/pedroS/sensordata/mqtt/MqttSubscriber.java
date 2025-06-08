package pedroS.sensordata.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;
import pedroS.sensordata.mqtt.DTOs.JsonDTO;
import pedroS.sensordata.mqtt.services.SensorService;

@Component
public class MqttSubscriber {
	
	private final MqttClient mqttClient;
	private final SensorService sensorService;
	private final ObjectMapper objectMapper;
	
	@Value("${topic}")
	private String topic;
	
	public MqttSubscriber(MqttClient mqttClient, SensorService sensorService, ObjectMapper objectMapper) {
		this.mqttClient=mqttClient;
		this.sensorService=sensorService; 
		this.objectMapper=objectMapper; 
	}


	@PostConstruct
	public void subscribe() {
		try {
			mqttClient.subscribe(topic, (t, msg) -> {
				try {
					String payload = new String(msg.getPayload()); 
					System.out.println("mensagem recebida no tópico" +t +": " + payload);
					
	                if (payload == null || payload.isEmpty()) {
	                    System.err.println("Payload vazio recebido");
	                    return;
	                }
					JsonDTO sensorData = objectMapper.readValue(payload, JsonDTO.class); 
					sensorService.processSensorData(sensorData);
					
					
				}catch(Exception e) {
					System.err.println("Erro ao processar mensagem MQTT: " + e.getMessage());
					e.printStackTrace(); 
				}
			});
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
