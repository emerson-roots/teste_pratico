package teste_pratico.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import teste_pratico.domain.MovimentacaoConteiner;
import teste_pratico.domain.enums.Categoria;
import teste_pratico.domain.enums.TipoMovimentacao;
import teste_pratico.repositories.MovimentacaoConteinerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/movimentacao_conteiners")
public class MovimentacaoConteinerResource {

	
	@Autowired
	private MovimentacaoConteinerRepository repo;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MovimentacaoConteiner>> findAll(){
		
		List<MovimentacaoConteiner> list = repo.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody MovimentacaoConteiner obj){
		obj.setId(null);
		MovimentacaoConteiner movimentacaoConteiner = repo.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(movimentacaoConteiner.getId()).toUri();	
		
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody MovimentacaoConteiner obj, @PathVariable Long id){
		repo.save(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		repo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/relatorio", method = RequestMethod.GET)
	public ResponseEntity<List<String>> relatorio() {
		
		
		
		List<MovimentacaoConteiner> list = repo.findAllByOrderByConteinerIdDesc();
		List<String> relatorio = new ArrayList<>();

		int contadorExportacao = 0;
		int contadorImportacao = 0;

		relatorio.add("=== RELATÓRIO DE MOVIMENTAÇÕES ORDENADO POR CLIENTE ===");
		for (int i = 0; i < list.size(); i++) {

			MovimentacaoConteiner newObj = list.get(i);
			relatorio.add("Cliente: " + newObj.getConteiner().getCliente() + " | Tipo Movimentação: " + newObj.getTipoMovimentacao());

			if (newObj.getConteiner().getCategoria().equals(Categoria.IMPORTACAO)) {
				contadorImportacao++;
			} else if (newObj.getConteiner().getCategoria().equals(Categoria.EXPORTACAO)) {
				contadorExportacao++;
			}

		}
		
		relatorio.add("                                                ");
		relatorio.add("=================== SUMÁRIO  ===================");
		relatorio.add("Movimentações: " + list.size() + " | Importações: " + contadorImportacao + " | Exportações: " + contadorExportacao);

		return ResponseEntity.ok().body(relatorio);
	}
	
	@RequestMapping(value = "/tipo_movimentacoes", method = RequestMethod.GET)
	public ResponseEntity<TipoMovimentacao[]> getCategorias() {
		return ResponseEntity.ok().body(TipoMovimentacao.values());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<MovimentacaoConteiner>> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(repo.findById(id));
	}
	
	
}
