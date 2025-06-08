package pedroS.sensordata.mqtt.configbeans;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {
	@Value("${broker}")
	private String broker;

	@Value("${clientId}")
	private String cliendId;

	@Value("${username}")
	private String username;

	@Value("${password}")
	private String password;

	@Bean
	protected MqttClient mqttClient() throws MqttException {
		MqttClient client = new MqttClient(broker, cliendId, new MemoryPersistence());

		MqttConnectOptions opt = new MqttConnectOptions();
		opt.setCleanSession(true);
		opt.setUserName(username);
		opt.setPassword(password.toCharArray());

		client.connect(opt);
		return client;

	}

}
