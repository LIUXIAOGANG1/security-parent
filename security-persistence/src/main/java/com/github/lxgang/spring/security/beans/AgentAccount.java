package com.github.lxgang.spring.security.beans;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AgentAccount entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "agent_account", catalog = "gsweb")

public class AgentAccount implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer balance;
	private Integer freezing;
	private Short discount;
	private Integer parentId;
	private Timestamp createTime;
	private Integer creater;
	private String desc;

	// Constructors

	/** default constructor */
	public AgentAccount() {
	}

	/** minimal constructor */
	public AgentAccount(String name, Integer balance, Integer freezing, Short discount, Timestamp createTime,
			Integer creater) {
		this.name = name;
		this.balance = balance;
		this.freezing = freezing;
		this.discount = discount;
		this.createTime = createTime;
		this.creater = creater;
	}

	/** full constructor */
	public AgentAccount(String name, Integer balance, Integer freezing, Short discount, Integer parentId,
			Timestamp createTime, Integer creater, String desc) {
		this.name = name;
		this.balance = balance;
		this.freezing = freezing;
		this.discount = discount;
		this.parentId = parentId;
		this.createTime = createTime;
		this.creater = creater;
		this.desc = desc;
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

	@Column(name = "name", nullable = false, length = 128)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "balance", nullable = false)

	public Integer getBalance() {
		return this.balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@Column(name = "freezing", nullable = false)

	public Integer getFreezing() {
		return this.freezing;
	}

	public void setFreezing(Integer freezing) {
		this.freezing = freezing;
	}

	@Column(name = "discount", nullable = false)

	public Short getDiscount() {
		return this.discount;
	}

	public void setDiscount(Short discount) {
		this.discount = discount;
	}

	@Column(name = "parentId")

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "createTime", nullable = false, length = 19)

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "creater", nullable = false)

	public Integer getCreater() {
		return this.creater;
	}

	public void setCreater(Integer creater) {
		this.creater = creater;
	}

	@Column(name = "desc", length = 256)

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "AgentAccount [id=" + id + ", name=" + name + ", balance=" + balance + ", freezing=" + freezing
				+ ", discount=" + discount + ", parentId=" + parentId + ", createTime=" + createTime + ", creater="
				+ creater + ", desc=" + desc + "]";
	}

}