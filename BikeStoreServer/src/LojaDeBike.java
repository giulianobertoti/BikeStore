import com.db4o.ObjectContainer;

import java.awt.List;
import java.util.LinkedList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;


public class LojaDeBike{
	
	//cria um banco do tipo ObjectContainer 
	ObjectContainer lojaBike = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "../lojadebike.db4o");
	
	int grupo1[] = {13,14,15,16};  //1.50 - 1.65 S
	int grupo2[] = {17,18,19}; 	//1.66 - 1.81 M
	int grupo3[] = {20,21,22,23};	//1.82 - 2.00++ L
	
	//adiciona uma bike caso não exista uma igual | retorna boolean
	public boolean adicionarBike(Bike b)
	{
		if(!verificaExistente(b.getNumSerie())){
			lojaBike.store(b);
			lojaBike.commit();
			return true;
		}
		return false;
	}
	
	public LinkedList<Bike> buscarTodasBikes(){
		Query query = lojaBike.query();
		query.constrain(Bike.class);
		ObjectSet<Bike> resultadoTodas = query.execute();
		LinkedList<Bike> todasBikes = new LinkedList<>();
		for(Bike bike: resultadoTodas){
			todasBikes.add(bike);
		}
		return todasBikes;
	}
	
	
	//Busca bike por especificacao | retorna uma lista
	public LinkedList<Bike> buscarEspecBike(EspecBike spec)
	{
		Query query = lojaBike.query();
		query.constrain(Bike.class);
		//query.descend("spec").constrain(spec);
		ObjectSet<Bike> resultadoEspecBike = query.execute();
		LinkedList<Bike> bikeEspec = new LinkedList<>();
		for (Bike specBike : resultadoEspecBike)
		{
			if(specBike.getSpec().comparar(spec)) bikeEspec.add(specBike);
		}
		return bikeEspec;
	}
	
	//busca bike pelo preco | retorna uma lista
	public LinkedList<Bike> buscarPrecoBike(int p)
	{	
		Query query = lojaBike.query();
		//query.descend("preco").constrain(p);
		query.constrain(Bike.class);
		ObjectSet<Bike> resultadoPrecoBike = query.execute();
		LinkedList<Bike> bikePreco = new LinkedList<>();
		for(Bike precoBike: resultadoPrecoBike)
		{
			if(precoBike.getPreco() == p) bikePreco.add(precoBike);
		}
		return bikePreco;
	}
	
	//busca por uma faixa de preco | retorna uma lista
	public LinkedList<Bike> buscarFaixaDePrecoBike(int precoMenor, int precoMaior)
	{	
		Query query = lojaBike.query();
		//query.descend("preco").constrain(p);
		query.constrain(Bike.class);
		ObjectSet<Bike> resultadoPrecoBike = query.execute();
		LinkedList<Bike> bikePreco = new LinkedList<>();
		for(Bike precoBike: resultadoPrecoBike)
		{
			if((precoBike.getPreco() > precoMenor) && (precoBike.getPreco() < precoMaior)) bikePreco.add(precoBike);
		}
		return bikePreco;
	}
	
	//busca por tamanho de bike | retorna uma lista
	public LinkedList<Bike> buscarTamanhoBike(int p)
	{	
		Query query = lojaBike.query();
		//query.descend("preco").constrain(p);
		query.constrain(Bike.class);
		ObjectSet<Bike> resultadoPrecoBike = query.execute();
		LinkedList<Bike> bikeTamanho = new LinkedList<>();
		for(Bike tamanhoBike: resultadoPrecoBike)
		{
			if(tamanhoBike.getSpec().getTamanho() == p) bikeTamanho.add(tamanhoBike);
		}
		return bikeTamanho;
	}
	
	//busca por marca | retorna uma lista
	public LinkedList<Bike> buscarMarcaBike(String m)
	{
		Query query = lojaBike.query();
		query.constrain(Bike.class);
		ObjectSet<Bike> resultadoMarcaBike = query.execute();
		LinkedList<Bike> marcaBike = new LinkedList<>();
		
		for(Bike bikeEstoque : resultadoMarcaBike)
		{
			if(bikeEstoque.getSpec().getMarca().equals(m))  marcaBike.add(bikeEstoque);
		}		
		return marcaBike;
	}
	
	//busca pelo numSerie | retoruma uma bike
	public Bike buscarNumSerie(String numSerie)
	{
		Query query = lojaBike.query();
		query.constrain(Bike.class);
		ObjectSet<Bike> encontrada = query.execute();
		for(Bike bk : encontrada)
		{
			if(bk.getNumSerie().equals(numSerie)) return bk;
		}
		return null;
	}
	
	//deleta as bike de acordo com o numero de serie | retorna boolean
	public boolean delete(String numSerie)
	{
		Query query = lojaBike.query();
		query.constrain(Bike.class);
		ObjectSet<Bike> encontrada = query.execute();
		for(Bike bk : encontrada)
		{
			if(bk.getNumSerie().equals(numSerie)) {
				lojaBike.delete(bk);
				return true;
			}
		}
		return false;
	}
	
	//procura por uma bike e altera seus atributos
	public boolean alterarBike(String numSerieAntigo,Bike newBike)
	{
		if(buscarNumSerie(numSerieAntigo) != null){
			Bike bikeEstoque = buscarNumSerie(numSerieAntigo);
			
			bikeEstoque.setNumSerie(newBike.getNumSerie());
			bikeEstoque.setCor(newBike.getCor());
			bikeEstoque.setPreco(newBike.getPreco());
			bikeEstoque.getSpec().setAno(newBike.getSpec().getAno());
			bikeEstoque.getSpec().setRelacao(newBike.getSpec().getRelacao());
			bikeEstoque.getSpec().setSuspensao(newBike.getSpec().getSuspensao());
			bikeEstoque.getSpec().setTamanho(newBike.getSpec().getTamanho());
			bikeEstoque.getSpec().setMarca(newBike.getSpec().getMarca());
			
			lojaBike.commit();
			return true;
		}
		return false;
	}
	
	//verifica se ja existe essa bike no estoque
	//metodo para nao deixar cadastrar uma bike que ja exite | retorna boolean
	public boolean verificaExistente(String numSerie)				
	{
		Query query = lojaBike.query();
		query.constrain(Bike.class);
		ObjectSet<Bike> encontrada = query.execute();
		
		for(Bike bk: encontrada)
		{
			if(bk.getNumSerie().equals(numSerie)) return true;
		}
		return false;
	}	
	
	//metodo para procurar uma bike de acordo com o cliente
	public LinkedList<Bike> buscarBikeTamanhoCliente(double tamanhoCliente){
		Query query = lojaBike.query();
		query.constrain(Bike.class);
		ObjectSet<Bike> encontrada = query.execute();
		LinkedList<Bike> tamanhoBikeCliente = new LinkedList<>();
		
		for(Bike tamBikeCliente: encontrada){
			if(tamanhoCliente >= 1.50 && tamanhoCliente <= 1.65){
				for(int i: grupo1){
					if(tamBikeCliente.getSpec().getTamanho() == i){
						tamanhoBikeCliente.add(tamBikeCliente);
					}
				}
			}else if (tamanhoCliente >= 1.66 && tamanhoCliente <= 1.81){
				for(int i: grupo2){
					if(tamBikeCliente.getSpec().getTamanho() == i){
						tamanhoBikeCliente.add(tamBikeCliente);
						break;
					}
				}
			}else{
				for(int i: grupo3){
					if(tamBikeCliente.getSpec().getTamanho() == i){
						tamanhoBikeCliente.add(tamBikeCliente);
					}
				}
			}
		}
		return tamanhoBikeCliente;
	}
}
