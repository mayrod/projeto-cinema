package br.com.projeto.cinema.view.cadastros;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;

import br.com.projeto.cinema.bean.Horario;
import br.com.projeto.cinema.dao.HorarioDAO;

public class CadastroHorarioPreco extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tblHorario;
	private JButton btSalvar;
	private JButton btRemover;
	private JButton btLimpar;
	private Horario registro;
	private JComboBox cbDiaSemana;
	private JFormattedTextField txHorario;
	private JFormattedTextField txPreco;
	
	/**
	 * Create the frame.
	 */
	public CadastroHorarioPreco() {
		setClosable(true);
		setTitle("Cadastro Hor\u00E1rio Pre\u00E7o");
		setBounds(100, 100, 746, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:         R$");
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreo.setBounds(10, 170, 101, 25);
		contentPane.add(lblPreo);
		
		JLabel lblHorrio = new JLabel("Hor\u00E1rio:");
		lblHorrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHorrio.setBounds(10, 134, 55, 25);
		contentPane.add(lblHorrio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(318, 11, 367, 278);
		contentPane.add(scrollPane);
				
		modelo.addColumn("Código");
		modelo.addColumn("Dia");
		modelo.addColumn("Horário");
		modelo.addColumn("Preço");

		tblHorario = new JTable(modelo);
		scrollPane.setViewportView(tblHorario);
		tblHorario.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblDiaDaSemana = new JLabel("Dia da Semana:");
		lblDiaDaSemana.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiaDaSemana.setBounds(10, 98, 101, 25);
		contentPane.add(lblDiaDaSemana);
		
		cbDiaSemana = new JComboBox();
		cbDiaSemana.setBounds(109, 98, 190, 25);
		contentPane.add(cbDiaSemana);
		
		MaskFormatter formatoHorario = new MaskFormatter();
		formatoHorario.setValidCharacters("0123456789");
		try { formatoHorario.setMask("##:##"); } catch (ParseException e) { }
		
		MaskFormatter formatoDinheiro = new MaskFormatter();
		try { formatoDinheiro.setMask("##.##"); } catch (ParseException e) { }
		formatoDinheiro.setValidCharacters("0123456789");
		 
		txHorario = new JFormattedTextField(formatoHorario);
		txHorario.setHorizontalAlignment(SwingConstants.CENTER);
		txHorario.setBounds(109, 134, 71, 25);
		contentPane.add(txHorario);
		
		txPreco = new JFormattedTextField(formatoDinheiro);
		txPreco.setBounds(109, 172, 71, 25);
		txPreco.setHorizontalAlignment(JFormattedTextField.RIGHT);
		contentPane.add(txPreco);
		
		btLimpar = new JButton("  Limpar");
		btLimpar.setIcon(new ImageIcon(CadastroHorarioPreco.class.getResource("/br/com/projeto/cinema/imagens/Trash.png")));
		btLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btLimpar.setBounds(10, 306, 160, 41);
		contentPane.add(btLimpar);
		btLimpar.addActionListener(new escutaBotao());
		
		btSalvar = new JButton("  Salvar");
		btSalvar.setIcon(new ImageIcon(CadastroHorarioPreco.class.getResource("/br/com/projeto/cinema/imagens/Save.png")));
		btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btSalvar.setBounds(438, 306, 160, 41);
		contentPane.add(btSalvar);
		btSalvar.addActionListener(new escutaBotao());
		
		btRemover = new JButton("  Remover");
		btRemover.setIcon(new ImageIcon(CadastroHorarioPreco.class.getResource("/br/com/projeto/cinema/imagens/Close.png")));
		btRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btRemover.setBounds(224, 306, 160, 41);
		contentPane.add(btRemover);
		btRemover.addActionListener(new escutaBotao());
		
		preencherTabela();
		carregarCombo();
	}
	
	@SuppressWarnings("unused")
	private class escutaBotao implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{		
			if(e.getSource()==btSalvar) 		{ salvar(); }	
			else if(e.getSource()==btRemover) 	{ remover();}	
			else if(e.getSource()==btLimpar)	{ limpar();	}
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public void carregarCombo()
	{
		cbDiaSemana.addItem("Domingo");
		cbDiaSemana.addItem("Segunda-Feira");
		cbDiaSemana.addItem("Terça-Feira");
		cbDiaSemana.addItem("Quarta-Feira");
		cbDiaSemana.addItem("Quinta-Feira");
		cbDiaSemana.addItem("Sexta-Feira");
		cbDiaSemana.addItem("Sábado");
	}
	
	public void preencherTabela()
	{
		List<Horario> list = new HorarioDAO().obterTodos();
		
		if(list!=null)
		{
			for(Horario obj : list)
			{
				modelo.addRow(new Object[]{obj.getPkHorario(),obj, obj.getHorario().toString().substring(11, 16),"R$ " + obj.getPreco()});
			}
		}
		
		limpar();
	}
	
	public void limpar()
	{
		registro = new Horario();
		
		txHorario.setText("");
		txPreco.setText("");
		cbDiaSemana.setSelectedItem(null);
	}
	
	public void salvar()
	{
		if(cbDiaSemana.getSelectedItem()!=null)
		{		
			try 
			{
				HorarioDAO horarioDao = new HorarioDAO();
				long countId = horarioDao.count() + 1;
				
				registro.setPkHorario(countId);
				registro.setDiaSemana(cbDiaSemana.getSelectedIndex() + 1);
				
				registro.setHorario(new Date());
				registro.getHorario().setHours(new Integer(txHorario.getText(0, 2)));
				registro.getHorario().setMinutes(new Integer(txHorario.getText().substring(3, 5)));
				
				registro.setPreco(new Double(txPreco.getText()));
			
				registro = new HorarioDAO().save(registro);
			
				if(registro!=null)
				{
					modelo.addRow(new Object[]{ registro.getPkHorario(),registro, registro.getHorario().toString().substring(11, 16),"R$ " + registro.getPreco()});
					limpar();
				}
			}
			catch (NumberFormatException e) 
			{
				e.printStackTrace();
			}
			catch (BadLocationException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Selecione um dia por favor!","Erro ao salvar.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
	
	public void remover()
	{
		if(tblHorario.getSelectedRow()!=-1)
		{
			int valor = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o item " + modelo.getValueAt(tblHorario.getSelectedRow(),0).toString() 
					+ "?", "Confirmação", JOptionPane.OK_CANCEL_OPTION);
			if(valor==0) 
			{ 
				long pkHorario = Long.parseLong(modelo.getValueAt(tblHorario.getSelectedRow(),0).toString());
				Horario horarioSelecionado = new HorarioDAO().findById(pkHorario);
				
				new HorarioDAO().delete(horarioSelecionado);
				modelo.removeRow(tblHorario.getSelectedRow()); 
				limpar();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Selecione uma linha da tabela por favor!","Erro ao excluir.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
}
