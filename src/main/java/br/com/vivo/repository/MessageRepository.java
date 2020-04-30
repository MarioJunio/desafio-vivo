package br.com.vivo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import br.com.vivo.model.Message;

@Repository
public interface MessageRepository extends ElasticsearchRepository<Message, String> {

	Iterable<Message> findByConversationId(String conversationId);
}
