package br.com.vivo.service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vivo.model.Message;
import br.com.vivo.repository.MessageRepository;
import br.com.vivo.service.exception.EntityNotFoundException;
import br.com.vivo.util.UUIDGenerator;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Transactional
	public Message create(Message message) {
		message.setId(UUIDGenerator.getUUID());
		return messageRepository.save(message);
	}

	public Message findById(String id) {
		return messageRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Mensagem " + id + " não existe"));
	}

	public Collection<Message> findByConversationId(String conversationId) {
		return StreamSupport.stream(messageRepository.findByConversationId(conversationId).spliterator(), false).collect(Collectors.toList());
	}
}
