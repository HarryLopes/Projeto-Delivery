# Projeto-Delivery

  Este projeto foi destinado para a cadeira de Laboratório de Programação da Faculdade Nova Roma e foi desenvolvido em dupla, Matheus Lopes Barbosa & Walber Araujo.
  
  O seu objetivo é realizar pedidos, através do delivery, de uma forma simples e prática. 
  
  OBSERVAÇÃO: Este sistema não conta com interface gráfica e é utilizado no console da sua IDE.
  
  1.	Descrição Geral do Sistema:
  
      O sistema está separado em cinco entidades que são os seus pilares, Pessoa, Funcionário, Cliente, Pedido e Produto; para ter             acesso ao programa deve-se por um login e só então o funcionário poderá ter acesso as funcionalidades do programa que são,               cadastrar, pesquisar, remover, atualizar, exibir, realizar o pedido, forma de pagamento, bonificação para o funcionário e um bônus       para o cliente.
      
  2.	Descrição das Entidades do Sistema:
  
      -Pessoa: Classe que irá receber o nome e o sobrenome do cliente e implementa a serialização;
      
      -Cliente: Classe que estende pessoa, contendo seus próprios atributos e implementa a serialização. Nesta classe é concentrado                     todos os dados dos clientes;
      
      -Funcionário: Classe que estende pessoa e concentra todos os dados para o login;
      
      -Produto: Nesta classe os nomes dos produtos já estão definidos, tendo também as opções de tamanho e consequentemente os preços                   para seus respectivos tamanhos e implementa a serialização;
      
      -Pedido: Nesta classe é instanciado um ArrayList de Produtos;
      
  3.	Descrição da Arquitetura do Sistema:
  
      O sistema está dividido em 7 (sete) pacotes:
      
      br.com.novaroma.delivery.apresentacao
      Este pacote contém toda a parte de apresentação e interação com o usuário;
      
      br.com.novaroma.delivery.dados
      Este é o pacote responsável por gravar os objetos no arquivo;
      
      br.com.novaroma.delivery.entidades
      Contém todas as entidades do sistema;
      
      br.com.novaroma.delivery.excecoes
      Contém as exceções;
      
      br.com.novaroma.delivery.negocio
      Nele estão as classes controladoras que interagem com a camada de dados;
      
      br.com.novaroma.delivery.util
      Pacote que tem as validações de Cep, Cpf e telefone;
      
      br.com.novaroma.delivery.interfaces
      Pacote que tem as interfaces para a classe Utils e Dados;
 
    
    
  
