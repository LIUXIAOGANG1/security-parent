package com.github.lxgang.spring.security.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AgentUserRoleId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class AgentUserRoleId implements java.io.Serializable {

	// Fields
	private Integer roleId;
	private Integer userId;

	// Constructors

	/** default constructor */
	public AgentUserRoleId() {
	}

	/** full constructor */
	public AgentUserRoleId(Integer roleId, Integer userId) {
		this.roleId = roleId;
		this.userId = userId;
	}

	// Property accessors

	@Column(name = "roleId", nullable = false)

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "userId", nullable = false)

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AgentUserRoleId))
			return false;
		AgentUserRoleId castOther = (AgentUserRoleId) other;

		return ((this.getRoleId() == castOther.getRoleId()) || (this.getRoleId() != null
				&& castOther.getRoleId() != null && this.getRoleId().equals(castOther.getRoleId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this.getUserId() != null
						&& castOther.getUserId() != null && this.getUserId().equals(castOther.getUserId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		result = 37 * result + (getUserId() == null ? 0 : this.getUserId().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "AgentUserRoleId [roleId=" + roleId + ", userId=" + userId + "]";
	}

}