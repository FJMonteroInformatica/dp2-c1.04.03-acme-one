
package acme.form;

import acme.framework.data.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditorDashboards extends AbstractForm {

	protected static final long	serialVersionUID	= 1L;

	private int					totalAudits;
	private double				avgAuditingRecords;
	private double				devAuditingRecords;
	private double				minAuditingRecords;
	private double				maxAuditingRecords;
	private double				avgPeriodLengths;
	private double				devPeriodLengths;
	private double				minPeriodLengths;
	private double				maxPeriodLengths;

}
