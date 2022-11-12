package com.airlinemanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "schedules")
public class Schedule extends BaseClass{

	@OneToOne(fetch = FetchType.EAGER)
	private Airport srcAirport;

	@OneToOne(fetch = FetchType.EAGER)
	private Airport dstnAirport;

	@Column(name = "departure_date")
	@JsonFormat(pattern = "mm-dd-yyyy HH:mm:ss")
	private String deptDateTime;

	@Column(name = "arrival_date")
	@JsonFormat(pattern = "mm-dd-yyyy HH:mm:ss")
	private Date arrDateTime;

	@Override
	public String toString() {
		return "Schedule [" +
				"scheduleId=" + getId() +
				"srcAirport=" + srcAirport +
				", dstnAirport=" + dstnAirport +
				", deptDateTime='" + deptDateTime + '\'' +
				", arrDateTime=" + arrDateTime +
				']';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Schedule schedule = (Schedule) o;
		return getId() != null && Objects.equals(getId(), schedule.getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
