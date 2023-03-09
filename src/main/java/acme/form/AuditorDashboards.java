
package acme.form;

import java.util.Map;

import acme.datatypes.Statistic;
import acme.entities.course.CourseType;
import acme.framework.data.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditorDashboards extends AbstractForm {

	protected static final long	serialVersionUID	= 1L;

	Map<CourseType, Integer>	numberOfAuditsByType;
	private Statistic			auditingRecordsMetrics;
	private Statistic			periodLengthsMetrics;

}
