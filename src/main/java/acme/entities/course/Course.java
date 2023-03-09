
package acme.entities.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.CourseLectureMapper;
import acme.framework.components.datatypes.Money;
import acme.framework.data.AbstractEntity;
import acme.roles.Lecturer;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Course extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long		serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Column(unique = true)
	@NotBlank
	@Pattern(regexp = "^[A-Z]{1,3}[0-9]{3}$")
	protected String				code;

	@NotBlank
	@Length(max = 75)
	protected String				title;

	@NotBlank
	@Length(max = 75)
	protected String				_abstract;

	//Nought or zero, we have no annotations for this type
	protected Money					price;

	@URL
	protected String				link;

	// Derived attributes -----------------------------------------------------

	@Transient
	protected CourseType			_type;
	/*
	 * Calculate this using the mode
	 * from the list of lectures
	 */

	// Relationships ----------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne()
	protected Lecturer				lecturer;

	@NotNull
	@Valid
	@ManyToOne()
	protected CourseLectureMapper	lectureMapper;

}
