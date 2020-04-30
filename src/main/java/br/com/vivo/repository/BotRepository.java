package br.com.vivo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import br.com.vivo.model.Bot;

@Repository
public interface BotRepository extends ElasticsearchRepository<Bot, String> {

}
