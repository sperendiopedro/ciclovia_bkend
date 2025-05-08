package pedroS.sensordata.models.entities;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import pedroS.sensordata.models.enums.SensorType;

@Entity
@Table(name = "tbc001_sensor")
public class SensorEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private SensorType sensor;

	@Column(nullable = false)
	private String unit;

	@Column(nullable = false)
	private String sensorNm;

	@OneToMany(mappedBy = "sensorId", cascade = CascadeType.ALL, orphanRemoval=true)
	private Set<SensorData> data;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public SensorType getSensor() {
		return sensor;
	}

	public void setSensor(SensorType sensor) {
		this.sensor = sensor;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getSensorNm() {
		return sensorNm;
	}

	public void setSensorNm(String sensorNm) {
		this.sensorNm = sensorNm;
	}

	public Set<SensorData> getData() {
		return data;
	}

	public void setData(Set<SensorData> data) {
		this.data = data;
	}

}
