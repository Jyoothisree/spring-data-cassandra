package com.example.domain;

import java.util.Date;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.DataType;

@Table(value = "users")
public class User {

	@PrimaryKeyColumn(name = "id", type=PrimaryKeyType.PARTITIONED)
	@CassandraType(type=DataType.Name.UUID)
    private UUID id;
 
    @Column(value="username")
    private String username;
 
    @Column(value = "email")
    private String email;
 
    @Column(value = "password")
    private String password;
    
    @Transient
    //@Column(value = "creation_date")
    private Date creationDate;
    
    public User(){}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email 
				+ ", creationDate=" + creationDate + "]";
	}
	
	
}
