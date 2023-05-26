package dto;

import java.io.PrintWriter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
 @Data
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String name;
	String email;
	long mobile;
	String password;
	String gender;
	public static PrintWriter getWriter() {
		// TODO Auto-generated method stub
		return null;
	}
}
	
	