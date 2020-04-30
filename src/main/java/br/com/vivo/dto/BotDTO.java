package br.com.vivo.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class BotDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
}
