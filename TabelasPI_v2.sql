CREATE TABLE Usuario (
    ID_Usuario INTEGER PRIMARY KEY,
    Nome TEXT,
    Sobrenome TEXT,
    Email TEXT,
    Senha TEXT,
    Tipo_de_Usuario TEXT
);

CREATE TABLE Projeto (
    ID_Projeto INTEGER PRIMARY KEY,
    Nome TEXT,
    Descricao TEXT,
    Data_Inicio DATE,
    Data_Fim DATE,
    Orcamento DECIMAL
);

CREATE TABLE Tarefas (
    ID_Tarefa INTEGER PRIMARY KEY,
    Nome TEXT,
    Descricao TEXT
);

CREATE TABLE Cronograma (
    ID_Cronograma INTEGER PRIMARY KEY,
    Nome TEXT,
    Descricao TEXT,
    Lista TEXT,
    Data_Inicio DATE,
    Verba_Prevista DECIMAL,
    Data_Fim DATE
);

CREATE TABLE Relacionamento_Usuario_Projeto_Pertence (
    ID_Rel_Usu_Proj INTEGER PRIMARY KEY,
    fk_Usuario_ID_Usuario INTEGER,
    fk_Projeto_ID_Projeto INTEGER,
    FOREIGN KEY (fk_Usuario_ID_Usuario) REFERENCES Usuario (ID_Usuario),
    FOREIGN KEY (fk_Projeto_ID_Projeto) REFERENCES Projeto (ID_Projeto)
);

CREATE TABLE Relacionamento_Cronograma_Tarefas_Pertence (
    ID_Rel_Cron_Taref INTEGER PRIMARY KEY,
    Descricao TEXT,
    Data_Inicio DATE,
    Data_Fim DATE,
    Valor DECIMAL,
    Executada DECIMAL,
    Prevista DECIMAL,
    Status DECIMAL,
    fk_Tarefas_ID_Tarefa INTEGER,
    fk_Cronograma_ID_Cronograma INTEGER,
    FOREIGN KEY (fk_Tarefas_ID_Tarefa) REFERENCES Tarefas (ID_Tarefa),
    FOREIGN KEY (fk_Cronograma_ID_Cronograma) REFERENCES Cronograma (ID_Cronograma)
);

CREATE TABLE Relacionamento_1 (
    fk_Cronograma_ID_Cronograma INTEGER,
    fk_Projeto_ID_Projeto INTEGER,
    FOREIGN KEY (fk_Cronograma_ID_Cronograma) REFERENCES Cronograma (ID_Cronograma) ON DELETE SET NULL,
    FOREIGN KEY (fk_Projeto_ID_Projeto) REFERENCES Projeto (ID_Projeto) ON DELETE SET NULL
);
