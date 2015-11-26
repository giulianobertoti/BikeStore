//ADD UMA BIKE NOVA
$(document).ready(function() {
	$('#addBike').click(function() {	
		$('form').submit(function(e) {
			e.preventDefault();			
			var preco = $('#txtPreco').val().trim();
			var cor = $('#txtCor').val().trim();
			var numSerie = $('#txtNumSerie').val().trim();
			var tamanho = $('#txtTamanho').val().trim();
			var marca = $('#txtMarca').val().trim();
			var ano = $('#txtAno').val().trim();
			var relacao = $('#txtRelacao').val().trim();
			var suspencao = $('#txtSuspencao').val().trim();

 			$.getJSON("http://127.0.0.1:4567/lojadebike/add/"+preco+"/"+cor+"/"+numSerie+"/"+tamanho+"/"+marca+"/"+ano+"/"+relacao+"/"+suspencao+"?format=json&jsoncallback=", function(data) {
 				if(data){
 					$('.dadosAddBike').empty().append('Bike Adicionada');
 				}
 				else{
 					alert("Não rolou !");
 				}
 			});
 		});
 	});
});


//BUSCA PELO NUMERO DE SERIE
$(document).ready(function() {
	$('#buscarNumSerie').click(function() {	
		$('form').submit(function(e) {
			e.preventDefault();
			
			var numSerie = $('#txtNumSerie').val().trim();

 			$.getJSON("http://127.0.0.1:4567/lojadebike/search/serie/"+numSerie+"?format=json&jsoncallback=", function(data) {
 				$.each(data, function(i, item) {
					$('.dadosNumeroSerie').empty().append("<strong> Preço: </strong> "+item.preco+"<br>");
					$('.dadosNumeroSerie').append("<strong> Cor: </strong> "+item.cor+"<br>");
					$('.dadosNumeroSerie').append("<strong> Numero Serie: </strong> "+item.numSerie+"<br>");
					$('.dadosNumeroSerie').append("<strong> Tamanho: </strong> "+item.tamanho+"<br>");
					$('.dadosNumeroSerie').append("<strong> Marca: </strong> "+item.marca+"<br>");
					$('.dadosNumeroSerie').append("<strong> Ano: </strong> "+item.ano+"<br>");
					$('.dadosNumeroSerie').append("<strong> Relacao: </strong> "+item.relacao+"<br>");
					$('.dadosNumeroSerie').append("<strong> Suspensao: </strong> "+item.suspencao+"<br>");
				});
 			});
 		});
	});
});

//BUSCA PELA ESPEC
$(document).ready(function() {
	$('#buscaEspec').click(function() {	
		$('form').submit(function(e) {
			e.preventDefault();
			
			var tamanho = $('#txtTamanho').val().trim();
			var marca = $('#txtMarca').val().trim();
			var ano = $('#txtAno').val().trim();
			var relacao = $('#txtRelacao').val().trim();
			var suspencao = $('#txtSuspencao').val().trim();

 			$.getJSON("http://127.0.0.1:4567/lojadebike/search/espec/"+tamanho+"/"+marca+"/"+ano+"/"+relacao+"/"+suspencao+"?format=json&jsoncallback=", function(data) {
 				$.each(data, function(i, item) {
					$('.dadosEspec').empty().append("<strong> Preço: </strong> "+item.preco+"<br>");
					$('.dadosEspec').append("<strong> Cor: </strong> "+item.cor+"<br>");
					$('.dadosEspec').append("<strong> Numero Serie: </strong> "+item.numSerie+"<br>");
					$('.dadosEspec').append("<strong> Tamanho: </strong> "+item.tamanho+"<br>");
					$('.dadosEspec').append("<strong> Marca: </strong> "+item.marca+"<br>");
					$('.dadosEspec').append("<strong> Ano: </strong> "+item.ano+"<br>");
					$('.dadosEspec').append("<strong> Relacao: </strong> "+item.relacao+"<br>");
					$('.dadosEspec').append("<strong> Suspensao: </strong> "+item.suspencao+"<br>");
				});
 			});
 		});
 	});
});

