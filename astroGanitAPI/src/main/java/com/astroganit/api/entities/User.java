package com.astroganit.api.entities;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "user_name",length = 100)
	private String name;
	
	private String email;
	
	private String password;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "updated_date")
	private Date updatedDate;
	
	@Column(name = "user_active")
	private boolean userActive;
	
	private String about;
	
	private String dcrptpassword;
	
	private String gender;
	
	private String place;
	
	private String country;
	
	private String state;
	
	private String mobile;
	
	private String mobilecc;//mobile country code
	
	@Column(name = "day_birth")
	private String dayBirth;
	
	@Column(name = "month_birth")
	private String monthBirth;
	
	@Column(name = "year_birth")
	private String yearBirth;
	
	@Column(name = "hour_birth")
	private String hourBirth;
	
	@Column(name = "minute_birth")
	private String minuteBirth;
	
	@Column(name = "second_birth")
	private String secondBirth;
	
	private String latitude;

	@Column(name = "lat_deg")
	private String latDeg;

	@Column(name = "lat_min")
	private String latMin;

	@Column(name = "lat_ns")
	private String latNS;
	
	private String longitude;
	
	@Column(name = "long_deg")
	private String longDeg;
	
	@Column(name = "long_min")
	private String longMin;
	
	@Column(name = "long_ew")
	private String longEW;
	
	@Column(name = "time_zone")
	private String timeZone;
	
	@Column(name = "user_verified")
	private boolean userVerified;
	
	@Column(name = "marital_status")
	private String maritalStatus;
	
	 
	@Column(name = "device_id")
	private String deviceId;
	
	@Column(name = "app_version")
	private String appVersion;
	
	@Column(name = "android_version")
	private String androidVersion;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns=@JoinColumn(name="user",referencedColumnName ="id" ),inverseJoinColumns = @JoinColumn(name="role",referencedColumnName="id"))
	private Set<Role> roles = new HashSet<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorties = this.roles.stream().map((role)-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.mobile;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
