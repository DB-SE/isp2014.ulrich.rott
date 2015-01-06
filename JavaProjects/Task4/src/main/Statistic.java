package main;

import java.sql.Date;

import interfaces.StatisticPlugin;

public class Statistic implements StatisticPlugin{

	public double sum(Date from, Date to) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double avg() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTitle() {
		return "Statistic";
	}

	@Override
	public String getDescription() {
		return "Statistic of Finance";
	}

	@Override
	public String getAccess() {
		return null;
	}

}
