package br.com.vivo.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
@Document(indexName = "vivo-messages", type = "messages")
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String conversationId;  

	@Field(type = FieldType.Date)
	private Date timestamp;  
	private String from;
	private String to;
	private String text;

}
