package com.github.lxgang.spring.security.beans;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * AgentRoleResource entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "agent_role_resource", catalog = "gsweb")

public class AgentRoleResource implements java.io.Serializable {

	// Fields

	private AgentRoleResourceId id;
	private String resource;
	private String roleKey;
	private Boolean enable;

	// Constructors

	/** default constructor */
	public AgentRoleResource() {
	}

	/** full constructor */
	public AgentRoleResource(AgentRoleResourceId id, String resource, String roleKey, Boolean enable) {
		this.id = id;
		this.resource = resource;
		this.roleKey = roleKey;
		this.enable = enable;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "method", column = @Column(name = "method", nullable = false, length = 10) ),
			@AttributeOverride(name = "roleId", column = @Column(name = "roleId", nullable = false) ),
			@AttributeOverride(name = "resourceId", column = @Column(name = "resourceId", nullable = false) ) })

	public AgentRoleResourceId getId() {
		return this.id;
	}

	public void setId(AgentRoleResourceId id) {
		this.id = id;
	}

	@Column(name = "resource", nullable = false)

	public String getResource() {
		return this.resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	@Column(name = "role_key", nullable = false)

	public String getRoleKey() {
		return this.roleKey;
	}

	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}

	@Column(name = "enable", nullable = false)

	public Boolean getEnable() {
		return this.enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "AgentRoleResource [id=" + id + ", resource=" + resource + ", roleKey=" + roleKey + ", enable=" + enable
				+ "]";
	}

}