//BUSCA PELO TAMANHO
$(document).ready(function() {
	$('#buscarTamanho').click(function() {	
		$('form').submit(function(e) {
			e.preventDefault();
			
			var tamanho = $('#txtTamanho').val().trim();

 			$.getJSON("http://127.0.0.1:4567/lojadebike/search/size/"+tamanho+"?format=json&jsoncallback=", function(data) {
 				$.each(data, function(i, item) {
					$('.dadosTamanho').empty().append("<strong> Preço: </strong> "+item.preco+"<br>");
					$('.dadosTamanho').append("<strong> Cor: </strong> "+item.cor+"<br>");
					$('.dadosTamanho').append("<strong> Numero Serie: </strong> "+item.numSerie+"<br>");
					$('.dadosTamanho').append("<strong> Tamanho: </strong> "+item.tamanho+"<br>");
					$('.dadosTamanho').append("<strong> Marca: </strong> "+item.marca+"<br>");
					$('.dadosTamanho').append("<strong> Ano: </strong> "+item.ano+"<br>");
					$('.dadosTamanho').append("<strong> Relacao: </strong> "+item.relacao+"<br>");
					$('.dadosTamanho').append("<strong> Suspensao: </strong> "+item.suspencao+"<br>");
				});
 			});
 		});
 	});
});

//PELO PRECO
$(document).ready(function() {
	$('#buscarPreco').click(function() {	
		$('form').submit(function(e) {
			e.preventDefault();
			
			var preco = $('#txtPreco').val().trim();

 			$.getJSON("http://127.0.0.1:4567/lojadebike/search/price/"+preco+"?format=json&jsoncallback=", function(data) {
 				$.each(data, function(i, item) {
					$('.dadosPreco').empty().append("<strong> Preço: </strong> "+item.preco+"<br>");
					$('.dadosPreco').append("<strong> Cor: </strong> "+item.cor+"<br>");
					$('.dadosPreco').append("<strong> Numero Serie: </strong> "+item.numSerie+"<br>");
					$('.dadosPreco').append("<strong> Tamanho: </strong> "+item.tamanho+"<br>");
					$('.dadosPreco').append("<strong> Marca: </strong> "+item.marca+"<br>");
					$('.dadosPreco').append("<strong> Ano: </strong> "+item.ano+"<br>");
					$('.dadosPreco').append("<strong> Relacao: </strong> "+item.relacao+"<br>");
					$('.dadosPreco').append("<strong> Suspensao: </strong> "+item.suspencao+"<br>");
				});
 			});
 		});
 	});
});

//PELA FAIXA DE PRECO ????
$(document).ready(function() {
	$('#buscarFaixaPreco').click(function() {	
		$('form').submit(function(e) {
			e.preventDefault();
			
			var precoMenor = $('#txtPrecoMenor').val().trim();
			var precoMaior = $('#txtPrecoMaior').val().trim();

 			$.getJSON("http://127.0.0.1:4567/lojadebike/search/rangeprice/"+precoMenor+"/"+precoMaior+"?format=json&jsoncallback=", function(data) {
 				$.each(data, function(i, item) {
					$('.dadosFaixaPreco').empty().append("<strong> Preço: </strong> "+item.preco+"<br>");
					$('.dadosFaixaPreco').append("<strong> Cor: </strong> "+item.cor+"<br>");
					$('.dadosFaixaPreco').append("<strong> Numero Serie: </strong> "+item.numSerie+"<br>");
					$('.dadosFaixaPreco').append("<strong> Tamanho: </strong> "+item.tamanho+"<br>");
					$('.dadosFaixaPreco').append("<strong> Marca: </strong> "+item.marca+"<br>");
					$('.dadosFaixaPreco').append("<strong> Ano: </strong> "+item.ano+"<br>");
					$('.dadosFaixaPreco').append("<strong> Relacao: </strong> "+item.relacao+"<br>");
					$('.dadosFaixaPreco').append("<strong> Suspensao: </strong> "+item.suspencao+"<br>");
				});
 			});
 		});
 	});
});

//PELA MARCA
$(document).ready(function() {
	$('#buscarMarca').click(function() {	
		$('form').submit(function(e) {
			e.preventDefault();
			
			var marca = $('#txtMarca').val().trim();

 			$.getJSON("http://127.0.0.1:4567/lojadebike/search/brand/"+marca+"?format=json&jsoncallback=", function(data) {
 				$.each(data, function(i, item) {
					$('.dadosMarca').empty().append("<strong> Preço: </strong> "+item.preco+"<br>");
					$('.dadosMarca').append("<strong> Cor: </strong> "+item.cor+"<br>");
					$('.dadosMarca').append("<strong> Numero Serie: </strong> "+item.numSerie+"<br>");
					$('.dadosMarca').append("<strong> Tamanho: </strong> "+item.tamanho+"<br>");
					$('.dadosMarca').append("<strong> Marca: </strong> "+item.marca+"<br>");
					$('.dadosMarca').append("<strong> Ano: </strong> "+item.ano+"<br>");
					$('.dadosMarca').append("<strong> Relacao: </strong> "+item.relacao+"<br>");
					$('.dadosMarca').append("<strong> Suspensao: </strong> "+item.suspencao+"<br>");
				});
 			});
 		});
 	});
});

