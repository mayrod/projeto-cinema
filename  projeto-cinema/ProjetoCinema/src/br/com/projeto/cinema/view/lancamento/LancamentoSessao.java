package br.com.projeto.cinema.view.lancamento;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.cinema.bean.Filme;
import br.com.projeto.cinema.bean.Horario;
import br.com.projeto.cinema.bean.Sala;
import br.com.projeto.cinema.bean.Sessao;
import br.com.projeto.cinema.dao.FilmeDAO;
import br.com.projeto.cinema.dao.HorarioDAO;
import br.com.projeto.cinema.dao.SalaDAO;
import br.com.projeto.cinema.dao.SessaoDAO;
import br.com.projeto.cinema.utils.Constantes;

public class LancamentoSessao extends JInternalFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<Filme> cbFilme;
	private JComboBox<String> cbHorario;
	private JComboBox<String> cbSala;
	private JButton btSalvar;
	private JButton btRemover;
	private JButton btLimpar;
	private List<Horario> horarios;
	private List<Sala> salas;
	private JComboBox<String> cbTipo;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tblSessao;
	
	public LancamentoSessao() 
	{
		setClosable(true);
		setTitle("Cadastro Filme Lan\u00E7amento");
		
		setBounds(100, 100, 815, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Filme:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 58, 46, 25);
		contentPane.add(label);
		
		cbFilme = new JComboBox<Filme>();
		cbFilme.setBounds(66, 58, 233, 25);
		contentPane.add(cbFilme);
		
		JLabel lblHorrio = new JLabel("Hor\u00E1rio:");
		lblHorrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHorrio.setBounds(10, 94, 56, 25);
		contentPane.add(lblHorrio);
				
		cbHorario = new JComboBox<String>();
		cbHorario.setBounds(66, 94, 233, 25);
		contentPane.add(cbHorario);
		
		JLabel lblSala = new JLabel("Sala:");
		lblSala.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSala.setBounds(10, 130, 56, 25);
		contentPane.add(lblSala);
		
		cbSala = new JComboBox<String>();
		cbSala.setBounds(66, 130, 233, 25);
		contentPane.add(cbSala);
		
		btRemover = new JButton("  Remover");
		btRemover.setIcon(new ImageIcon(LancamentoSessao.class.getResource("/br/com/projeto/cinema/imagens/Close.png")));
		btRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btRemover.setBounds(337, 239, 160, 41);
		contentPane.add(btRemover);
		btRemover.addActionListener(new escutaBotao());
		
		btLimpar = new JButton("  Limpar");
		btLimpar.setIcon(new ImageIcon(LancamentoSessao.class.getResource("/br/com/projeto/cinema/imagens/Trash.png")));
		btLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btLimpar.setBounds(10, 239, 160, 41);
		contentPane.add(btLimpar);
		btLimpar.addActionListener(new escutaBotao());
		
		btSalvar = new JButton("  Salvar");
		btSalvar.setIcon(new ImageIcon(LancamentoSessao.class.getResource("/br/com/projeto/cinema/imagens/Save.png")));
		btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btSalvar.setBounds(639, 239, 160, 41);
		contentPane.add(btSalvar);
		btSalvar.addActionListener(new escutaBotao());		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(308, 11, 491, 219);
		contentPane.add(scrollPane);
		
		modelo.addColumn("Código");
		modelo.addColumn("Filme");
		modelo.addColumn("Sala");
		modelo.addColumn("Horário");
		modelo.addColumn("Tipo");
		
		tblSessao = new JTable(modelo);
		scrollPane.setViewportView(tblSessao);
		tblSessao.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		cbTipo = new JComboBox<String>();
		cbTipo.setBounds(66, 166, 233, 25);
		contentPane.add(cbTipo);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(10, 166, 56, 25);
		contentPane.add(lblTipo);
		
		carregarCombos();
		preencherTabela();
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
	
	public void carregarCombos()
	{
		salas = new SalaDAO().obterTodos();
				
		if(salas!=null)
		{
			for(Sala obj : salas)
			{
				cbSala.addItem(obj.getCodigo() + " - " + obj.toString());
			}
		}
		
		List<Filme> listFilme = new FilmeDAO().obterFilmes("", "", null, null, "");
			
		if(listFilme!=null)
		{
			for(Filme obj : listFilme)
			{
				cbFilme.addItem(obj);
			}
		}
		
		horarios = new HorarioDAO().obterTodos();
		
		if(horarios!=null)
		{
			for(Horario obj : horarios)
			{
				cbHorario.addItem(obj.toString() + " - " + obj.getHorario().toString().substring(11, 16) + " - R$ " + obj.getPreco());
			}
		}
		
		cbTipo.addItem("2D");
		cbTipo.addItem("3D");
		cbTipo.addItem("2D e 3D");
		
		limpar();
	}
	
	public void preencherTabela()
	{
		List<Sessao> list = new SessaoDAO().obterTodos();
		
		if(list!=null)
		{
			for(Sessao obj : list)
			{
				modelo.addRow(new Object[]{obj.getPkSessao(),obj.getFilme().getTitulo(), obj.getSala().getCodigo(), obj.getHorario().toString() + " - " + 
						obj.getHorario().getHorario().toString().substring(11, 16) + " - R$ " + obj.getHorario().getPreco(), obj});
			}
		}
		
		limpar();
	}
	
	public void limpar()
	{		
		cbFilme.setSelectedItem(null);
		cbHorario.setSelectedItem(null);
		cbSala.setSelectedItem(null);
		cbTipo.setSelectedItem(null);
	}
	
	public void salvar()
	{
		if(cbFilme.getSelectedItem()!=null && cbHorario.getSelectedItem()!=null && cbSala.getSelectedItem()!=null && cbTipo.getSelectedItem()!=null)
		{	
			Sessao sessao = new Sessao();
			
			sessao.setFilme((Filme) cbFilme.getSelectedItem());
			sessao.setHorario(horarios.get(cbHorario.getSelectedIndex()));
			sessao.setSala(salas.get(cbSala.getSelectedIndex()));
			sessao.setTipoExibicao(Constantes.getTipoSala((String) cbTipo.getSelectedItem()));
			
			sessao = new SessaoDAO().save(sessao);
			
			if(sessao!=null) 
			{ 
				modelo.addRow(new Object[]{sessao.getPkSessao(),sessao.getFilme().getTitulo(), sessao.getSala().getCodigo(), sessao.getHorario().toString() + " - " + 
						sessao.getHorario().getHorario().toString().substring(11, 16) + " - R$ " + sessao.getHorario().getPreco(), sessao});
				limpar();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Selecione os dados por favor!","Erro ao salvar.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
	
	public void remover()
	{
		if(tblSessao.getSelectedRow()!=-1)
		{
			Sessao sessao =  (Sessao) modelo.getValueAt(tblSessao.getSelectedRow(),4);
			int valor = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o item " + sessao.getPkSessao() + "?", "Confirmação", JOptionPane.OK_CANCEL_OPTION);
			
			if(valor==0) 
			{ 
				new SessaoDAO().delete(sessao);
				modelo.removeRow(tblSessao.getSelectedRow()); 
				limpar();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Selecione uma linha da tabela por favor!","Erro ao excluir.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
}
