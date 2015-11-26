import java.util.LinkedList;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class TesteBike {
	public static void main(String[] args) {
		// CRIO UMA LOJA DE BIKE
		LojaDeBike lojaBike = new LojaDeBike();

		// ADICIONO TRÊS BIKES NA LOJA
		lojaBike.adicionarBike(	new Bike(1900, "vermelho", "4abc7109", new EspecBike(18, "TREK", 2015, "deore", "rochshox_xc32")));
		lojaBike.adicionarBike(	new Bike(2800, "preto", "axv23110", new EspecBike(16, "SPECIALIZED", 2013, "xt_slx", "rochshox_reba")));
		lojaBike.adicionarBike(	new Bike(1700, "branco/preto", "373nc9jaf", new EspecBike(17, "SCOTT", 2015, "xtr", "fox_float")));
		lojaBike.adicionarBike(	new Bike(3500, "verde", "176hsc23", new EspecBike(17, "CANNONDALE", 2015, "xtr", "lefty_suspension")));

		// PESQUISO PELA ESPECIFICACAO, PRECO E MARCA DAS BIKES
		LinkedList<Bike> resultadoBike = lojaBike.buscarEspecBike(new EspecBike(18, "TREK", 2015, "deore", "rochshox_xc32")); // 01
		LinkedList<Bike> resultadoPreco = lojaBike.buscarPrecoBike(3500); // 04
		LinkedList<Bike> resultadoMarca = lojaBike.buscarMarcaBike("SCOTT"); // 03
		LinkedList<Bike> resultadoTamanho = lojaBike.buscarTamanhoBike(16); // 02
		LinkedList<Bike> resultadoFaixaPreco = lojaBike.buscarFaixaDePrecoBike(1600, 4000);
		LinkedList<Bike> resultadoClienteTamanho = lojaBike.buscarBikeTamanhoCliente(1.79);
		LinkedList<Bike> resultadoTodasBike = lojaBike.buscarTodasBikes();
		Bike resultadoNumSerie = lojaBike.buscarNumSerie("4abc7109");

		boolean resultadoAlterar = lojaBike.alterarBike("4abc7109",new Bike(1900, "azul", "4abc7109", new EspecBike(18, "TREK", 2015, "deore", "rochshox_xc32")));
		System.out.println(resultadoAlterar+" - Bike Alterada");
		
		// DELETO A BIKE DO BANCO
		// boolean resultadoDelete = lojaBike.delete("4abc7109");

		// RESULTADO BUSCA PELA ESPECIFICACAO
		for (Object bike : resultadoBike) {
			System.out.println("Busca pela Especificacao\n");
			System.out.println(bike);
		}

		// RESULTADO BUSCA PELO PRECO
		for (Object preco : resultadoPreco) {
			System.out.println("Busca pelo Preco\n");
			System.out.println(preco);
		}

		// RESULTADO BUSCA PELA MARCA
		for (Bike marca : resultadoMarca) {
			System.out.println("Busca pela Marca\n");
			System.out.println(marca);
		}

		// RESULTADO BUSCA PELO TAMANHO
		for (Bike tamanho : resultadoTamanho) {
			System.out.println("Busca pelo Tamanho\n");
			System.out.println(tamanho);
		}

		// RESULTADO BUSCA PELA FAIXA DE PRECO
		for (Bike faixaPreco : resultadoFaixaPreco) {
			System.out.println("Busca pelo FaixaPreco\n");
			System.out.println(faixaPreco);
		}

		// RESULTADO BUSCA PELO NUM SERIE (BIKE ALTERADA - COR AMARELO)
		System.out.println("Busca pelo NumSerie\n");
		System.out.println(resultadoNumSerie);

		// RESULTADO BUSCA PELO TAMANHO DO CLIENTE (BIKFIT)
		for (Bike tamanhoCliente : resultadoClienteTamanho) {
			System.out.println("Buscar pelo Tamanho Cliente Bike (BIKE FIT)\n");
			System.out.println(tamanhoCliente);
		}

		// RESULTADO DE TODAS BIKES
		for (Bike todasBike : resultadoTodasBike) {
			System.out.println("Buscar Todas Bikes\n");
			System.out.println(todasBike);
		}

		// //RESULTADO DELETE
		// System.out.println("Busca pelo NumSerie\n");
		// System.out.println(resultadoDelete);

	}
}
