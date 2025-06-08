package pedroS.sensordata.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pedroS.sensordata.models.entities.SensorEntity;
import pedroS.sensordata.models.enums.SensorType;

public interface EntityRepository extends JpaRepository<SensorEntity, Long> {
	SensorEntity findBySensor(SensorType sensor); 
}
