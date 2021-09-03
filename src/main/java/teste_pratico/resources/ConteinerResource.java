package teste_pratico.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import teste_pratico.domain.Conteiner;
import teste_pratico.domain.enums.Categoria;
import teste_pratico.domain.enums.StatusEspacoInterior;
import teste_pratico.domain.enums.TipoConteiner;
import teste_pratico.repositories.ConteinerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/conteiners")
public class ConteinerResource {

	
	@Autowired
	private ConteinerRepository repo;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Conteiner>> findAll(){
		
		List<Conteiner> list = repo.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Conteiner obj){
		obj.setId(null);
		codigoCconteinerIsValid(obj.getCodigoConteiner());
		Conteiner conteiner = repo.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(conteiner.getId()).toUri();	
		
		return ResponseEntity.created(uri).build();
	}
	
	public boolean codigoCconteinerIsValid(String codigoConteiner) {
		
		if(!codigoConteiner.matches("[A-Z]{4}[0-9]{7}")) {
			throw new DataIntegrityViolationException("O código do conteiner está fora do padrão requerido. (4 letras maiúsculas seguido de 7 números");
		}
		
		return true;
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Conteiner obj, @PathVariable Long id){
		codigoCconteinerIsValid(obj.getCodigoConteiner());
		repo.save(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		repo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/tipos_conteiner", method = RequestMethod.GET)
	public ResponseEntity<TipoConteiner[]> getTiposConteiner() {
		
		return ResponseEntity.ok().body(TipoConteiner.values());
	}
	
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public ResponseEntity<StatusEspacoInterior[]> getStatusEspacoInterior() {
		return ResponseEntity.ok().body(StatusEspacoInterior.values());
	}
	
	@RequestMapping(value = "/categorias", method = RequestMethod.GET)
	public ResponseEntity<Categoria[]> getCategorias() {
		return ResponseEntity.ok().body(Categoria.values());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Conteiner>> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(repo.findById(id));
	}
}
