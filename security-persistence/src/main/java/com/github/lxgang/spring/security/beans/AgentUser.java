package com.github.lxgang.spring.security.beans;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * AgentUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "agent_user", catalog = "gsweb", uniqueConstraints = @UniqueConstraint(columnNames = "username") )

public class AgentUser implements java.io.Serializable, UserDetails{

	// Fields
	
	private  Collection<? extends GrantedAuthority> authorities;
	private Integer id;
	private Integer accountId;
	private String username;
	private String password;
	private String salt;
	private Short level;
	private String email;
	private String phone;
	private String name;
	private String entType;
	private String province;
	private String city;
	private String zipcode;
	private String website;
	private String csPhone;
	private String bankType;
	private String bankcardNumber;
	private Short isApproved;
	private Short isLockedOut;
	private Timestamp lastLockoutTime;
	private Timestamp createTime;
	private String creater;
	private Timestamp lastLoginTime;
	private Timestamp lastPasswordChangedTime;
	private Integer failedPasswordAttemptCount;
	private Integer departmentId;

	// Constructors

	/** default constructor */
	public AgentUser() {
	}

	/** minimal constructor */
	public AgentUser(Integer id, Integer accountId, String username, String password, String salt, Short level,
			String email, String name, String entType, Short isApproved, Short isLockedOut, Timestamp lastLockoutTime,
			Timestamp createTime, Timestamp lastLoginTime, Timestamp lastPasswordChangedTime,
			Integer failedPasswordAttemptCount) {
		this.id = id;
		this.accountId = accountId;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.level = level;
		this.email = email;
		this.name = name;
		this.entType = entType;
		this.isApproved = isApproved;
		this.isLockedOut = isLockedOut;
		this.lastLockoutTime = lastLockoutTime;
		this.createTime = createTime;
		this.lastLoginTime = lastLoginTime;
		this.lastPasswordChangedTime = lastPasswordChangedTime;
		this.failedPasswordAttemptCount = failedPasswordAttemptCount;
	}

	/** full constructor */
	public AgentUser(Integer id, Integer accountId, String username, String password, String salt, Short level,
			String email, String phone, String name, String entType, String province, String city, String zipcode,
			String website, String csPhone, String bankType, String bankcardNumber, Short isApproved, Short isLockedOut,
			Timestamp lastLockoutTime, Timestamp createTime, String creater, Timestamp lastLoginTime,
			Timestamp lastPasswordChangedTime, Integer failedPasswordAttemptCount, Integer departmentId) {
		this.id = id;
		this.accountId = accountId;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.level = level;
		this.email = email;
		this.phone = phone;
		this.name = name;
		this.entType = entType;
		this.province = province;
		this.city = city;
		this.zipcode = zipcode;
		this.website = website;
		this.csPhone = csPhone;
		this.bankType = bankType;
		this.bankcardNumber = bankcardNumber;
		this.isApproved = isApproved;
		this.isLockedOut = isLockedOut;
		this.lastLockoutTime = lastLockoutTime;
		this.createTime = createTime;
		this.creater = creater;
		this.lastLoginTime = lastLoginTime;
		this.lastPasswordChangedTime = lastPasswordChangedTime;
		this.failedPasswordAttemptCount = failedPasswordAttemptCount;
		this.departmentId = departmentId;
	}

	// Property accessors
	@Id

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "accountId", nullable = false)

	public Integer getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	@Column(name = "username", unique = true, nullable = false, length = 32)

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 256)

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "salt", nullable = false, length = 128)

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Column(name = "level", nullable = false)

	public Short getLevel() {
		return this.level;
	}

	public void setLevel(Short level) {
		this.level = level;
	}

	@Column(name = "email", nullable = false, length = 256)

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", length = 16)

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "name", nullable = false, length = 32)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "entType", nullable = false, length = 32)

	public String getEntType() {
		return this.entType;
	}

	public void setEntType(String entType) {
		this.entType = entType;
	}

	@Column(name = "province")

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "city")

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "zipcode", length = 16)

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "website", length = 256)

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Column(name = "csPhone", length = 32)

	public String getCsPhone() {
		return this.csPhone;
	}

	public void setCsPhone(String csPhone) {
		this.csPhone = csPhone;
	}

	@Column(name = "bankType", length = 32)

	public String getBankType() {
		return this.bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	@Column(name = "bankcardNumber", length = 64)

	public String getBankcardNumber() {
		return this.bankcardNumber;
	}

	public void setBankcardNumber(String bankcardNumber) {
		this.bankcardNumber = bankcardNumber;
	}

	@Column(name = "isApproved", nullable = false)

	public Short getIsApproved() {
		return this.isApproved;
	}

	public void setIsApproved(Short isApproved) {
		this.isApproved = isApproved;
	}

	@Column(name = "isLockedOut", nullable = false)

	public Short getIsLockedOut() {
		return this.isLockedOut;
	}

	public void setIsLockedOut(Short isLockedOut) {
		this.isLockedOut = isLockedOut;
	}

	@Column(name = "lastLockoutTime", nullable = false, length = 19)

	public Timestamp getLastLockoutTime() {
		return this.lastLockoutTime;
	}

	public void setLastLockoutTime(Timestamp lastLockoutTime) {
		this.lastLockoutTime = lastLockoutTime;
	}

	@Column(name = "createTime", nullable = false, length = 19)

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "creater", length = 128)

	public String getCreater() {
		return this.creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	@Column(name = "lastLoginTime", nullable = false, length = 19)

	public Timestamp getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Column(name = "lastPasswordChangedTime", nullable = false, length = 19)

	public Timestamp getLastPasswordChangedTime() {
		return this.lastPasswordChangedTime;
	}

	public void setLastPasswordChangedTime(Timestamp lastPasswordChangedTime) {
		this.lastPasswordChangedTime = lastPasswordChangedTime;
	}

	@Column(name = "failedPasswordAttemptCount", nullable = false)

	public Integer getFailedPasswordAttemptCount() {
		return this.failedPasswordAttemptCount;
	}

	public void setFailedPasswordAttemptCount(Integer failedPasswordAttemptCount) {
		this.failedPasswordAttemptCount = failedPasswordAttemptCount;
	}

	@Column(name = "departmentId")

	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "AgentUser [id=" + id + ", accountId=" + accountId + ", username=" + username + ", password=" + password
				+ ", salt=" + salt + ", level=" + level + ", email=" + email + ", phone=" + phone + ", name=" + name
				+ ", entType=" + entType + ", province=" + province + ", city=" + city + ", zipcode=" + zipcode
				+ ", website=" + website + ", csPhone=" + csPhone + ", bankType=" + bankType + ", bankcardNumber="
				+ bankcardNumber + ", isApproved=" + isApproved + ", isLockedOut=" + isLockedOut + ", lastLockoutTime="
				+ lastLockoutTime + ", createTime=" + createTime + ", creater=" + creater + ", lastLoginTime="
				+ lastLoginTime + ", lastPasswordChangedTime=" + lastPasswordChangedTime
				+ ", failedPasswordAttemptCount=" + failedPasswordAttemptCount + ", departmentId=" + departmentId + "]";
	}

	@Override
	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	@Transient
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@Transient
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@Transient
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@Transient
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

}