app.controller('alunoController', function ($scope, $http, $rootScope, $location, $routeParams, $resource) {
	
	if ($routeParams.id != null && $routeParams.id != undefined && $routeParams.id != ''){
		$scope.subtitulo = "Editando Aluno";
		
		$http.get("alunos/" + $routeParams.id).success(function(response) {
			$scope.aluno = response;
		}).error(function(data, status, headers, config) {
			erro("Error: " + status);
		});
		
	}else {
		$scope.subtitulo = "Novo Aluno";
		$scope.aluno = {};
		$scope.medicamento = {};
		$scope.telefone = {};
		$scope.endereco = {};
		
	}
	
	$scope.init = function(){
		$http.get("alunos/carregarSexo").success(function (response) {
        	$scope.sexos = response;
        }).error(function(response) {
			erro("Error: " + response);
        });
	}

	$scope.listar = function(){
		$rootScope.title = 'Aluno';
		$http.get("alunos/findAll").success(function(data){
			$scope.alunos = data;
		}).error(function(data){
			console.log("Error: " + data);
		});
	}
	$scope.criar = function () {
		$location.path('/aluno/new');
    }
	$scope.cancelar = function () {
		$scope.aluno = new Aluno();
		$scope.endereco = {};
		$scope.telefone = {};
		$scope.medicamento = {};
		$location.path('/alunos');
    } 
    $scope.salvar = function () {
    	$scope.aluno.foto = document.getElementById("imagemAluno").getAttribute("src");
	    $http.post("alunos", $scope.aluno).success(function (response) {
	    	$scope.cancelar();
	    	sucesso("Salvo com sucesso");
        }).error(function(response) {
		  erro("Error: " + response);
	    });
    }
    $scope.deletar = function (codigo) {
        $http.delete("alunos/"+codigo).then(function (response) {
        	sucesso("Excluido com sucesso");
        	$location.path('/alunos');
        }, function(response) {
			erro("Error: " + response.data);
		});
    }
    $scope.editar = function (codigo) {
    	$location.path('/aluno/edit/'+codigo);
    }
    $scope.buscar = function () {
        $http.post("alunos/buscar", $scope.aluno).success(function (response) {
        	$scope.alunos = response;
        }).error(function(response) {
			erro("Error: " + response);
        });
    }

    $scope.adicionarEnderecos = function(){
    	if($scope.aluno.enderecos){
    		$scope.aluno.enderecos.push($scope.endereco);
    	}else{
    		$scope.aluno.enderecos = [];
    		$scope.aluno.enderecos.push($scope.endereco);
    	}
    	$scope.endereco = {};
    }
    $scope.excluirEndereco = function(index){
    	$scope.aluno.enderecos.splice(index, 1);
    }
    
    $scope.adicionarMedicamentos = function(){
    	if($scope.aluno.medicamentos){
    		$scope.aluno.medicamentos.push($scope.medicamento);
    	}else{
    		$scope.aluno.medicamentos = [];
    		$scope.aluno.medicamentos.push($scope.medicamento);
    	}
    	$scope.medicamento = {};
    }
    $scope.excluirMedicamento = function(index){
    	$scope.aluno.medicamentos.splice(index, 1);
    }
    
    $scope.adicionarTelefones = function(){
    	if($scope.aluno.telefones){
    		$scope.aluno.telefones.push($scope.telefone);
    	}else{
    		$scope.aluno.telefones = [];
    		$scope.aluno.telefones.push($scope.telefone);
    	}
    	$scope.telefone = {};
    }
    $scope.excluirTelefone = function(index){
    	$scope.aluno.telefones.splice(index, 1);
    }
    
    $scope.selectImage = function() {
        CameraFactory.getPicture();
    };
});
//mostra msg de sucesso
function sucesso(msg) {
    	$.notify({
        	message: msg
        },{
            type: 'success',
            timer: 1000
        });
}

//mostra msg de erro
function erro(msg) {
	$.notify({
    	message: msg
    },{
        type: 'danger',
        timer: 1000
    });
}

function Aluno(){
	this.id;
	this.nome;
	this.sobrenome;
	this.email;
	this.sexo;
	this.rg;
	this.cpf;
	this.dataNascimento;
	this.situacao;
	this.naturalidade;
	this.nacionalidade;
	this.enderecos = {};
}

function Endereco(){
	this.id;
	this.logradouro;
	this.bairro;
	this.cidade;
	this.estado;
	this.numero;
	this.complemento;
	this.observacao;
	this.pais;
}
