
package acme.form;

import java.util.Map;

import acme.datatypes.Statistic;
import acme.framework.data.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDashboard extends AbstractForm {

	protected static final long	serialVersionUID	= 1L;

	// Map<Month, nºCourses>
	Map<Integer, Integer>		numberOfAuditsByType;
	private Statistic			practicumSessionMetrics;
	private Statistic			practicumMetrics;
}
