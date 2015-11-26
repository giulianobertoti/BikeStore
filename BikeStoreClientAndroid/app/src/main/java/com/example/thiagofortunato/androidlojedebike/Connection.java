package com.example.thiagofortunato.androidlojedebike;

import android.os.StrictMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;

public class Connection {
	//"http://172.16.1.132:4567/lojadebike/search/all"
	//this is my json: https://api.myjson.com/bins/2trql
	// BUSCA TODAS BIKES
	public LinkedList<Bike> buscaTodasBikes() throws Exception {
		String url = "http://192.168.1.31:4567/lojadebike/search/all";

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); //linha chave para execução das treds
		StrictMode.setThreadPolicy(policy);

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return convertJason(new JSONArray(response.toString()));
	}

	//BUSCA PELO NUM DE SERIE
	public LinkedList<Bike> buscarNumSerie(String numSerie) throws Exception {
		String url = "http://192.168.1.31:4567/lojadebike/search/serie/" +numSerie;

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); //linha chave para execução das treds
		StrictMode.setThreadPolicy(policy);

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();


		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		LinkedList<Bike> found = convertJason(new JSONArray(response.toString()));
		return found;
	}

	//ADD UMA BIKE - RETORNA BOOLEANO
	public boolean addBike(Bike bike) throws Exception {
		boolean found = false;
		String url = "http://192.168.1.31:4567/lojadebike/add/" + bike.getPreco() + "/" + bike.getCor() + "/"
				+ bike.getNumSerie() + "/" + bike.getSpec().getTamanho() + "/" + bike.getSpec().getMarca() + "/"
				+ bike.getSpec().getAno() + "/" + bike.getSpec().getRelacao() + "/" + bike.getSpec().getSuspensao();

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); //linha chave para execução das treds
		StrictMode.setThreadPolicy(policy);

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		try {
			JSONArray jsonArray = new JSONArray(response.toString());
			JSONObject jsonObj = jsonArray.getJSONObject(0);
			found = jsonObj.getBoolean("Resultado_add");
		} catch (JSONException e) {

		}
		return found;
	}

	//DELETE BIKE - RETORNA BOOLEANO
	public boolean deletarBike(String numSerie) throws Exception {
		boolean delete = false;
		String url = "http://192.168.1.31:4567/lojadebike/delete/" + numSerie;

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); //linha chave para execução das treds
		StrictMode.setThreadPolicy(policy);

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		try {
			JSONArray jsonArray = new JSONArray(response.toString());
			JSONObject jsonObj = jsonArray.getJSONObject(0);
			delete = jsonObj.getBoolean("Resultado_delete");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return delete;
	}

	//ALTER BIKE - RETORNA BOOLEANO
	public boolean alterarBike(String numSerieAntigo, Bike bike) throws Exception{
		boolean update= false;
		String url = "http://192.168.1.31:4567/lojadebike/update/"+numSerieAntigo+
				"/"+bike.getPreco()+
				"/"+bike.getCor()+
				"/"+bike.getNumSerie()+
				"/"+bike.getSpec().getTamanho()+
				"/"+bike.getSpec().getMarca()+
				"/"+bike.getSpec().getAno()+
				"/"+bike.getSpec().getRelacao()+
				"/"+bike.getSpec().getSuspensao();

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); //linha chave para execução das treds
		StrictMode.setThreadPolicy(policy);

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		try {
			JSONArray jsonArray = new JSONArray(response.toString());
			System.out.println(jsonArray+ " JSONARRAY");
			JSONObject jsonObj = jsonArray.getJSONObject(0);
			System.out.println(jsonObj+ " JSONOBJ");
			update = jsonObj.getBoolean("Resultado_update");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return update;
	}

	public LinkedList<Bike> convertJason(JSONArray response) {
		LinkedList<Bike> found = new LinkedList<>();
		try {
			for (int i = 0; i < response.length(); i++) {
				JSONObject obj = response.getJSONObject(i);
				found.add(new Bike(obj.getInt("preco"), obj.getString("cor"), obj.getString("numSerie"),
						new EspecBike(obj.getInt("tamanho"), obj.getString("marca"), obj.getInt("ano"),
								obj.getString("relacao"), obj.getString("suspensao"))));
			}
		} catch (JSONException e) {
			// handle exception
		}
		return found;
	}


}
