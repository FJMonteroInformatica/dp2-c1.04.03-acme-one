
package acme.entities.banner;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import acme.framework.data.AbstractEntity;
import acme.framework.helpers.MomentHelper;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Banner extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	protected MomentHelper		instantiation;

	protected MomentHelper		display;

	@NotBlank
	@Max(value = 75)
	protected String			slogan;

	@URL
	protected String			picture;

	@URL
	protected String			webDoc;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
