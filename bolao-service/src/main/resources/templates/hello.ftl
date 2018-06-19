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
</style>

<body>
    <h2 class="hello-title">Criar simulação!</h2>
    
    <form action="/form" method="post">
	    <div class="form-group">
		    <div class="container-fluid">
		    	<div class="row">
		    		<div class="col-sm-2" style="text-align:right">
				        	Peso
				    </div>
			    	<div class="col-sm-1">
			        	<input class="form-control" style="text-align:center" name="peso" id="peso" value="1">
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
				        	<input class="form-control" style="text-align:center" name="jogador${indice}Gols1">
				    	</div>
				    	<div class="col-sm-1">
				        	<p class="search-input" style="text-align:center">x</p>
				    	</div>
				    	<div class="col-sm-1">
				        	<input class="form-control" style="text-align:center" name="jogador${indice}Gols2">
				    	</div>
				    </div>
				</#list>
			</div>
		</div>
			
		<div class="form-group">
            <div class="col-sm-offset-2 col-sm-9">
                <button id="save" type="submit" class="btn btn-default btn-primary">
                	Salvar
                </button>
            </div>
        </div>

    </form>
            
</body>
</html>