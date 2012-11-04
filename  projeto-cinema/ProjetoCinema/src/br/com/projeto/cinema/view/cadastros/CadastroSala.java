package br.com.projeto.cinema.view.cadastros;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.cinema.bean.Sala;
import br.com.projeto.cinema.dao.SalaDAO;
import br.com.projeto.cinema.utils.Constantes;

public class CadastroSala extends JInternalFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txCodigo;
	private JTextField txCapacidade;
	private JComboBox<String> cbTipo;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tblContato;
	private JButton btSalvar;
	private JButton btRemover;
	private JButton btLimpar;
	private Sala registro;	
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public CadastroSala() 
	{
		setClosable(true);
		setTitle("Cadastro Sala");
		setBounds(100, 100, 669, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(10, 119, 46, 25);
		contentPane.add(lblTipo);
		
		cbTipo = new JComboBox<String>();
		cbTipo.setBounds(66, 119, 190, 25);
		contentPane.add(cbTipo);
		
		JLabel label_2 = new JLabel("C\u00F3digo:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 83, 55, 25);
		contentPane.add(label_2);
		
		txCodigo = new JTextField();
		txCodigo.setColumns(10);
		txCodigo.setBounds(66, 85, 190, 25);
		contentPane.add(txCodigo);
		
		JLabel lblCapacidade = new JLabel("Capacidade:");
		lblCapacidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCapacidade.setBounds(10, 155, 75, 25);
		contentPane.add(lblCapacidade);
		
		txCapacidade = new JTextField();
		txCapacidade.setColumns(10);
		txCapacidade.setBounds(95, 157, 80, 25);
		contentPane.add(txCapacidade);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(266, 11, 387, 247);
		contentPane.add(scrollPane);
						
		tblContato = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Código", "Tipo", "Capacidade"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, Object.class, String.class
			};
			@SuppressWarnings("unchecked")
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblContato.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) { escutaTabela(arg0); }
		});
		scrollPane.setViewportView(tblContato);
		tblContato.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		btSalvar = new JButton("  Salvar");
		btSalvar.setIcon(new ImageIcon(CadastroSala.class.getResource("/br/com/projeto/cinema/imagens/Save.png")));
		btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btSalvar.setBounds(493, 269, 160, 41);
		btSalvar.addActionListener(new escutaBotao());
		contentPane.add(btSalvar);
		
		btLimpar = new JButton("  Limpar");
		btLimpar.setIcon(new ImageIcon(CadastroSala.class.getResource("/br/com/projeto/cinema/imagens/Trash.png")));
		btLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btLimpar.setBounds(10, 269, 160, 41);
		btLimpar.addActionListener(new escutaBotao());
		contentPane.add(btLimpar);
		
		btRemover = new JButton("  Remover");
		btRemover.setIcon(new ImageIcon(CadastroSala.class.getResource("/br/com/projeto/cinema/imagens/Close.png")));
		btRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btRemover.setBounds(248, 269, 160, 41);
		btRemover.addActionListener(new escutaBotao());
		contentPane.add(btRemover);
		
		modelo = (DefaultTableModel) tblContato.getModel();
		preencherDados();
	}
		
	public void escutaTabela(MouseEvent e) 
	{
		if(tblContato.getSelectedRow()!=-1)
		{
			registro = (Sala) modelo.getValueAt(tblContato.getSelectedRow(), 1);
			
			txCapacidade.setText(registro.getQuantidade().toString());
			txCodigo.setText(registro.getCodigo());
			
			if(registro.getTipoSala()==Constantes.TIPO_SALA_2D) { cbTipo.setSelectedItem("2D"); }
			else if(registro.getTipoSala()==Constantes.TIPO_SALA_2D_3D) { cbTipo.setSelectedItem("2D e 3D"); }
			else if(registro.getTipoSala()==Constantes.TIPO_SALA_3D) { cbTipo.setSelectedItem("3D"); }
		}
	}	
	
	private class escutaBotao implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{		
			if(e.getSource()==btSalvar) 		{ salvar(); }	
			else if(e.getSource()==btRemover) 	{ remover();}	
			else if(e.getSource()==btLimpar)	{ limpar();	}
			
		}
	}
	
	public void limpar()
	{
		registro = new Sala();
		
		txCapacidade.setText("");
		txCodigo.setText("");
		cbTipo.setSelectedItem(null);
		
		if(modelo.getRowCount()>0)
		{
			tblContato.removeRowSelectionInterval(0, modelo.getRowCount() - 1);
		}
	}
		
	public void preencherDados()
	{
		List<Sala> list = new SalaDAO().obterTodos();
		
		if(list!=null)
		{
			for(Sala obj : list)
			{
				modelo.addRow(new Object[]{obj.getCodigo(), obj, obj.getQuantidade().toString()});
			}
		}
		
		cbTipo.addItem("2D");
		cbTipo.addItem("3D");
		cbTipo.addItem("2D e 3D");
		
		limpar();
	}
	
	public void salvar()
	{
		if(txCodigo.getText().length()>0 && txCapacidade.getText().length()>0 && cbTipo.getSelectedItem()!=null)
		{		
			registro.setCodigo(txCodigo.getText());
			registro.setQuantidade(new Integer(txCapacidade.getText()));
			registro.setTipoSala(Constantes.getTipoSala((String) cbTipo.getSelectedItem()));
			
			if(registro!=null)
			{
				if(tblContato.getSelectedRow()==-1) 	{ registro = new SalaDAO().save(registro); }
				else 													
				{ 
					registro = new SalaDAO().update(registro); 
					modelo.removeRow(tblContato.getSelectedRow()); 
				}
			}
			
			modelo.addRow(new Object[]{registro.getCodigo(), registro, registro.getQuantidade().toString()});
			
			limpar();
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Digite todos os dados por favor!","Erro ao salvar.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
	
	public void remover()
	{
		if(tblContato.getSelectedRow()!=-1)
		{
			int valor = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o item " + modelo.getValueAt(tblContato.getSelectedRow(),0).toString() 
					+ "?", "Confirmação", JOptionPane.OK_CANCEL_OPTION);
			if(valor==0) 
			{ 
				new SalaDAO().delete((Sala) modelo.getValueAt(tblContato.getSelectedRow(), 1));
				modelo.removeRow(tblContato.getSelectedRow()); 
				limpar();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Selecione uma linha da tabela por favor!","Erro ao excluir.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
}