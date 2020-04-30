package br.com.vivo.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import br.com.vivo.repository.BotRepository;
import lombok.Data;

@Data
@Configuration
@EnableElasticsearchRepositories(basePackageClasses = { BotRepository.class })
public class EsConfig {

	@Value("${elasticsearch.host:localhost}")
	private String host;

	@Value("${elasticsearch.port:9200}")
	private int port;

	@Value("${elasticsearch.cluster.name:oportunidade-vivo}")
	private String clusterName;

	@Value("${elasticsearch.node.name:node-vivo1}")
	private String nodeName;

	@SuppressWarnings("resource")
	@Bean(destroyMethod = "close")
	public Client client() {

		TransportClient client = null;

		try {
			Settings settings = Settings.builder().put("cluster.name", clusterName).put("node.name", nodeName).build();

			client = new PreBuiltTransportClient(settings).addTransportAddress(new TransportAddress(InetAddress.getByName(host), port));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return client;
	}

}
