package br.com.projeto.cinema.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import br.com.projeto.cinema.bean.Usuario;
import br.com.projeto.cinema.view.cadastros.CadastroAtor;
import br.com.projeto.cinema.view.cadastros.CadastroCategoriaFilme;
import br.com.projeto.cinema.view.cadastros.CadastroFilme;
import br.com.projeto.cinema.view.cadastros.CadastroFilmeCartaz;
import br.com.projeto.cinema.view.cadastros.CadastroFilmeLancamento;
import br.com.projeto.cinema.view.cadastros.CadastroFilmePromocao;
import br.com.projeto.cinema.view.cadastros.CadastroHorarioPreco;
import br.com.projeto.cinema.view.cadastros.CadastroSala;
import br.com.projeto.cinema.view.consultas.ConsultaFilme;
import br.com.projeto.cinema.view.lancamento.LancamentoSessao;

public class FrameSistema extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JMenu mnCadastro = new JMenu("Cadastro");
	private static JMenu mnNewMenu_1 = new JMenu("Consultas");
	private static JMenu mnCaixa = new JMenu("Caixa");
	private static FrameSistema frame;	
	private JDesktopPane plPrincipal;    
    private static Usuario usuario; 
    private static JMenu mnSair;
    private static JMenuItem mntmLogoof;
    private static JMenuItem mntmFecharSistema;
    private static JMenuItem mntmFilme;
    private static JMenuItem mntmFilmeLanamento;
    private static JMenuItem mntmFilmePromoo;
    private static JMenuItem mntmFilmeCartaz;
    private static JMenuItem mntmAtor;
    private static JMenuItem mntmCategoriaFilme;
    private static JMenuItem mntmSala; 
    private static JMenuItem mntmHorario;
    private static JMenuItem mntmHorarioExibio;
    private static JMenuItem mntmFilmes;
    
	public static void main(String[] args) 
	{

		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
				.getInstalledLookAndFeels()) {
			if ("Nimbus".equals(info.getName())) {
				try {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException ex) {
					Logger.getLogger(FrameSistema.class.getName()).log(
							Level.FINE, null, ex);
				} catch (InstantiationException ex) {
					Logger.getLogger(FrameSistema.class.getName()).log(
							Level.FINE, null, ex);
				} catch (IllegalAccessException ex) {
					Logger.getLogger(FrameSistema.class.getName()).log(
							Level.FINE, null, ex);
				} catch (UnsupportedLookAndFeelException ex) {
					Logger.getLogger(FrameSistema.class.getName()).log(
							Level.FINE, null, ex);
				}
				break;
			}
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				try {
					getInstancia();
					frame.setVisible(true);

					FrameLogin login = new FrameLogin();
					FrameSistema.getInstancia().AbrirTela(login);
					login.setVisible(true);	

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrameSistema() 
	{
		setTitle("Controle de Cinema");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1374, 723);
		this.setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		mntmFilme = new JMenuItem("Filme");
		mntmFilme.setIcon(new ImageIcon(FrameSistema.class.getResource("/br/com/projeto/cinema/imagens/video.png")));
		mntmFilme.addActionListener(new AbrirTelas());
		mnCadastro.add(mntmFilme);
		
		mntmFilmeLanamento = new JMenuItem("Filme Lan\u00E7amento");
		mntmFilmeLanamento.setIcon(new ImageIcon(FrameSistema.class.getResource("/br/com/projeto/cinema/imagens/filmeLancamento.png")));
		mntmFilmeLanamento.addActionListener(new AbrirTelas());
		mnCadastro.add(mntmFilmeLanamento);
		
		mntmFilmePromoo = new JMenuItem("Filme Promo\u00E7\u00E3o");
		mntmFilmePromoo.setIcon(new ImageIcon(FrameSistema.class.getResource("/br/com/projeto/cinema/imagens/filmePromocao.png")));
		mntmFilmePromoo.addActionListener(new AbrirTelas());
		mnCadastro.add(mntmFilmePromoo);
		
		mntmFilmeCartaz = new JMenuItem("Filme Cartaz");
		mntmFilmeCartaz.setIcon(new ImageIcon(FrameSistema.class.getResource("/br/com/projeto/cinema/imagens/filmeCartaz.png")));
		mntmFilmeCartaz.addActionListener(new AbrirTelas());
		mnCadastro.add(mntmFilmeCartaz);
		
		JSeparator separator = new JSeparator();
		mnCadastro.add(separator);
		
		mntmSala = new JMenuItem("Sala");
		mntmSala.setIcon(new ImageIcon(FrameSistema.class.getResource("/br/com/projeto/cinema/imagens/sala.png")));
		mntmSala.addActionListener(new AbrirTelas());
		
		mntmCategoriaFilme = new JMenuItem("Categoria Filme");
		mntmCategoriaFilme.setIcon(new ImageIcon(FrameSistema.class.getResource("/br/com/projeto/cinema/imagens/categoriaFilme.png")));
		mntmCategoriaFilme.addActionListener(new AbrirTelas());
		mnCadastro.add(mntmCategoriaFilme);
		mnCadastro.add(mntmSala);
		
		mntmHorario = new JMenuItem("Hor\u00E1rio");
		mntmHorario.setIcon(new ImageIcon(FrameSistema.class.getResource("/br/com/projeto/cinema/imagens/hora.png")));
		mntmHorario.addActionListener(new AbrirTelas());
		mnCadastro.add(mntmHorario);
		
		mntmAtor = new JMenuItem("Ator");
		mntmAtor.setIcon(new ImageIcon(FrameSistema.class.getResource("/br/com/projeto/cinema/imagens/ator.png")));
		mntmAtor.addActionListener(new AbrirTelas());
		mnCadastro.add(mntmAtor);

		mnNewMenu_1 = new JMenu("Sess\u00E3o");
		menuBar.add(mnNewMenu_1);
		
		mntmHorarioExibio = new JMenuItem("Hor\u00E1rio Exibi\u00E7\u00E3o");
		mntmHorarioExibio.setIcon(new ImageIcon(FrameSistema.class.getResource("/br/com/projeto/cinema/imagens/exibicao.png")));
		mntmHorarioExibio.addActionListener(new AbrirTelas());
		mnNewMenu_1.add(mntmHorarioExibio);

		mnCaixa = new JMenu("Consultas");
		menuBar.add(mnCaixa);
		
		mntmFilmes = new JMenuItem("Filmes");
		mntmFilmes.setIcon(new ImageIcon(FrameSistema.class.getResource("/br/com/projeto/cinema/imagens/video.png")));
		mntmFilmes.addActionListener(new AbrirTelas());
		mnCaixa.add(mntmFilmes);
		
		mnSair = new JMenu("Sair");
		menuBar.add(mnSair);
		
		mntmLogoof = new JMenuItem("Trocar usu\u00E1rio");
		mntmLogoof.setIcon(new ImageIcon(FrameSistema.class.getResource("/br/com/projeto/cinema/imagens/trocar.png")));
		mnSair.add(mntmLogoof);
		mntmLogoof.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				usuario = null;
				bloquearMenu();
				FrameLogin tela = new FrameLogin();
				AbrirTela(tela);
			}
		});
		
		mntmFecharSistema = new JMenuItem("Fechar sistema");
		mntmFecharSistema.setIcon(new ImageIcon(FrameSistema.class.getResource("/br/com/projeto/cinema/imagens/sairSistema.png")));
		mnSair.add(mntmFecharSistema);
		mntmFecharSistema.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				   System.exit(0); 
			}
		});

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		plPrincipal = new JDesktopPane();
		plPrincipal.setBackground(new Color(102, 255, 153));
		contentPane.add(plPrincipal, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrameSistema.class
				.getResource("/br/com/projeto/cinema/imagens/logo_cinema.png")));
		GroupLayout gl_plPrincipal = new GroupLayout(plPrincipal);
		gl_plPrincipal.setHorizontalGroup(
			gl_plPrincipal.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_plPrincipal.createSequentialGroup()
					.addContainerGap(413, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(332))
		);
		gl_plPrincipal.setVerticalGroup(
			gl_plPrincipal.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_plPrincipal.createSequentialGroup()
					.addContainerGap(135, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(113))
		);
		plPrincipal.setLayout(gl_plPrincipal);
		
		bloquearMenu();
	}

	public static FrameSistema getInstancia() {
		if (frame == null) {
			frame = new FrameSistema();
		}
		return frame;
	}

	public static JDesktopPane getPanelPrincipal() {
		return getInstancia().plPrincipal;
	}

	public void AbrirTela(JInternalFrame tela) {
		getInstancia().plPrincipal.add(tela);
		int lDesk = plPrincipal.getWidth();
		int aDesk = plPrincipal.getHeight();
		int lIFrame = tela.getWidth();
		int aIFrame = tela.getHeight();

		tela.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
		tela.setVisible(true);
	}
	
	public static void permissao(){

		if(usuario !=null && usuario.getAdministrador() == 1){
			mnCadastro.setEnabled(true);
			mnNewMenu_1.setEnabled(true);
			mnCaixa.setEnabled(true);
		    mnSair.setEnabled(true);
		    mntmLogoof.setEnabled(true);
		    mntmFecharSistema.setEnabled(true);
		    mntmFilme.setEnabled(true);
		    mntmFilmeLanamento.setEnabled(true);
		    mntmFilmePromoo.setEnabled(true);
		    mntmFilmeCartaz.setEnabled(true);
		    mntmAtor.setEnabled(true);
		    mntmCategoriaFilme.setEnabled(true);
		    mntmSala.setEnabled(true);
		    mntmHorario.setEnabled(true);
		    mntmHorarioExibio.setEnabled(true);
		    mntmFilmes.setEnabled(true);
		}
		else{
			mnCadastro.setEnabled(false);
			mnNewMenu_1.setEnabled(false);
			mnCaixa.setEnabled(true);
		    mnSair.setEnabled(true);
		    mntmLogoof.setEnabled(true);
		    mntmFecharSistema.setEnabled(true);
		    mntmFilme.setEnabled(false);
		    mntmFilmeLanamento.setEnabled(false);
		    mntmFilmePromoo.setEnabled(false);
		    mntmFilmeCartaz.setEnabled(false);
		    mntmAtor.setEnabled(false);
		    mntmCategoriaFilme.setEnabled(false);
		    mntmSala.setEnabled(false);
		    mntmHorario.setEnabled(false);
		    mntmHorarioExibio.setEnabled(false);
		    mntmFilmes.setEnabled(true);
		}
	}
	
	private void bloquearMenu(){
		mnCadastro.setEnabled(false);
		mnNewMenu_1.setEnabled(false);
		mnCaixa.setEnabled(false);
		mnSair.setEnabled(false);
	    mntmLogoof.setEnabled(false);
	    mntmFecharSistema.setEnabled(false);
	    mntmFilme.setEnabled(false);
	    mntmFilmeLanamento.setEnabled(false);
	    mntmFilmePromoo.setEnabled(false);
	    mntmFilmeCartaz.setEnabled(false);
	    mntmAtor.setEnabled(false);
	    mntmCategoriaFilme.setEnabled(false);
	    mntmSala.setEnabled(false);
	    mntmHorario.setEnabled(false);
	    mntmHorarioExibio.setEnabled(false);
	    mntmFilmes.setEnabled(false);
	}
	
	private class AbrirTelas implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JInternalFrame tela = null;
			
			if(e.getSource()==mntmAtor) 				{ tela = new CadastroAtor(); 			}
			else if(e.getSource()==mntmCategoriaFilme) 	{ tela = new CadastroCategoriaFilme(); 	}
			else if(e.getSource()==mntmFilme) 			{ tela = new CadastroFilme(); 			}			
			else if(e.getSource()==mntmFilmeLanamento) 	{ tela = new CadastroFilmeLancamento(); }			
			else if(e.getSource()==mntmFilmePromoo) 	{ tela = new CadastroFilmePromocao(); 	}			
			else if(e.getSource()==mntmFilmeCartaz) 	{ tela = new CadastroFilmeCartaz(); 	}	
			else if(e.getSource()==mntmSala) 			{ tela = new CadastroSala(); 			}			
			else if(e.getSource()==mntmHorario) 		{ tela = new CadastroHorarioPreco(); 	}		
			else if(e.getSource()==mntmHorarioExibio) 	{ tela = new LancamentoSessao(); 		}
			else if(e.getSource()==mntmLogoof) 			{ tela = new FrameLogin(); 				}
			else if(e.getSource()==mntmFilmes) 			
			{ 
				tela = new ConsultaFilme(getInstancia()); 			
			}
			
			FrameSistema.getInstancia().AbrirTela(tela);
			tela.setVisible(true);	
		}
	}
	
	public static Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario usuario) {
		FrameSistema.usuario = usuario;
	}
}
