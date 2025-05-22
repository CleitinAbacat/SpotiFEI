# Spotifei

## Descrição

O projeto **Spotifei** consiste na construção de uma plataforma de informações sobre áudios digitais, como músicas e podcasts. Inspirado na lógica de compartilhamento do Spotify, o sistema permite que usuários busquem, curtam, organizem e consultem informações sobre músicas. Importante destacar que a plataforma **não realiza a reprodução de áudios**, apenas o gerenciamento das informações.

## Tecnologias Utilizadas

* **Java Swing**: para desenvolvimento da interface gráfica (GUI).
* **JDBC PostgreSQL**: para conexão e manipulação do banco de dados.
* **Padrão MVC (Model, View, Controller)**: para organização do código e separação de responsabilidades.

## Funcionalidades do Usuário

* **Cadastro de novo usuário**.
* **Login de usuário**.
* **Busca de músicas** por nome, artista ou gênero.
* **Listagem de informações** das músicas buscadas.
* **Curtir e descurtir** músicas.
* **Gerenciamento de playlists**:

  * Criar, editar e excluir playlists.
  * Adicionar e remover músicas das playlists.
* **Visualização de histórico**:

  * Consultar as últimas 10 músicas buscadas.
  * Visualizar lista de músicas curtidas.
  * Visualizar lista de músicas descurtidas.

## Banco de Dados

* É obrigatório o uso do **PostgreSQL**.
* Todos os dados são persistidos no banco, ou seja, **nenhuma informação é perdida** ao encerrar o programa.

---
