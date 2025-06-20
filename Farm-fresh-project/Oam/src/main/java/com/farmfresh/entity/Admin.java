package com.farmfresh.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Adminsec")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adminid")
	private int adminId;
	private String adminname;
	private String adminpass;
	/*
	 * public int getAdminId() { return adminId; } public void setAdminId(int
	 * adminId) { this.adminId = adminId; } public String getAdminname() { return
	 * adminname; } public void setAdminname(String adminname) { this.adminname =
	 * adminname; } public String getAdminpass() { return adminpass; } public void
	 * setAdminpass(String adminpass) { this.adminpass = adminpass; }
	 */
	
	
	
}
