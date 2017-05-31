package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the WFD0000_EMPLOYEE_PUSHID database table.
 * 
 */
@Entity
@Table(name="WFD0000_EMPLOYEE_PUSHID")
public class EmployeePushid implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LAN_USER_ID")
	private String lanUserId;

	@Column(name="PUSH_ID")
	private String pushId;

	public EmployeePushid() {
	}

	public String getLanUserId() {
		return this.lanUserId;
	}

	public void setLanUserId(String lanUserId) {
		this.lanUserId = lanUserId;
	}

	public String getPushId() {
		return this.pushId;
	}

	public void setPushId(String pushId) {
		this.pushId = pushId;
	}

}