package pedroS.sensordata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pedroS.sensordata.models.entities.SensorData;

public interface DataRepository extends JpaRepository<SensorData, Long> {

}
