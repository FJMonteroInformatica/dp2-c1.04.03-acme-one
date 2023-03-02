
package acme.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Activity extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Length(max = 76)
	protected String			title;

	@NotBlank
	@Length(max = 101)
	protected String			summary; //Abstract

	@NotNull
	protected ActivityType		activityType;

	@NotNull
	@Temporal(value = TemporalType.TIME)
	protected Date				startDate;

	@NotNull
	@Temporal(value = TemporalType.TIME)
	protected Date				endDate;

	@URL
	protected String			informationLink;

	@NotNull
	@Valid
	@ManyToOne()
	protected Enrolment			enrolment;


	//Returns the time period between endDate and startDate in hours
	@Transient
	public Double getTimePeriod() {
		return (this.getStartDate().getTime() - this.getEndDate().getTime()) / 3600000.;
	}

	//Restricts that endDate is before startDate
	@AssertTrue
	public boolean isValidPeriod() {
		return this.endDate.compareTo(this.startDate) >= 0;
	}

}
