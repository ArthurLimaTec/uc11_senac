import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class VendasVIEW extends JFrame {
    private JTable tabela;
    private DefaultTableModel modelo;

    public VendasVIEW() {
        setTitle("Produtos Vendidos");
        setSize(600, 400);
        setLocationRelativeTo(null);

        modelo = new DefaultTableModel(new Object[]{"ID", "Nome", "Valor", "Status"}, 0);
        tabela = new JTable(modelo);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        carregarDados();
    }

    private void carregarDados() {
        ProdutosDAO dao = new ProdutosDAO();
        ArrayList<ProdutosDTO> vendidos = dao.listarProdutosVendidos();
        modelo.setRowCount(0);

        for (ProdutosDTO p : vendidos) {
            modelo.addRow(new Object[]{p.getId(), p.getNome(), p.getValor(), p.getStatus()});
        }
    }
}
