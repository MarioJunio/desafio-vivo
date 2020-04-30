package br.com.vivo.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "vivo-bots", type = "bots")
public class Bot implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	
	public Bot(String id) {
		this.id = id;
	}

}