//PELO TAMANHO DO CLIENTE ????
$(document).ready(function() {
	$('#addBike').click(function() {	
		$('form').submit(function(e) {
			e.preventDefault();
			
			var tamanhoCliente = $('#txtTamanhoCliente').val().trim();

 			$.getJSON("http://127.0.0.1:4567/lojadebike/search/sizeclient/"+tamanhoCliente+"?format=json&jsoncallback=", function(data) {
 				$.each(data, function(i, item) {
					$('.dadosNumeroSerie').empty().append("<strong> Preço: </strong> "+item.preco+"<br>");
					$('.dadosNumeroSerie').append("<strong> Cor: </strong> "+item.cor+"<br>");
					$('.dadosNumeroSerie').append("<strong> Numero Serie: </strong> "+item.numSerie+"<br>");
					$('.dadosNumeroSerie').append("<strong> Tamanho: </strong> "+item.tamanho+"<br>");
					$('.dadosNumeroSerie').append("<strong> Marca: </strong> "+item.marca+"<br>");
					$('.dadosNumeroSerie').append("<strong> Ano: </strong> "+item.ano+"<br>");
					$('.dadosNumeroSerie').append("<strong> Relacao: </strong> "+item.relacao+"<br>");
					$('.dadosNumeroSerie').append("<strong> Suspensao: </strong> "+item.suspencao+"<br>");
				});
 			});
 		});
 	});
});

//DELETA PELO NUMERO DE SERIE
$(document).ready(function() {
	$('#delete').click(function() {	
		$('form').submit(function(e) {
			e.preventDefault();
			
			var numSerie = $('#txtNumSerie').val().trim();

 			$.getJSON("http://127.0.0.1:4567/lojadebike/delete/"+numSerie+"?format=json&jsoncallback=", function(data) {
 				if(data){
 					$('.dadosDelete').empty().append('Bike Deletada');
 				}
 				else{
 					alert("Não rolou !");
 				}
 			});
 		});
	});
});

//ALTERAR BIKE
$(document).ready(function() {
	$('#alterarBike').click(function() {	
		$('form').submit(function(e) {
			e.preventDefault();

			var numSerieAntigo = $('#txtNumSerie').val().trim();
			var preco = $('#txtPreco').val().trim();
			var cor = $('#txtCor').val().trim();
			var numSerie = $('#txtNumSerie').val().trim();
			var tamanho = $('#txtTamanho').val().trim();
			var marca = $('#txtMarca').val().trim();
			var ano = $('#txtAno').val().trim();
			var relacao = $('#txtRelacao').val().trim();
			var suspencao = $('#txtSuspencao').val().trim();

 			$.getJSON("http://127.0.0.1:4567/lojadebike/update/"+numSerieAntigo+"/"+preco+"/"+cor+"/"+numSerie+"/"+tamanho+"/"+marca+"/"+ano+"/"+relacao+"/"+suspencao+"?format=json&jsoncallback=", function(data) {
 				$.each(data, function(i, item) {
					$('.dadosAlterarBike').empty().append("<strong> Preço: </strong> "+item.preco+"<br>");
					$('.dadosAlterarBike').append("<strong> Cor: </strong> "+item.cor+"<br>");
					$('.dadosAlterarBike').append("<strong> Numero Serie: </strong> "+item.numSerie+"<br>");
					$('.dadosAlterarBike').append("<strong> Tamanho: </strong> "+item.tamanho+"<br>");
					$('.dadosAlterarBike').append("<strong> Marca: </strong> "+item.marca+"<br>");
					$('.dadosAlterarBike').append("<strong> Ano: </strong> "+item.ano+"<br>");
					$('.dadosAlterarBike').append("<strong> Relacao: </strong> "+item.relacao+"<br>");
					$('.dadosAlterarBike').append("<strong> Suspensao: </strong> "+item.suspencao+"<br>");
				});
 			});
 		});
 	});
});