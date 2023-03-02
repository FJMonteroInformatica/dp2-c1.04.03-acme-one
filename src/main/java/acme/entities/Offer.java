
package acme.entities;

import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.components.datatypes.Money;
import acme.framework.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Offer extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Past
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date				instantiationMoment;

	@NotBlank
	@Length(max = 76)
	protected String			heading;

	@NotBlank
	@Length(max = 101)
	protected String			summary;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date				availabilityPeriodStart;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date				availabilityPeriodEnd;

	//TODO: custom constraint in price (positive, possibly nought)
	@NotNull
	protected Money				price;

	@URL
	protected String			url;


	@AssertTrue
	public boolean isValidAvailabilityPeriod() {
		final long startMillis = this.availabilityPeriodStart.getTime();
		final long endMillis = this.availabilityPeriodEnd.getTime();
		final long instantiationMillis = this.instantiationMoment.getTime();

		final boolean startIsOneDayAfterInstantiation = startMillis - ChronoUnit.DAYS.getDuration().toMillis() >= instantiationMillis;

		final boolean availabilityPeriodMoreThanOneWeek = startMillis - ChronoUnit.WEEKS.getDuration().toMillis() >= endMillis;

		return availabilityPeriodMoreThanOneWeek && startIsOneDayAfterInstantiation;
	}
}
