# Dieta
Cadastre seus alimentos e registre suas refeições diárias.

### Como rodar

## Back-end
* Instalar o Java 21
* Instalar o Maven 3.x
* Executar, a partir de um prompt de comando/terminal, mvn spring-boot:run

## Front-end
* Instalar o NodeJS 20 LTS
* cd ui
* npm install
* npm start

### Como utilizar

* Acessar em algum navegador web o endereço http://localhost:4200
* Cadastrar um alimento por meio do comando curl a seguir, anotando seu id no JSON de retorno:

```
curl -d '{
    "nome": "Arroz",
    "tipo": "Branco",
    "marca": "Cristal",
    "estado": "Cru",
    "quantidadePorcao": 100,
    "unidade": "g",
    "carboidrato": 30,
    "proteina": 2.4,
    "gordura": 0.7
}' -H "Content-Type: application/json" -X POST http://localhost:8080/api/alimentos
```

* A tela do browser vai atualizar automaticamente com esse alimento.
* Cadastrar um novo alimento por meio do comando curl a seguir:

```
curl -d '{
    "nome": "Feijão",
    "tipo": "Carioca",
    "marca": "Kicaldo",
    "estado": "Cru",
    "quantidadePorcao": 60,
    "unidade": "g",
    "carboidrato": 15,
    "proteina": 4.8,
    "gordura": 0.5
}' -H "Content-Type: application/json" -X POST http://localhost:8080/api/alimentos
```

* Excluir o alimento cujo id foi anotado por meio do comando curl a seguir:

```
curl -X DELETE http://localhost:8080/api/alimentos/<id-anotado-do-primeiro-alimento>
```

* A tela do browser vai atualizar automaticamente para remover o alimento excluído.