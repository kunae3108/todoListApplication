/**
 * 
 */
package com.nattav.TodoList.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "MT_TODO_STATUS")
@EntityListeners(AuditingEntityListener.class)
public class MtStatusObj implements Serializable
{
	@Id
	@NotBlank
	@Column(name = "STATUS_CODE")
	private String statusCode;

	@NotBlank
	@Column(name = "STATUS_NAME")
	private String statusName;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "statusCode")
	private List<InfTodoObj> todoTask;

	
	
	public String getStatusCode()
	{
		return statusCode;
	}

	public void setStatusCode(String statusCode)
	{
		this.statusCode = statusCode;
	}

	public String getStatusName()
	{
		return statusName;
	}

	public void setStatusName(String statusName)
	{
		this.statusName = statusName;
	}

	public List<InfTodoObj> getTodoTask()
	{
		return todoTask;
	}

	public void setTodoTask(List<InfTodoObj> todoTask)
	{
		this.todoTask = todoTask;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((statusCode == null) ? 0 : statusCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MtStatusObj other = (MtStatusObj) obj;
		if (statusCode == null)
		{
			if (other.statusCode != null)
				return false;
		}
		else if (!statusCode.equals(other.statusCode))
			return false;
		return true;
	}

	
	
}