package pedroS.sensordata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pedroS.sensordata.models.entities.SensorEntity;

public interface EntityRepository extends JpaRepository<SensorEntity, Long> {

}
