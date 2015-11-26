package com.example.thiagofortunato.androidlojedebike;

import java.util.LinkedList;
import java.util.List;

public class LojaDeBikeAndroid {
	LinkedList<Bike> lojaDeBike = new LinkedList<Bike>();
	Connection connection = new Connection();

	public void getBikes() {
		try {
			lojaDeBike = connection.buscaTodasBikes();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> getAllNumSerie(){
		List<String> allNumSerie = new LinkedList<>();
		for (Bike bike: lojaDeBike) {
			allNumSerie.add(bike.getNumSerie());
		}
		return allNumSerie;
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

	public boolean addBike(Bike bike){
		try {
			boolean add = connection.addBike(new Bike(bike.getPreco(),bike.getCor(),bike.getNumSerie(),new EspecBike(bike.getSpec().getTamanho(),bike.getSpec().getMarca(),bike.getSpec().getAno(),bike.getSpec().getRelacao(),bike.getSpec().getSuspensao())));
			return add;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
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
			return update;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}


}
