package pedroS.sensordata.models.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbc002_sensordata")
public class SensorData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private double value;

	@Column(nullable = false)
	private LocalDateTime timeStamp;

	@ManyToOne
	@JoinColumn(name = "sensorId", nullable = false )
	private SensorEntity sensorId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public SensorEntity getSensorId() {
		return sensorId;
	}

	public void setSensorId(SensorEntity sensorId) {
		this.sensorId = sensorId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}