package com.hexaware.lms;

import org.springframework.jdbc.core.JdbcTemplate;
import  java.util.Date;


public class LeaveHistoryDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public String applyLeave(LeaveHistory history) {
		Date d1 = new Date(history.getLeaveStartDate().getTime());
		Date d2 = new Date(history.getLeaveEndDate().getTime());
		long days = (d2.getTime() - d1.getTime())/(1000*60*60*24);
		//days++;
		int d = (int)days;
		history.setNoOfDays(d);
		history.setLeaveStatus("PENDING");
		String cmd = "Insert into Leave_History(EMP_ID, LEAVE_START_DATE, LEAVE_END_DATE, "
				+ " LEAVE_NO_OF_DAYS, LEAVE_TYPE, LEAVE_STATUS, LEAVE_REASON) "
				+ " values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(cmd, new Object[] {history.getEmpId(), history.getLeaveStartDate(),
			history.getLeaveEndDate(), history.getNoOfDays(), history.getLeaveType(),
			history.getLeaveStatus(), history.getLeaveReason()
			});
		return "Leave Applied...";
	}
}