package model;

import java.io.Serializable;

import javax.persistence.*;
import javax.ws.rs.Produces;


/**
 * The persistent class for the WFD0000_EMPLOYEELOCATION database table.
 * 
 */
@Entity
@Table(name="WFD0000_EMPLOYEELOCATION")
public class EmployeeLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="BUSINESS_DESCR")
	private String businessDescr;

	@Column(name="BUSINESS_UNIT")
	private String businessUnit;

	private String deptid;

	@Column(name="DEPTID_DESCR")
	private String deptidDescr;
	
	@Id
	private String emplid;

	private String jobcode;

	@Column(name="JOBCODE_DESCR")
	private String jobcodeDescr;

	private String name;

	@Column(name="OFFICE_NAME")
	private String officeName;

	@Column(name="Y00_LAN_ID")
	private String y00LanId;

	@Column(name="Y00_LOCATION")
	private String y00Location;

	public EmployeeLocation() {
	}

	public String getBusinessDescr() {
		return this.businessDescr;
	}

	public void setBusinessDescr(String businessDescr) {
		this.businessDescr = businessDescr;
	}

	public String getBusinessUnit() {
		return this.businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getDeptid() {
		return this.deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getDeptidDescr() {
		return this.deptidDescr;
	}

	public void setDeptidDescr(String deptidDescr) {
		this.deptidDescr = deptidDescr;
	}

	public String getEmplid() {
		return this.emplid;
	}

	public void setEmplid(String emplid) {
		this.emplid = emplid;
	}

	public String getJobcode() {
		return this.jobcode;
	}

	public void setJobcode(String jobcode) {
		this.jobcode = jobcode;
	}

	public String getJobcodeDescr() {
		return this.jobcodeDescr;
	}

	public void setJobcodeDescr(String jobcodeDescr) {
		this.jobcodeDescr = jobcodeDescr;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOfficeName() {
		return this.officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getY00LanId() {
		return this.y00LanId;
	}

	public void setY00LanId(String y00LanId) {
		this.y00LanId = y00LanId;
	}

	public String getY00Location() {
		return this.y00Location;
	}

	public void setY00Location(String y00Location) {
		this.y00Location = y00Location;
	}

}