import java.util.LinkedList;
import java.util.PropertyResourceBundle;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.get;

public class Rest {
	LojaDeBike lojaBike;

	public Rest() {
		lojaBike = new LojaDeBike();
	}

	public void getBike() throws JSONException {
		// rota add uma bike
		get(new Route("/lojadebike/add/:preco/:cor/:numserie/:tamanho/:marca/:ano/:relacao/:suspensao") {
			@Override
			public Object handle(Request request, Response response) {
				
				//allows everyone to access the resource
	            response.header("Access-Control-Allow-Origin", "*");
				
				int precoBike = Integer.parseInt(request.params(":preco"));
				System.out.println(precoBike);
				String corBike = request.params(":cor");
				System.out.println(corBike);
				String numSerieBike = request.params(":numserie");
				System.out.println(numSerieBike);
				int tamanhoBike = Integer.parseInt(request.params(":tamanho"));
				System.out.println(tamanhoBike);
				String marcaBike = request.params(":marca").toUpperCase();
				System.out.println(marcaBike);
				int anoBike = Integer.parseInt(request.params(":ano"));
				System.out.println(anoBike);
				String relacaoBike = request.params(":relacao");
				System.out.println(relacaoBike);
				String suspensaoBike = request.params(":suspensao");
				System.out.println(suspensaoBike);

				boolean resultadoAdd = lojaBike.adicionarBike(new Bike(precoBike, corBike, numSerieBike,
						new EspecBike(tamanhoBike, marcaBike, anoBike, relacaoBike, suspensaoBike)));
				System.out.println(resultadoAdd);

				JSONArray jsonResult = new JSONArray();
				JSONObject jsonObj = new JSONObject();

				try {
					jsonObj.put("Resultado_add", resultadoAdd);
					jsonResult.put(jsonObj);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				return jsonResult;
			}
		});
		
		//retorna todas bikes
		get(new Route("/lojadebike/search/all"){
			@Override		
			public Object handle(Request request, Response response) {
				//allows everyone to access the resource
	            response.header("Access-Control-Allow-Origin", "*");
	            
	            LinkedList<Bike> todasBike = lojaBike.buscarTodasBikes();
	            JSONArray jsonResult = new JSONArray();
	            for (Bike bk : todasBike) {
					JSONObject jsonObj = new JSONObject();
					try {
						jsonObj.put("preco", bk.getPreco());
						jsonObj.put("cor", bk.getCor());
						jsonObj.put("numSerie", bk.getNumSerie());
						jsonObj.put("tamanho", bk.getSpec().getTamanho());
						jsonObj.put("marca", bk.getSpec().getMarca());
						jsonObj.put("ano", bk.getSpec().getAno());
						jsonObj.put("relacao", bk.getSpec().getRelacao());
						jsonObj.put("suspensao", bk.getSpec().getSuspensao());
						jsonResult.put(jsonObj);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				return jsonResult;
			}
		});
		
		// rota busca pelo numSerie
		get(new Route("/lojadebike/search/serie/:numserie") {
			@Override		
			public Object handle(Request request, Response response) {
				//allows everyone to access the resource
	            response.header("Access-Control-Allow-Origin", "*");
				
				System.out.println("aqui");
				String numSerieBike = request.params(":numserie");
				Bike resultadoNumSerie = lojaBike.buscarNumSerie(numSerieBike);
				System.out.println(resultadoNumSerie);

				JSONArray jsonResult = new JSONArray();
				JSONObject jsonObj = new JSONObject();
				try {
					jsonObj.put("preco", resultadoNumSerie.getPreco());
					jsonObj.put("cor", resultadoNumSerie.getCor());
					jsonObj.put("numSerie", resultadoNumSerie.getNumSerie());
					jsonObj.put("tamanho", resultadoNumSerie.getSpec().getTamanho());
					jsonObj.put("marca", resultadoNumSerie.getSpec().getMarca());
					jsonObj.put("ano", resultadoNumSerie.getSpec().getAno());
					jsonObj.put("relacao", resultadoNumSerie.getSpec().getRelacao());
					jsonObj.put("suspensao", resultadoNumSerie.getSpec().getSuspensao());
					jsonResult.put(jsonObj);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				return jsonResult;
			}
		});

		// rota busca pela espeficacao bike
		get(new Route("/lojadebike/search/espec/:tamanho/:marca/:ano/:relacao/:suspensao") {
			@Override
			public Object handle(Request request, Response response) {
				
				//allows everyone to access the resource
	            response.header("Access-Control-Allow-Origin", "*");
				
				int tamanhoBike = Integer.parseInt(request.params(":tamanho"));
				System.out.println(tamanhoBike);
				String marcaBike = request.params(":marca").toUpperCase();
				System.out.println(marcaBike);
				int anoBike = Integer.parseInt(request.params(":ano"));
				System.out.println(anoBike);
				String relacaoBike = request.params(":relacao");
				System.out.println(relacaoBike);
				String suspensaoBike = request.params(":suspensao");
				System.out.println(suspensaoBike);

				LinkedList<Bike> resultado = lojaBike
						.buscarEspecBike(new EspecBike(tamanhoBike, marcaBike, anoBike, relacaoBike, suspensaoBike));
				System.out.println(resultado);

				JSONArray jsonResult = new JSONArray();

				for (Bike bk : resultado) {
					JSONObject jsonObj = new JSONObject();
					try {
						jsonObj.put("preco", bk.getPreco());
						jsonObj.put("cor", bk.getCor());
						jsonObj.put("numSerie", bk.getNumSerie());
						jsonObj.put("tamanho", bk.getSpec().getTamanho());
						jsonObj.put("marca", bk.getSpec().getMarca());
						jsonObj.put("ano", bk.getSpec().getAno());
						jsonObj.put("relacao", bk.getSpec().getRelacao());
						jsonObj.put("suspensao", bk.getSpec().getSuspensao());
						jsonResult.put(jsonObj);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				return jsonResult;
			}
		});

		// rota busca pelo tamanho
		get(new Route("/lojadebike/search/size/:tamanho") {
			@Override
			public Object handle(Request request, Response response) {
				
				//allows everyone to access the resource
	            response.header("Access-Control-Allow-Origin", "*");
				
				int tamanhoBike = Integer.parseInt(request.params(":tamanho"));
				System.out.println(tamanhoBike);

				LinkedList<Bike> resultado = lojaBike.buscarTamanhoBike(tamanhoBike);
				System.out.println(resultado);

				JSONArray jsonResult = new JSONArray();

				for (Bike bk : resultado) {
					JSONObject jsonObj = new JSONObject();
					try {
						jsonObj.put("preco", bk.getPreco());
						jsonObj.put("cor", bk.getCor());
						jsonObj.put("numSerie", bk.getNumSerie());
						jsonObj.put("tamanho", bk.getSpec().getTamanho());
						jsonObj.put("marca", bk.getSpec().getMarca());
						jsonObj.put("ano", bk.getSpec().getAno());
						jsonObj.put("relacao", bk.getSpec().getRelacao());
						jsonObj.put("suspensao", bk.getSpec().getSuspensao());
						jsonResult.put(jsonObj);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				System.out.println(jsonResult);
				return jsonResult;
			}
		});

		// rota busca pelo preco
		get(new Route("/lojadebike/search/price/:preco") {
			public Object handle(Request request, Response response) {
				
				//allows everyone to access the resource
	            response.header("Access-Control-Allow-Origin", "*");
				
				int precoBike = Integer.parseInt(request.params(":preco"));
				System.out.println(precoBike);

				LinkedList<Bike> resultado = lojaBike.buscarPrecoBike(precoBike);
				System.out.println(resultado);

				JSONArray jsonResult = new JSONArray();

				for (Bike bk : resultado) {
					JSONObject jsonObj = new JSONObject();
					try {
						jsonObj.put("preco", bk.getPreco());
						jsonObj.put("cor", bk.getCor());
						jsonObj.put("numSerie", bk.getNumSerie());
						jsonObj.put("tamanho", bk.getSpec().getTamanho());
						jsonObj.put("marca", bk.getSpec().getMarca());
						jsonObj.put("ano", bk.getSpec().getAno());
						jsonObj.put("relacao", bk.getSpec().getRelacao());
						jsonObj.put("suspensao", bk.getSpec().getSuspensao());
						jsonResult.put(jsonObj);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				return jsonResult;
			}
		});
		
		// rota busca pela faixa de preco
		get(new Route("/lojadebike/search/rangeprice/:precomenor/:precomaior") {
			public Object handle(Request request, Response response) {
				
				//allows everyone to access the resource
	            response.header("Access-Control-Allow-Origin", "*");
				
				int precoMenor = Integer.parseInt(request.params(":precomenor"));
				System.out.println(precoMenor);
				int precoMaior = Integer.parseInt(request.params(":precomaior"));
				System.out.println(precoMaior);
				
				LinkedList<Bike> resultado = lojaBike.buscarFaixaDePrecoBike(precoMenor, precoMaior);
				System.out.println(resultado);

				JSONArray jsonResult = new JSONArray();

				for (Bike bk : resultado) {
					JSONObject jsonObj = new JSONObject();
					try {
						jsonObj.put("preco", bk.getPreco());
						jsonObj.put("cor", bk.getCor());
						jsonObj.put("numSerie", bk.getNumSerie());
						jsonObj.put("tamanho", bk.getSpec().getTamanho());
						jsonObj.put("marca", bk.getSpec().getMarca());
						jsonObj.put("ano", bk.getSpec().getAno());
						jsonObj.put("relacao", bk.getSpec().getRelacao());
						jsonObj.put("suspensao", bk.getSpec().getSuspensao());
						jsonResult.put(jsonObj);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				return jsonResult;
			}
		});
		
		// rota busca pela marca
		get(new Route("/lojadebike/search/brand/:marca") {
			@Override
			public Object handle(Request request, Response response) {
				
				//allows everyone to access the resource
	            response.header("Access-Control-Allow-Origin", "*");
				
				String marcaBike = request.params(":marca").toUpperCase();
				System.out.println(marcaBike);

				LinkedList<Bike> resultadoMarca = lojaBike.buscarMarcaBike(marcaBike);

				JSONArray jsonResult = new JSONArray();

				for (Bike bk : resultadoMarca) {
					JSONObject jsonObj = new JSONObject();
					try {
						jsonObj.put("preco", bk.getPreco());
						jsonObj.put("cor", bk.getCor());
						jsonObj.put("numSerie", bk.getNumSerie());
						jsonObj.put("tamanho", bk.getSpec().getTamanho());
						jsonObj.put("marca", bk.getSpec().getMarca());
						jsonObj.put("ano", bk.getSpec().getAno());
						jsonObj.put("relacao", bk.getSpec().getRelacao());
						jsonObj.put("suspensao", bk.getSpec().getSuspensao());
						jsonResult.put(jsonObj);
					} catch (JSONException e) {
						e.printStackTrace();
					}

				}

				return jsonResult;
			}

		});

		//rota buscar bike de acordo com tamanho cliente
		get(new Route("/lojadebike/search/sizeclient/:tamanhocliente") {
			public Object handle(Request request, Response response) {
				
				//allows everyone to access the resource
	            response.header("Access-Control-Allow-Origin", "*");
				
				double tamanhoCliente = Double.parseDouble(request.params(":tamanhocliente"));
				System.out.println(tamanhoCliente);

				LinkedList<Bike> resultado = lojaBike.buscarBikeTamanhoCliente(tamanhoCliente);
				System.out.println(resultado);

				JSONArray jsonResult = new JSONArray();

				for (Bike bk : resultado) {
					JSONObject jsonObj = new JSONObject();
					try {
						jsonObj.put("preco", bk.getPreco());
						jsonObj.put("cor", bk.getCor());
						jsonObj.put("numSerie", bk.getNumSerie());
						jsonObj.put("tamanho", bk.getSpec().getTamanho());
						jsonObj.put("marca", bk.getSpec().getMarca());
						jsonObj.put("ano", bk.getSpec().getAno());
						jsonObj.put("relacao", bk.getSpec().getRelacao());
						jsonObj.put("suspensao", bk.getSpec().getSuspensao());
						jsonResult.put(jsonObj);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				return jsonResult;
			}
		});
		
		// rota deleta de acordo com o numSerie
		get(new Route("/lojadebike/delete/:numserie") {
			@Override
			public Object handle(Request request, Response response) {
				
				//allows everyone to access the resource
	            response.header("Access-Control-Allow-Origin", "*");
				
				String numSerie = request.params(":numserie");
				System.out.println(numSerie);

				boolean resultadoDelete = lojaBike.delete(numSerie);
				System.out.println(resultadoDelete);

				JSONArray jsonResult = new JSONArray();
				JSONObject jsonObj = new JSONObject();

				try {
					jsonObj.put("Resultado_delete", resultadoDelete);
					jsonResult.put(jsonObj);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				return jsonResult;
			}
		});

		// rota para alterar
		get(new Route("/lojadebike/update/:numserieantigo/:preco/:cor/:numserienovo/:tamanho/:marca/:ano/:relacao/:suspensao") {
			@Override
			public Object handle(Request request, Response response) {
				
				//allows everyone to access the resource
	            response.header("Access-Control-Allow-Origin", "*");
				
				String numSerieAntigo = request.params(":numserieantigo");
				int precoBike = Integer.parseInt(request.params(":preco"));
				System.out.println(precoBike);
				String corBike = request.params(":cor");
				System.out.println(corBike);
				String numSerieBike = request.params(":numserienovo");
				System.out.println(numSerieBike);
				int tamanhoBike = Integer.parseInt(request.params(":tamanho"));
				System.out.println(tamanhoBike);
				String marcaBike = request.params(":marca").toUpperCase();
				System.out.println(marcaBike);
				int anoBike = Integer.parseInt(request.params(":ano"));
				System.out.println(anoBike);
				String relacaoBike = request.params(":relacao");
				System.out.println(relacaoBike);
				String suspensaoBike = request.params(":suspensao");
				System.out.println(suspensaoBike);

				boolean resultadoUpdate = lojaBike.alterarBike(numSerieAntigo, new Bike(precoBike, corBike, numSerieBike,
						new EspecBike(tamanhoBike, marcaBike, anoBike, relacaoBike, suspensaoBike)));
				
				Bike bikeAlterada = lojaBike.buscarNumSerie(numSerieAntigo);
				System.out.println(bikeAlterada);

				JSONArray jsonResult = new JSONArray();
				JSONObject jsonObj = new JSONObject();
				try {
					jsonObj.put("Resultado_update", resultadoUpdate);
					jsonResult.put(jsonObj);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				System.out.println("UPDATE - "+jsonResult);
				return jsonResult;
			}
		});
	}

	public void addEstoqueRest() {
		lojaBike.adicionarBike(
				new Bike(1900, "vermelho", "4abc7109", new EspecBike(18, "TREK", 2015, "deore", "rochshox_xc32")));
		lojaBike.adicionarBike(
				new Bike(2800, "preto", "axv23110", new EspecBike(16, "SPECIALIZED", 2013, "xt/slx", "rochshox_reba")));
		lojaBike.adicionarBike(
				new Bike(1700, "branco/preto", "373nc9jaf", new EspecBike(17, "SCOTT", 2015, "xtr", "fox_float")));
		lojaBike.adicionarBike(
				new Bike(3500, "verde", "176hsc23", new EspecBike(17, "CANNONDALE", 2015, "xtr", "lefty_suspension")));
	}
}
