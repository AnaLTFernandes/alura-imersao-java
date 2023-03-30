# :framed_picture: Languages API

## Índice

- [Sobre](##Sobre)
- [Desafios](#Desafios)
- [Rotas](#Rotas)
  - [Inserir linguagem](#Inserir-linguagem)
  - [Listar linguagens](#Listar-linguagens)

<br />

## Sobre

Languages API uma API de linguagens de programação.

<br />

## Desafios

Desafios propostos em aula (alguns foram adaptados ou removidos).

- [] Finalizar o CRUD (Create, Read, Update e Delete) para que se possa atualizar e excluir uma linguagem cadastrada.
- [] Devolver a listagem ordenada pelo ranking.
- [] Retornar o status 201 quando um recurso (linguagem, no nosso caso) for cadastrado através do POST.

# Rotas

URL base: `http://localhost:8080/api`

<br/>

## Inserir linguagem

- Rota: `/languages`
- Método: `POST`
- Exemplo de Body:

  ```json
  {
  	"title": "Javascript",
  	"image": "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/javascript/javascript_256x256.png",
  	"ranking": 1
  }
  ```

<br/>

## Listar linguagens

- Rota: `/languages`
- Método: `GET`
- Exemplo de Resposta:

  ```json
  [
  	{
  		"title": "Javascript",
  		"image": "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/javascript/javascript_256x256.png",
  		"ranking": 1
  	}
  ]
  ```
