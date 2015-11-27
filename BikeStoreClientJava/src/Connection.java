import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Connection {
	private final String USER_AGENT = "Mozilla/5.0";

	// HTTP GET request
	public LinkedList<Bike> recebeRota(String url) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

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

	// ADD BIKE
	public boolean addBike(Bike bike) throws Exception {
		boolean found = false;
		// set ip of the server for connection
		String url = "http://127.0.0.1:4567/lojadebike/add/" + bike.getPreco() + "/" + bike.getCor() + "/"
				+ bike.getNumSerie() + "/" + bike.getSpec().getTamanho() + "/" + bike.getSpec().getMarca() + "/"
				+ bike.getSpec().getAno() + "/" + bike.getSpec().getRelacao() + "/" + bike.getSpec().getSuspensao();

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

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

	// BUSCA TODAS BIKES
	public LinkedList<Bike> buscaTodasBikes() throws Exception {
		// set ip of the server for connection
		String url = "https://api.myjson.com/bins/2trql";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		return convertJason(new JSONArray(response.toString()));
	}

	// BUSCA NUMSERIE
	public LinkedList<Bike> buscarNumSerie(String numSerie) throws Exception {
		// set ip of the server for connection
		String url = "http://127.0.0.1:4567/lojadebike/search/serie/" + numSerie;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

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

	// BUSCA ESPECIFICACOES
	public LinkedList<Bike> buscarSpec(int tamanho, String marca, int ano, String relacao, String suspensao)
			throws Exception {
		// set ip of the server for connection
		String url = "http://127.0.0.1:4567/lojadebike/search/espec/" + tamanho + "/" + marca + "/" + ano + "/"
				+ relacao + "/" + suspensao;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
			System.out.println(response);
			System.out.println("\n");
		}
		in.close();

		LinkedList<Bike> found = convertJason(new JSONArray(response.toString()));

		return found;
	}

	// BUSCA TAMANHO
	public LinkedList<Bike> buscarTamanho(int tamanho) throws Exception {
		// set ip of the server for connection
		String url = "http://127.0.0.1:4567/lojadebike/search/size/" + tamanho;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

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

	// BUSCA FAIXA PRECO
	public LinkedList<Bike> buscarFaixaPreco(int precoMenor, int precoMaior) throws Exception {
		// set ip of the server for connection
		String url = "http://127.0.0.1:4567/lojadebike/search/rangeprice/" + precoMenor + "/" + precoMaior;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

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

	// BUSCA PRECO
	public LinkedList<Bike> buscarPreco(int preco) throws Exception {
		// set ip of the server for connection
		String url = "http://127.0.0.1:4567/lojadebike/search/price/" + preco;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		System.out.println(response);
		in.close();

		LinkedList<Bike> found = convertJason(new JSONArray(response.toString()));

		return found;
	}

	// BUSCA MARCA
	public LinkedList<Bike> buscarMarca(String marca) throws Exception {
		// set ip of the server for connection
		String url = "http://127.0.0.1:4567/lojadebike/search/brand/" + marca;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();

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

	// DELETE BIKE
	public boolean deletarBike(String numSerie) throws Exception {
		boolean delete = false;
		// set ip of the server for connection
		String url = "http://127.0.0.1:4567/lojadebike/delete/" + numSerie;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

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

	// UPDATE BIKE
	public boolean alterarBike(String numSerieAntigo, Bike bike) throws Exception{
		boolean update= false;
		// set ip of the server for connection
		String url = "http://127.0.0.1/lojadebike/update/"+numSerieAntigo+
								"/"+bike.getPreco()+
								"/"+bike.getCor()+
								"/"+bike.getNumSerie()+
								"/"+bike.getSpec().getTamanho()+
								"/"+bike.getSpec().getMarca()+
								"/"+bike.getSpec().getAno()+
								"/"+bike.getSpec().getRelacao()+
								"/"+bike.getSpec().getSuspensao();
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

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

	// CONVERTE JSON
	public LinkedList<Bike> convertJason(JSONArray response) {
		LinkedList<Bike> found = new LinkedList<Bike>();
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
