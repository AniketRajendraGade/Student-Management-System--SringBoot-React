package com.project.sms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDto {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Integer age;
	private String Department;	
}
