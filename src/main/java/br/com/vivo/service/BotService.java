package br.com.vivo.service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vivo.model.Bot;
import br.com.vivo.repository.BotRepository;
import br.com.vivo.service.exception.EntityNotFoundException;
import br.com.vivo.util.UUIDGenerator;

@Service
public class BotService {

	@Autowired
	private BotRepository botRepository;

	@Transactional
	public Bot create(Bot bot) {
		bot.setId(UUIDGenerator.getUUID());
		return botRepository.save(bot);
	}

	@Transactional
	public Bot update(String id, Bot bot) {
		findById(id);
		
		bot.setId(id);
		return botRepository.save(bot);
	}

	@Transactional
	public void delete(String id) {
		botRepository.delete(findById(id));
	}

	public Collection<Bot> findAll() {
		return StreamSupport.stream(botRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	public Bot findById(String id) {
		return botRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Bot " + id + " não existe"));
	}

}
