package br.com.vivo.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vivo.dto.BotDTO;
import br.com.vivo.model.Bot;
import br.com.vivo.service.BotService;

@RestController
@RequestMapping("/bots")
public class BotResource extends BaseResource<Bot, BotDTO> {

	@Autowired
	private BotService botService;

	@PostMapping
	public ResponseEntity<BotDTO> create(@RequestBody BotDTO botDTO) {
		Bot botCreated = botService.create(toEntity(botDTO));

		return ResponseEntity.created(location(botCreated.getId())).body(toDto(botCreated));
	}

	@PutMapping("/{id}")
	public ResponseEntity<BotDTO> update(@PathVariable String id, @RequestBody BotDTO botDTO) {
		return ResponseEntity.ok(toDto(botService.update(id, toEntity(botDTO))));
	}

	@GetMapping
	public ResponseEntity<Collection<BotDTO>> searchAll() {
		return ResponseEntity.ok(toDto(botService.findAll()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<BotDTO> search(@PathVariable String id) {
		return ResponseEntity.ok(toDto(botService.findById(id)));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		botService.delete(id);
	}

}
