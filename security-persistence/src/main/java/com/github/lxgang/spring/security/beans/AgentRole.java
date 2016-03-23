package com.github.lxgang.spring.security.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AgentRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "agent_role", catalog = "gsweb")

public class AgentRole implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String desc;
	private String key;
	private Boolean enable;

	// Constructors

	/** default constructor */
	public AgentRole() {
	}

	/** minimal constructor */
	public AgentRole(String name, String key, Boolean enable) {
		this.name = name;
		this.key = key;
		this.enable = enable;
	}

	/** full constructor */
	public AgentRole(String name, String desc, String key, Boolean enable) {
		this.name = name;
		this.desc = desc;
		this.key = key;
		this.enable = enable;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "desc")

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "key", nullable = false, length = 50)

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
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
		return "AgentRole [id=" + id + ", name=" + name + ", desc=" + desc + ", key=" + key + ", enable=" + enable
				+ "]";
	}

}