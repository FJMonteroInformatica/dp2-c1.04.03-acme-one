
package acme.roles;

import java.util.Collection;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.data.AbstractRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student extends AbstractRole {

	// Serialisation identifier -----------------------------------------------

	protected static final long		serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Length(min = 0, max = 76)
	protected String				statement;

	@NotBlank
	@Length(min = 0, max = 101)
	protected Collection<String>	strongFeatures;

	@NotBlank
	@Length(min = 0, max = 101)
	protected Collection<String>	weakFeatures;

	@URL
	protected String				informationLink;

}
