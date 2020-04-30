package br.com.vivo.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.vivo.dto.MessageDTO;
import br.com.vivo.model.Message;
import br.com.vivo.service.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageResource extends BaseResource<Message, MessageDTO> {

	@Autowired
	private MessageService messageService;

	@PostMapping
	public ResponseEntity<MessageDTO> create(@RequestBody MessageDTO messageDTO) {
		Message message = messageService.create(toEntity(messageDTO));

		return ResponseEntity.created(location(message.getId())).body(toDto(message));
	}

	@GetMapping("/{id}")
	public ResponseEntity<MessageDTO> search(@PathVariable String id) {
		Message message = messageService.findById(id);

		return ResponseEntity.ok(toDto(message));
	}

	@GetMapping
	public ResponseEntity<Collection<MessageDTO>> searchAll(@RequestParam String conversationId) {
		Collection<Message> messages = messageService.findByConversationId(conversationId);

		return !messages.isEmpty() ? ResponseEntity.ok(toDto(messages)) : ResponseEntity.notFound().build();
	}
}
