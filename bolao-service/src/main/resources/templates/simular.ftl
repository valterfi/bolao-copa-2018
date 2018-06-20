<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Criar Simulação!</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>

<style>
	.search-input {
	    border-right: 0;
	}
	div.container { max-width: 500px }
</style>

<script>
	$(document).ready(function() {
	
	    $('#example').DataTable( {
	        "ajax": "${rc.getContextPath()}/classificacao/${id}",
	        "columns": [
	            { "data": "nome" },
	            { "data": "total" },
	            { "data": "acertouPlacar" },
	            { "data": "golsVencedor" },
	            { "data": "saldoGols" },
	            { "data": "golsPerdedor" },
	            { "data": "acertouVencedor" },
	            { "data": "empateGarantido" }
	        ]
	    } );
	    
	} );
</script>

<script src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.2/js/dataTables.responsive.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.18/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.2.2/css/responsive.dataTables.min.css">

<body>
    <h2 class="hello-title">SIMULAR!</h2>
    
    <form action="/form" method="post">
	    <div class="form-group">
		    <div class="container-fluid">
		    	<div class="row">
		    		<div class="col-sm-2" style="text-align:right">
				        	Peso
				    </div>
			    	<div class="col-sm-1">
			        	<input class="form-control" style="text-align:center" name="peso" id="peso" value="${(simulacao.peso)!}">
			    	</div>
		    	</div>
		    	<br/>
			    <#list simulacao.jogadores as jogador>
			    	<#assign indice=(jogador_index + 1) />
				    <div class="row">
				    	<div class="col-sm-2" style="text-align:right">
				        	${(jogador.nome)!}
				        	<input type="hidden" name="nomeJogador${indice}" value="${(jogador.nome)!}" />
				    	</div>
						<div class="col-sm-1">
				        	<input class="form-control" style="text-align:center" name="jogador${indice}Gols1" value="${(jogador.chute.gols1)!}">
				    	</div>
				    	<div class="col-sm-1">
				        	<p class="search-input" style="text-align:center">x</p>
				    	</div>
				    	<div class="col-sm-1">
				        	<input class="form-control" style="text-align:center" name="jogador${indice}Gols2" value="${(jogador.chute.gols2)!}">
				    	</div>
				    </div>
				</#list>
			</div>
		</div>
			
		<div id="example_wrapper" class="dataTables_wrapper">
		<table id="example" class="display responsive nowrap" style="width:100%">
        <thead>
            <tr>
                <th>Nome</th>
                <th>Total</th>
                <th>Acertou Placar</th>
                <th>Gols Vencedor</th>
                <th>Saldo Gols</th>
                <th>Gols Perdedor</th>
                <th>Acertou Vencedor</th>
                <th>Empate Garantido</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>Nome</th>
                <th>Total</th>
                <th>Acertou Placar</th>
                <th>Gols Vencedor</th>
                <th>Saldo Gols</th>
                <th>Gols Perdedor</th>
                <th>Acertou Vencedor</th>
                <th>Empate Garantido</th>
            </tr>
        </tfoot>
    </table>
    </div>

    </form>
            
</body>
</html>