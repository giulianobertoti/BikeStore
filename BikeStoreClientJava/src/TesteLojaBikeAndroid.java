	import java.util.LinkedList;

public class TesteLojaBikeAndroid {

	public static void main(String[] args) {
		LojaDeBikeAndroid lojaDeBike = new LojaDeBikeAndroid();

		LinkedList<Bike> todasBike = lojaDeBike.getBikes();
		//LinkedList<Bike> resultadoSpec = lojaDeBike.getSpec(new EspecBike(18, "TREK", 2015, "deore", "rochshox_xc32")); // 01
		//LinkedList<Bike> resultadoPreco = lojaDeBike.getPreco(3500); // 04
		//LinkedList<Bike> resultadoMarca = lojaDeBike.getMarca("SCOTT"); // 03
		//LinkedList<Bike> resultadoTamanho = lojaDeBike.getTamanho(16); // 02
		//LinkedList<Bike> resultadoFaixaPreco = lojaDeBike.getFaixaDePreco(1400, 2000);
		//LinkedList<Bike> resultadoNumSerie = lojaDeBike.getNumSerie("18y21n");
		
		boolean add = lojaDeBike.addBike(new Bike(3500, "vermelho-preto", "42hsg109", new EspecBike(18, "OGGI", 2015, "xt", "rochshox_xc28")));
		//System.out.println(add + " - BIKE ADD");
		
		boolean delete = lojaDeBike.deleteBike("42hsg109");
		//System.out.println(delete + " - BIKE DELETE");
		
		boolean update = lojaDeBike.updateBike("4abc7109", new Bike(1900, "azul", "4abc7109", new EspecBike(18, "TREK", 2015, "deore", "rochshox_xc32")));
		//System.out.println(update + " - UPDATE");
		
		//TODAS BIKES
		for (Bike bike : todasBike) {
			System.out.println("Preco: " + bike.getPreco());
			System.out.println("Cor: " + bike.getCor());
			System.out.println("Numero Serie: " + bike.getNumSerie());
			System.out.println("Tamanho: " + bike.getSpec().getTamanho());
			System.out.println("Marca: " + bike.getSpec().getMarca());
			System.out.println("Ano: " + bike.getSpec().getAno());
			System.out.println("Relacao: " + bike.getSpec().getRelacao());
			System.out.println("Suspensao: " + bike.getSpec().getSuspensao());
			System.out.println("-------------------------------------------");
		}
		
//		 RESULTADO BUSCA PELA ESPECIFICACAO
//		for (Object bike : resultadoSpec) {
//			System.out.println("Busca pela Especificacao\n");
//			System.out.println(bike);
//		}
//
//		// RESULTADO BUSCA PELO PRECO
//		for (Object preco : resultadoPreco) {
//			System.out.println("Busca pelo Preco\n");
//			System.out.println(preco);
//		}
//
//		// RESULTADO BUSCA PELA MARCA
//		for (Bike marca : resultadoMarca) {
//			System.out.println("Busca pela Marca\n");
//			System.out.println(marca);
//		}
//
//		// RESULTADO BUSCA PELO TAMANHO
//		for (Bike tamanho : resultadoTamanho) {
//			System.out.println("Busca pelo Tamanho\n");
//			System.out.println(tamanho);
//		}
//
//		// RESULTADO BUSCA PELA FAIXA DE PRECO
//		for (Bike faixaPreco : resultadoFaixaPreco) {
//			System.out.println("Busca pelo FaixaPreco\n");
//			System.out.println(faixaPreco);
//		}
//
//		// RESULTADO BUSCA PELO NUM SERIE (BIKE ALTERADA - COR AMARELO)
//		System.out.println("Busca pelo NumSerie\n");
//		System.out.println(resultadoNumSerie);

	}

}
