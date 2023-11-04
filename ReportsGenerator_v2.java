import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelatorioProjetoTarefas {
    public static void main(String[] args) {
        // Conectar ao banco de dados (substitua com suas informações de conexão)
        String url = "jdbc:seu_banco_de_dados";
        String usuario = "seu_usuario";
        String senha = "sua_senha";

        try {
            Connection connection = DriverManager.getConnection(url, usuario, senha);

            // ID do projeto para o qual você deseja gerar o relatório (substitua com o ID correto)
            int projetoId = 1;

            // Compilar o arquivo JRXML para o formato Jasper
            JasperCompileManager.compileReportToFile("projeto_tarefas_report.jrxml");

            // Preencher o relatório com dados do banco de dados
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("projetoId", projetoId);
            List<Tarefa> tarefas = obterTarefasDoProjeto(connection, projetoId);

            JasperPrint print = JasperFillManager.fillReport("projeto_tarefas_report.jasper", parametros,
                    new JRBeanCollectionDataSource(tarefas));

            // Exportar o relatório para PDF
            JasperExportManager.exportReportToPdfFile(print, "relatorio_projeto_tarefas.pdf");

            System.out.println("Relatório gerado com sucesso.");

            // Fechar a conexão com o banco de dados
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Tarefa> obterTarefasDoProjeto(Connection connection, int projetoId) {
        // Consulta SQL para obter informações das tarefas do projeto
        // Substitua com a consulta SQL apropriada
        // Você precisará criar a classe Tarefa para armazenar os dados das tarefas
        // e implementar este método de acordo com a sua estrutura de banco de dados

        // Exemplo de consulta fictícia
        // String sql = "SELECT Nome, Descricao, Data_Inicio, Data_Fim, Prevista, Executada, Status FROM Tarefas WHERE Projeto_ID = " + projetoId;
        // Execute a consulta e retorne uma lista de objetos Tarefa

        // Por simplicidade, aqui está uma lista fictícia de tarefas
        List<Tarefa> tarefas = new ArrayList<>();
        tarefas.add(new Tarefa("Tarefa 1", "Descrição da Tarefa 1", dataInicio, dataFim, 50.0, 30.0, 60.0));
        tarefas.add(new Tarefa("Tarefa 2", "Descrição da Tarefa 2", dataInicio, dataFim, 70.0, 60.0, 85.0));
        // ... adicione mais tarefas conforme necessário

        return tarefas;
    }
}
