import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class RelatorioObra {
    public static void main(String[] args) {
        // Conectar ao banco de dados 
        String url = "";
        String usuario = "";
        String senha = "";

        try {
            Connection connection = DriverManager.getConnection(url, usuario, senha);

            // Compilar arquivo JRXML para o formato Jasper
            JasperCompileManager.compileReportToFile("obras_report.jrxml");

            // Preencher relatório com dados do banco de dados
            Map<String, Object> parametros = new HashMap<>();
            JasperPrint print = JasperFillManager.fillReport("obras_report.jasper", parametros, connection);

            // Exportar relatório para PDF
            JasperExportManager.exportReportToPdfFile(print, "relatorio_obras.pdf");

            System.out.println("Relatório gerado com sucesso.");

            // Fechar conexão com o banco de dados
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
