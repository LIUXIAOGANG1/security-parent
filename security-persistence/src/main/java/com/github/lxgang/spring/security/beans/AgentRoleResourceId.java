package com.github.lxgang.spring.security.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AgentRoleResourceId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class AgentRoleResourceId implements java.io.Serializable {

	// Fields

	private String method;
	private Integer roleId;
	private Integer resourceId;

	// Constructors

	/** default constructor */
	public AgentRoleResourceId() {
	}

	/** full constructor */
	public AgentRoleResourceId(String method, Integer roleId, Integer resourceId) {
		this.method = method;
		this.roleId = roleId;
		this.resourceId = resourceId;
	}

	// Property accessors

	@Column(name = "method", nullable = false, length = 10)

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Column(name = "roleId", nullable = false)

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "resourceId", nullable = false)

	public Integer getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AgentRoleResourceId))
			return false;
		AgentRoleResourceId castOther = (AgentRoleResourceId) other;

		return ((this.getMethod() == castOther.getMethod()) || (this.getMethod() != null
				&& castOther.getMethod() != null && this.getMethod().equals(castOther.getMethod())))
				&& ((this.getRoleId() == castOther.getRoleId()) || (this.getRoleId() != null
						&& castOther.getRoleId() != null && this.getRoleId().equals(castOther.getRoleId())))
				&& ((this.getResourceId() == castOther.getResourceId())
						|| (this.getResourceId() != null && castOther.getResourceId() != null
								&& this.getResourceId().equals(castOther.getResourceId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getMethod() == null ? 0 : this.getMethod().hashCode());
		result = 37 * result + (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		result = 37 * result + (getResourceId() == null ? 0 : this.getResourceId().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "AgentRoleResourceId [method=" + method + ", roleId=" + roleId + ", resourceId=" + resourceId + "]";
	}

}