
package acme.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

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

	@PastOrPresent
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date				instantiationMoment;

	@NotBlank
	@Length(max = 75)
	protected String			heading;

	@NotBlank
	@Length(max = 100)
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

}
