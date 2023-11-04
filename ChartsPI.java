import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CategoryMarker;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.CategoryItemRenderer;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.data.category.DefaultCategoryDataset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GraficoProjetoTarefas {
    public static void main(String[] args) {
        List<Tarefa> tarefas = obterTarefasDoProjeto(1); // Substitua com o ID do projeto desejado

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Tarefa tarefa : tarefas) {
            dataset.addValue(tarefa.getExecutada(), "Executada", tarefa.getNome());
            dataset.addValue(tarefa.getPrevista(), "Prevista", tarefa.getNome());
        }

        JFreeChart chart = ChartFactory.createBarChart(
            "Andamento das Tarefas",
            "Tarefa",
            "Valor",
            dataset,
            PlotOrientation.VERTICAL,
            true, true, false
        );

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeAxis(new NumberAxis("Valor"));
        CategoryItemRenderer renderer = new BarRenderer();
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);
        ((BarRenderer) renderer).setBarPainter(new StandardBarPainter());
        plot.setRenderer(renderer);

        CategoryAxis categoryAxis = plot.getDomainAxis();
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        javax.swing.JFrame frame = new javax.swing.JFrame("Gráfico de Andamento de Tarefas do Projeto");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private static List<Tarefa> obterTarefasDoProjeto(int projetoId) {
        List<Tarefa> tarefas = new ArrayList<>();

        // Substitua as informações de conexão com o seu banco de dados
        String url = "jdbc:seu_banco_de_dados";
        String usuario = "seu_usuario";
        String senha = "sua_senha";

        try {
            Connection connection = DriverManager.getConnection(url, usuario, senha);

            String sql = "SELECT Nome, Descricao, Data_Inicio, Data_Fim, Prevista, Executada FROM Tarefas " +
                         "WHERE Projeto_ID = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, projetoId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("Nome");
                String descricao = resultSet.getString("Descricao");
                // Obtenha outras colunas conforme necessário
                double prevista = resultSet.getDouble("Prevista");
                double executada = resultSet.getDouble("Executada");

                tarefas.add(new Tarefa(nome, descricao, prevista, executada));
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tarefas;
    }
}

class Tarefa {
    private String nome;
    private String descricao;
    private double prevista;
    private double executada;

    public Tarefa(String nome, String descricao, double prevista, double executada) {
        this.nome = nome;
        this.descricao = descricao;
        this.prevista = prevista;
        this.executada = executada;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrevista() {
        return prevista;
    }

    public double getExecutada() {
        return executada;
    }
}
