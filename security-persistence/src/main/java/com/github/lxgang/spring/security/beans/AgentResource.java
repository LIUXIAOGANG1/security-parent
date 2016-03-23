package com.github.lxgang.spring.security.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AgentResource entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "agent_resource", catalog = "gsweb")

public class AgentResource implements java.io.Serializable {

	// Fields

	private Integer id;
	private String resource;
	private Integer parentId;
	private String name;
	private String desc;
	private Integer type;
	private Integer level;
	private Boolean enable;

	// Constructors

	/** default constructor */
	public AgentResource() {
	}

	/** minimal constructor */
	public AgentResource(String resource, Integer parentId, String name, Integer type, Integer level, Boolean enable) {
		this.resource = resource;
		this.parentId = parentId;
		this.name = name;
		this.type = type;
		this.level = level;
		this.enable = enable;
	}

	/** full constructor */
	public AgentResource(String resource, Integer parentId, String name, String desc, Integer type, Integer level,
			Boolean enable) {
		this.resource = resource;
		this.parentId = parentId;
		this.name = name;
		this.desc = desc;
		this.type = type;
		this.level = level;
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

	@Column(name = "resource", nullable = false)

	public String getResource() {
		return this.resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	@Column(name = "parentId", nullable = false)

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
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

	@Column(name = "type", nullable = false)

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "level", nullable = false)

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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
		return "AgentResource [id=" + id + ", resource=" + resource + ", parentId=" + parentId + ", name=" + name
				+ ", desc=" + desc + ", type=" + type + ", level=" + level + ", enable=" + enable + "]";
	}

}