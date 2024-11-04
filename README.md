# Projeto Carrinho de Compras

Esse projeto é um sistema de carrinho de compras proposto pela Compass.UOL para conclusão do primeiro desafio da trilha de aprendizado sobre Java.
Esse desafio é ideal para sistemas de E-commerce ou plataformas de gerenciamento de pedidos. O carrinho de Compras oferece uma estrutura básica
de estoque e manipulação de itens para facilitar a criação de um fluxo de compras funcional.

---

## Visão Geral

O sistema permite que os usuários adicionem ao carrinho a partir de um estoque previamente definido,
mantendo o controle de quantidade e valor.

### Funcionalidades Principais

- Adicionar produtos ao carrinho a partir do estoque
- Atualizar quantidade de produtos no carrinho
- Remover produtos do carrinho
- Calcular o valor total dos produtos no carrinho
- Atualizar o estoque automaticamente ao adicionar ou remover itens do carrinho.

### Tecnologias Usadas

- Java 17
- JDBC para conexão com banco de dados
- MySQL para armazenamento de dados
- Intellij IDEA como IDE de desenvolvimento
- Git para clonar o repositório


---

## Configuração do Banco de Dados

- Crie o banco de dados com o nome desafio no MySQL.
- Execute o seguinte script para criar as tabelas ESTOQUE e CARRINHO e também para adicionar produtos no estoque (siga as recomendações do SQL para rodar o script):

```CREATE DATABASE desafio;

USE desafio;
CREATE TABLE Estoque (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    quantidade INT NOT NULL
);

CREATE TABLE carrinho (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    quantidade INT NOT NULL,
    valor_total DECIMAL(10, 2) NOT NULL
);
SHOW TABLES;

INSERT INTO Estoque (nome, categoria, valor, quantidade)
VALUES 
    ('Arroz', 'Alimento', 7.00, 10),
    ('Panela Tramontina', 'Utensilios', 80.00, 2),
    ('Detergente IPE', 'Limpeza', 5.00, 4),
    ('Frigideira Tramontina', 'Utensilios', 35.00, 3),
    ('Feijao', 'Alimento', 8.00, 3);

SELECT * FROM Estoque;      

```
---

## Estrutura do Código
O projeto está organizado em camadas para que seja fácil a manutenção e clareza.
Abaixo está uma explicação breve de cada camada e como elas interagem.

### DAO
Contém classes e lidam diretamente com o banco de dados.
- A classe CarrinhoDAO: lida com operações na tabela Carrinho (adicionar, listar, remover itens)
- A classe EstoqueDAO: lida com operações na tabela Estoque (buscar e atualizar produtos)

### Model
Contém classes que representam as entidades do sistema, como Produto e CarrinhoItem.
- A classe Produto: representa um item do estoque com atributos como id, nome, categoria, valor e quantidade.
- A classe CarrinhoItem: representa um item específico no carrinho de compras, com atributos de quantidade e valor total do produto.

### Service

Responsável pela lógica de negócio.

- CarrinhoService: controla as regras de adição e remoção de produtos, verificando a quantidade no estoque e atualizando o carrinho.

### Database

A classe ConexãoBD é responsável por estabelecer uma conexão com o banco de dados MySQL.
User: root
Password: Root

---

## Execute o programa na Main
- A Main é onde está toda a lógica principal do sistema criado. Esta classe coordena a execução das outras classes citadas anteriormente.

# Como me senti desenvolvendo esse projeto?

Inicialmente, me senti bastante nervosa e insegura, certa de que não conseguiria
desenvolver o projeto, pois não tinha assimilado completamente as explicações das aulas anteriores. 
No entanto, sou uma pessoa resiliente e não desisto facilmente. Decidi, então, arregaçar as mangas e buscar 
alternativas para entender melhor o que precisava ser feito. 

Comecei revisando algumas aulas essenciais do Nélio na trilha de Java e explorando vários vídeos no YouTube. 
Também pesquisei em fóruns e comunidades de programação para entender como estruturar o projeto desde o início. Aos poucos, 
fui construindo o código e desenvolvendo as funcionalidades do carrinho de compras.

No processo, enfrentei vários erros de execução, que acredito terem ocorrido pela minha falta de experiência com a linguagem. 
No entanto, consegui assimilar bem a lógica do programa, em parte graças à minha experiência com JavaScript, que me ajudou a 
desenvolver habilidades lógicas que foram fundamentais para entender este projeto.

Em diversos momentos, fiquei receosa de pedir ajuda aos instrutores, com medo de ser julgada por questões que, depois, me pareceram simples e rápidas de resolver. 
Mas, ao final, deu tudo certo: consegui superar as dificuldades e entregar o projeto com sucesso.















