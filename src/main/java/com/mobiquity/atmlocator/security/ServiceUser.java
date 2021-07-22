package com.mobiquity.atmlocator.security;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Setter
@Getter
@Table(name="SECURITY_USER")
public class ServiceUser {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="Username")
	private String userName;
	
	@Column(name="Role")
	private String role;
	
	@Column(name="Password")
	private String password;
	
	
}
