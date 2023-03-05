
package acme.entities.practicum;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
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
public class Session extends AbstractEntity {

	protected static final long	serialVersionUID	= 1L;

	@NotBlank
	@Length(max = 75)
	protected String			title;

	@NotBlank
	@Length(max = 100)
	protected String			sessionAbstract;

	@URL
	@Length(max = 255)
	protected String			link;

	/*
	 * TODO:
	 * start at least one week ahead, at least one week long
	 */
	@NotNull
	protected Date				start;

	@NotNull
	protected Date				finish;

	@NotNull
	@Valid
	@ManyToOne
	protected Practicum			practicum;

}
