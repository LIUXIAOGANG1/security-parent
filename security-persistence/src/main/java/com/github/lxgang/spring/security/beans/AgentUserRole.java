package com.github.lxgang.spring.security.beans;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * AgentUserRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "agent_user_role", catalog = "gsweb")

public class AgentUserRole implements java.io.Serializable {

	// Fields

	private AgentUserRoleId id;

	// Constructors

	/** default constructor */
	public AgentUserRole() {
	}

	/** full constructor */
	public AgentUserRole(AgentUserRoleId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "roleId", column = @Column(name = "roleId", nullable = false) ),
			@AttributeOverride(name = "userId", column = @Column(name = "userId", nullable = false) ) })

	public AgentUserRoleId getId() {
		return this.id;
	}

	public void setId(AgentUserRoleId id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AgentUserRole [id=" + id + "]";
	}

}