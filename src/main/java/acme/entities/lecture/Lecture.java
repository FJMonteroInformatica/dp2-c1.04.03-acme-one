
package acme.entities.lecture;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import acme.framework.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Lecture extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Max(value = 76)
	protected String			title;

	@NotBlank
	@Max(value = 101)
	protected String			_abstract;

	@Min(value = 1)
	protected int				learningHours;

	@NotBlank
	@Max(value = 101)
	protected String			body;

	protected boolean			isHandsOn;

	@URL
	protected String			link;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
