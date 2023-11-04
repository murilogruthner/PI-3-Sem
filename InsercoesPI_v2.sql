-- Inserindo 10 registros na tabela Usuario
INSERT INTO Usuario (Nome, Sobrenome, Email, Senha, Tipo_de_Usuario)
VALUES
    ('João', 'Silva', 'joao.silva@example.com', 'senha1', 'Admin'),
    ('Maria', 'Pereira', 'maria.pereira@example.com', 'senha2', 'Usuário'),
    ('José', 'Santos', 'jose.santos@example.com', 'senha3', 'Usuário'),
    ('Ana', 'Fernandes', 'ana.fernandes@example.com', 'senha4', 'Admin'),
    ('Carlos', 'Ribeiro', 'carlos.ribeiro@example.com', 'senha5', 'Usuário'),
    ('Sandra', 'Almeida', 'sandra.almeida@example.com', 'senha6', 'Usuário'),
    ('Pedro', 'Oliveira', 'pedro.oliveira@example.com', 'senha7', 'Admin'),
    ('Marta', 'Costa', 'marta.costa@example.com', 'senha8', 'Usuário'),
    ('Luís', 'Gonçalves', 'luis.goncalves@example.com', 'senha9', 'Usuário'),
    ('Sofia', 'Martins', 'sofia.martins@example.com', 'senha10', 'Admin');

-- Inserindo 10 registros na tabela Projeto
INSERT INTO Projeto (Nome, Descricao, Data_Inicio, Data_Fim, Orcamento)
VALUES
    ('Projeto A', 'Descrição do Projeto A', '2023-01-15', '2023-06-30', 50000.00),
    ('Projeto B', 'Descrição do Projeto B', '2023-02-10', '2023-08-15', 75000.00),
    ('Projeto C', 'Descrição do Projeto C', '2023-03-05', '2023-09-20', 60000.00),
    ('Projeto D', 'Descrição do Projeto D', '2023-04-20', '2023-10-10', 80000.00),
    ('Projeto E', 'Descrição do Projeto E', '2023-05-10', '2023-11-30', 70000.00),
    ('Projeto F', 'Descrição do Projeto F', '2023-06-01', '2023-12-25', 90000.00),
    ('Projeto G', 'Descrição do Projeto G', '2023-07-15', '2023-12-31', 85000.00),
    ('Projeto H', 'Descrição do Projeto H', '2023-08-10', '2024-01-15', 95000.00),
    ('Projeto I', 'Descrição do Projeto I', '2023-09-05', '2024-02-28', 70000.00),
    ('Projeto J', 'Descrição do Projeto J', '2023-10-20', '2024-03-15', 100000.00);

-- Inserindo 10 registros na tabela Tarefas
INSERT INTO Tarefas (Nome, Descricao)
VALUES
    ('Tarefa 1', 'Descrição da Tarefa 1'),
    ('Tarefa 2', 'Descrição da Tarefa 2'),
    ('Tarefa 3', 'Descrição da Tarefa 3'),
    ('Tarefa 4', 'Descrição da Tarefa 4'),
    ('Tarefa 5', 'Descrição da Tarefa 5'),
    ('Tarefa 6', 'Descrição da Tarefa 6'),
    ('Tarefa 7', 'Descrição da Tarefa 7'),
    ('Tarefa 8', 'Descrição da Tarefa 8'),
    ('Tarefa 9', 'Descrição da Tarefa 9'),
    ('Tarefa 10', 'Descrição da Tarefa 10');

-- Inserindo 10 registros na tabela Cronograma
INSERT INTO Cronograma (Nome, Descricao, Lista, Data_Inicio, Verba_Prevista, Data_Fim)
VALUES
    ('Cronograma 1', 'Descrição do Cronograma 1', 'Lista 1', '2023-01-01', 5000.00, '2023-02-28'),
    ('Cronograma 2', 'Descrição do Cronograma 2', 'Lista 2', '2023-02-15', 7000.00, '2023-03-31'),
    ('Cronograma 3', 'Descrição do Cronograma 3', 'Lista 3', '2023-03-10', 6000.00, '2023-04-30'),
    ('Cronograma 4', 'Descrição do Cronograma 4', 'Lista 4', '2023-04-20', 8000.00, '2023-05-31'),
    ('Cronograma 5', 'Descrição do Cronograma 5', 'Lista 5', '2023-05-05', 7500.00, '2023-06-30'),
    ('Cronograma 6', 'Descrição do Cronograma 6', 'Lista 6', '2023-06-15', 9000.00, '2023-07-31'),
    ('Cronograma 7', 'Descrição do Cronograma 7', 'Lista 7', '2023-07-01', 8500.00, '2023-08-31'),
    ('Cronograma 8', 'Descrição do Cronograma 8', 'Lista 8', '2023-08-20', 9500.00, '2023-09-30'),
    ('Cronograma 9', 'Descrição do Cronograma 9', 'Lista 9', '2023-09-10', 7000.00, '2023-10-31'),
    ('Cronograma 10', 'Descrição do Cronograma 10', 'Lista 10', '2023-10-01', 10000.00, '2023-11-30');
