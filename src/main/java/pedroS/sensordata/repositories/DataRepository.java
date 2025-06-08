package pedroS.sensordata.repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pedroS.sensordata.models.entities.SensorData;
import pedroS.sensordata.models.enums.SensorType;

public interface DataRepository extends JpaRepository<SensorData, Long> {
	@Query("SELECT AVG(sd.value) FROM SensorData sd " +
	           "WHERE sd.sensorId.sensor = :sensorType " +
	           "AND sd.timeStamp BETWEEN :start AND :end")
	    Double calculateAverageBySensorAndPeriod(
	            @Param("sensorType") SensorType sensorType,
	            @Param("start") LocalDateTime start,
	            @Param("end") LocalDateTime end);

	    @Query("SELECT sd.value FROM SensorData sd " +
	           "WHERE sd.sensorId.sensor = :sensorType " +
	           "ORDER BY sd.timeStamp DESC LIMIT 1")
	    Double findLatestValueBySensor(@Param("sensorType") SensorType sensorType);
}
