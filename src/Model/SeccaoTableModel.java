package Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import Model.Seccao;

/**
 *
 * @author RosiclÃ©ia Frasson
 */
public class SeccaoTableModel extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_NOME = 1;
    private static final int COL_DESCRICAO = 2;
  
    List<Seccao> linhas;
    private String[] colunas = new String[]{"Id", "Nome", "Descrição"};

    public SeccaoTableModel(List<Seccao> seccao) {
        this.linhas = new ArrayList<>(seccao);
    }

    public int getRowCount() {
        return linhas.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    public Class getColumnClass(int columnIndex) {
        if (columnIndex == COL_ID) {
            return Integer.class;
        }
        return String.class;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int row, int column) {

        Seccao m = linhas.get(row);

        if (column == COL_ID) {
            return m.getId();
        } else if (column == COL_NOME) {
            return m.getNome();
        } else if (column == COL_DESCRICAO) {
            return m.getDescricao();
        } 
        return "";
    }

    public void setValueAt(Object aValue, int row, int column) {
        Seccao u = linhas.get(row);
        if (column == COL_ID) {
            u.setId((Integer) aValue);
        } else if (column == COL_NOME) {
            u.setNome(aValue.toString());
        } else if (column == COL_DESCRICAO) {
            u.setDescricao(aValue.toString());
        } 
    }

    public Seccao getSeccao(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public void addContato(Seccao seccao) {
        linhas.add(seccao);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);

    }

    public void updateContato(int indiceLinha, Seccao marca) {
        linhas.set(indiceLinha, marca);
        fireTableRowsUpdated(indiceLinha, indiceLinha);

    }

    public void removeContato(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);

    }
}
