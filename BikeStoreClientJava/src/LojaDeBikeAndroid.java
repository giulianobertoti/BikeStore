import java.util.LinkedList;

public class LojaDeBikeAndroid {
	LinkedList<Bike> lojaDeBike = new LinkedList<Bike>();
	Connection connection = new Connection();

	public boolean addBike(Bike bike){
		try {
			boolean add = connection.addBike(new Bike(bike.getPreco(),bike.getCor(),bike.getNumSerie(),new EspecBike(bike.getSpec().getTamanho(),bike.getSpec().getMarca(),bike.getSpec().getAno(),bike.getSpec().getRelacao(),bike.getSpec().getSuspensao())));
			return add;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public LinkedList<Bike> getBikes() {
		try {
			lojaDeBike = connection.buscaTodasBikes();
			return lojaDeBike;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public LinkedList<Bike> getNumSerie(String numSerie) {
		try {
			lojaDeBike = connection.buscarNumSerie(numSerie);
			return lojaDeBike;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public LinkedList<Bike> getSpec(EspecBike spec) {
		try {
			lojaDeBike = connection.buscarSpec(spec.getTamanho(), spec.getMarca(), spec.getAno(), spec.getRelacao(), spec.getSuspensao());
			return lojaDeBike;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public LinkedList<Bike> getTamanho(int tamanho) {
		try {
			lojaDeBike = connection.buscarTamanho(tamanho);
			return lojaDeBike;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public LinkedList<Bike> getFaixaDePreco(int precoMenor, int precoMaior) {
		try {
			lojaDeBike = connection.buscarFaixaPreco(precoMenor, precoMaior);
			return lojaDeBike;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public LinkedList<Bike> getPreco(int preco) {
		try {
			lojaDeBike = connection.buscarPreco(preco);
			return lojaDeBike;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public LinkedList<Bike> getMarca(String marca) {
		try {
			lojaDeBike = connection.buscarMarca(marca);
			return lojaDeBike;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deleteBike(String numSerie){
		try {
			boolean delete = connection.deletarBike(numSerie);
			return delete;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateBike(String numSerieAntigo, Bike bike){
		try {
			boolean update = connection.alterarBike(numSerieAntigo, bike);
			System.out.println(update + "updateBike");
			return update;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
