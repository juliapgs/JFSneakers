-- Inserindo Produtos
insert into produto (marca, modelo, categoria, cor, tamanho, valor) values('Nike', 'Air Force 1', 'CASUAL', 'Branco', 41, 799.99);
insert into produto (marca, modelo, categoria, cor, tamanho, valor) values('Nike', 'Dunk Low SB', 'SKATE', 'Preto', 40, 899.99);
insert into produto (marca, modelo, categoria, cor, tamanho, valor) values('Nike', 'Jordan 1', 'BASQUETE', 'Vermelho', 44, 1299.99);
insert into produto (marca, modelo, categoria, cor, tamanho, valor) values('Adidas', 'Bad Bunny', 'CASUAL', 'Azul', 41, 799.99);
insert into produto (marca, modelo, categoria, cor, tamanho, valor) values('Adidas', 'Ultraboost', 'CORRIDA', 'Branco', 41, 999.99);
insert into produto (marca, modelo, categoria, cor, tamanho, valor) values('Vans', 'Old Skool', 'SKATE', 'Preto', 41, 399.99);
insert into produto (marca, modelo, categoria, cor, tamanho, valor) values('Nike', 'Zoom Fly', 'CORRIDA', 'Rosa', 37, 499.99);

-- Inserindo Pedidos
INSERT INTO pedido (id_cliente, id_produto, id_endereco, dataCompra, formaPagamento, statusPedido) VALUES (1, 2, 1, '2023-02-22', 'PIX', 'PAGO');
INSERT INTO pedido (id_cliente, id_produto, id_endereco, dataCompra, formaPagamento, statusPedido) VALUES (1, 2, 2, '2023-04-03', 'BOLETO', 'ENTREGUE');
INSERT INTO pedido (id_cliente, id_produto, id_endereco, dataCompra, formaPagamento, statusPedido) VALUES (3, 3, 1, '2023-10-06', 'PIX', 'PAGO');

-- Inserindo Clientes
insert into cliente (nome, email, senha) values('Ead', 'ead@example.com', 'qazwsx');
insert into cliente (nome, email, senha) values('Éster', 'ester@example.com', 'senha789');
insert into cliente (nome, email, senha) values('Louis', 'louis@example.com', '123456');

-- Inserindo Funcionarios
insert into funcionario (nome, email, senha) values('Gabriel', 'gabriel@example.com', 'senha123');
insert into funcionario (nome, email, senha) values('Felipe', 'felipe@example.com', 'abc123');
insert into funcionario (nome, email, senha) values('Isaque', 'isaque@example.com', 'senha456');

-- Inserindo Telefones
insert into telefone (codigoArea, numero) values ('63', '99934-5678');
insert into telefone (codigoArea, numero) values ('63', '98445-6789');
insert into telefone (codigoArea, numero) values ('63', '98456-7890');
insert into telefone (codigoArea, numero) values ('63', '99267-8901');
insert into telefone (codigoArea, numero) values ('63', '99278-9012');
insert into telefone (codigoArea, numero) values ('63', '99890-1232');

-- Atribuindo telefones aos clientes
insert into cliente_telefone (id_cliente, id_telefone) values(1, 1);
insert into cliente_telefone (id_cliente, id_telefone) values(2, 2);
insert into cliente_telefone (id_cliente, id_telefone) values(3, 3);

-- Atribuindo telefones aos funcionarios
insert into funcionario_telefone (id_funcionario, id_telefone) values(1, 4);
insert into funcionario_telefone (id_funcionario, id_telefone) values(2, 5);
insert into funcionario_telefone (id_funcionario, id_telefone) values(3, 6);

-- Inserindo enderecos
insert into endereco (cep, logradouro) values('77023382',' Capim Dourado Shopping');
insert into endereco (cep, logradouro) values('77766621',' Residencial Panamera');
insert into endereco (cep, logradouro) values('77023382',' Condominio Ferreira');