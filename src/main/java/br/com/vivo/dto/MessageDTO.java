package br.com.vivo.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MessageDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String conversationId;
	
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date timestamp;
	private String from;
	private String to;
	private String text;

}
