package com.ait.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "contact_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
	  @Transient
	    public static final String SEQUENCE_NAME = "users_sequence";
	@Id
	
	Integer contactId;
	String contactName;
	String contactEmail;
	Long contactNum;

}
