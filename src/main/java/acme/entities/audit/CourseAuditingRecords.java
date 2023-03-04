
package acme.entities.audit;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CourseAuditingRecords extends AbstractEntity {

	protected static final long	serialVersionUID	= 1L;

	@NotBlank
	@Length(max = 75)
	protected String			subject;

	@NotBlank
	@Length(max = 100)
	protected String			asessment;

	@Temporal(TemporalType.TIMESTAMP)
	@PastOrPresent
	protected Date				startDate;

	@Temporal(TemporalType.TIMESTAMP)
	@PastOrPresent
	protected Date				finishDate;

	protected Mark				mark;

	@URL
	protected String			link;

}
