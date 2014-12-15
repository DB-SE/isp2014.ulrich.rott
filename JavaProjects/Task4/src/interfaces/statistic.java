package interfaces;

import java.sql.Date;

public interface statistic {
	
	public double sum(Date from, Date to);
	public double avg();
}
