package io.javabrains.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="USER_NAME")
	private String userName;

	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	
	@Embedded
	@AttributeOverrides( {
			@AttributeOverride(name="street", column=@Column(name="HOME_STREET_NAME")),
			@AttributeOverride(name="city", column=@Column(name="HOME_CITY_NAME")),
			@AttributeOverride(name="state", column=@Column(name="HOME_STATE_NAME")),
			@AttributeOverride(name="pincode", column=@Column(name="HOME_PIN_CODE"))
		}
	)
	private Address homeAddress;
	
	@Embedded
	private Address officeAddress;
	
	@Lob
	private String description;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int i) {
		this.userId = i;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
