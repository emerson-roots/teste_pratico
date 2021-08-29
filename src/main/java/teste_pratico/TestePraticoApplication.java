package teste_pratico;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import teste_pratico.domain.Conteiner;
import teste_pratico.domain.MovimentacaoConteiner;
import teste_pratico.domain.enums.Categoria;
import teste_pratico.domain.enums.StatusEspacoInterior;
import teste_pratico.domain.enums.TipoConteiner;
import teste_pratico.domain.enums.TipoMovimentacao;
import teste_pratico.repositories.ConteinerRepository;
import teste_pratico.repositories.MovimentacaoConteinerRepository;

@SpringBootApplication
public class TestePraticoApplication implements CommandLineRunner{

	@Autowired
	private ConteinerRepository conteinerRepository;
	
	@Autowired
	private MovimentacaoConteinerRepository movConteinerRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(TestePraticoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Conteiner conteiner1 = new Conteiner(null, "Emerson Melo", "TEST1234567", TipoConteiner.PES_20, StatusEspacoInterior.VAZIO, Categoria.IMPORTACAO);
		Conteiner conteiner2 = new Conteiner(null, "Joaquim", "ABCD7654321", TipoConteiner.PES_40, StatusEspacoInterior.VAZIO, Categoria.EXPORTACAO);
		Conteiner conteiner3 = new Conteiner(null, "Amélia", "XYZA1425637", TipoConteiner.PES_40, StatusEspacoInterior.CHEIO, Categoria.EXPORTACAO);
		conteinerRepository.saveAll(Arrays.asList(conteiner1, conteiner2, conteiner3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		MovimentacaoConteiner movimentacaoConteiner1 = new MovimentacaoConteiner(null, TipoMovimentacao.EMBARQUE, sdf.parse("30/09/2017 10:32"), sdf.parse("07/10/2018 11:32"), conteiner1);
		MovimentacaoConteiner movimentacaoConteiner2 = new MovimentacaoConteiner(null, TipoMovimentacao.PESAGEM, sdf.parse("01/01/2018 21:55"), sdf.parse("02/01/2018 05:44"), conteiner1);
		MovimentacaoConteiner movimentacaoConteiner3 = new MovimentacaoConteiner(null, TipoMovimentacao.DESCARGA, sdf.parse("25/07/2020 03:40"), sdf.parse("28/07/2020 11:57"), conteiner2);
		movConteinerRepo.saveAll(Arrays.asList(movimentacaoConteiner1, movimentacaoConteiner2, movimentacaoConteiner3));
		
	}

}
