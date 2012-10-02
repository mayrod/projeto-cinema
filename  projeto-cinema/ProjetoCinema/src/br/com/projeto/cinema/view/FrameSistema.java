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
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import br.com.projeto.cinema.bean.Usuario;
import br.com.projeto.cinema.view.cadastros.CadastroAtor;
import br.com.projeto.cinema.view.cadastros.CadastroCategoriaFilme;
import br.com.projeto.cinema.view.cadastros.CadastroFilme;

import javax.swing.JSeparator;

public class FrameSistema extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private JPanel painelAux;
	
	private static JMenu mnCadastro = new JMenu("Cadastro");
	private static JMenu mnNewMenu_1 = new JMenu("Consultas");
	private static JMenu mnCaixa = new JMenu("Caixa");
	private static JMenu mnApontamento = new JMenu("Apontamento");
	
	private static FrameSistema frame;
    JDesktopPane plPrincipal;
    
    private static Usuario usuario; 
    private JMenu mnSair;
    private JMenuItem mntmLogoof;
    private JMenuItem mntmFecharSistema;
    private JMenuItem mntmFilme;
    private JMenuItem mntmFilmeLanamento;
    private JMenuItem mntmFilmePromoo;
    private JMenuItem mntmFilmeCartaz;
    private JMenuItem mntmAtor;
    private JMenuItem mntmCategoriaFilme;
    public static Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario usuario) {
		FrameSistema.usuario = usuario;
	}

	public static void main(String[] args) {

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
			public void run() {
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

	/**
	 * Create the frame.
	 */
	public FrameSistema() {
		setTitle("Controle de Cinema");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1374, 723);
		this.setLocationRelativeTo(null);
		// this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		mntmFilme = new JMenuItem("Filme");
		mnCadastro.add(mntmFilme);
		
		mntmFilmeLanamento = new JMenuItem("Filme Lan\u00E7amento");
		mnCadastro.add(mntmFilmeLanamento);
		
		mntmFilmePromoo = new JMenuItem("Filme Promo\u00E7\u00E3o");
		mnCadastro.add(mntmFilmePromoo);
		
		mntmFilmeCartaz = new JMenuItem("Filme Cartaz");
		mnCadastro.add(mntmFilmeCartaz);
		
		mntmCategoriaFilme = new JMenuItem("Categoria Filme");
		mntmCategoriaFilme.addActionListener(new AbrirCadastroAtor());
		mnCadastro.add(mntmCategoriaFilme);
		
		JSeparator separator = new JSeparator();
		mnCadastro.add(separator);
		
		JMenuItem mntmPreo = new JMenuItem("Pre\u00E7o");
		mnCadastro.add(mntmPreo);
		
		JMenuItem mntmSala = new JMenuItem("Sala");
		mnCadastro.add(mntmSala);
		
		JMenuItem mntmHorrio = new JMenuItem("Hor\u00E1rio");
		mnCadastro.add(mntmHorrio);
		
		JSeparator separator_1 = new JSeparator();
		mnCadastro.add(separator_1);
		
		mntmAtor = new JMenuItem("Ator");
		mntmAtor.addActionListener(new AbrirCadastroAtor());
		mnCadastro.add(mntmAtor);
		
		JMenuItem mntmElenco = new JMenuItem("Elenco");
		mnCadastro.add(mntmElenco);
		
		JSeparator separator_2 = new JSeparator();
		mnCadastro.add(separator_2);
		
		JMenuItem mntmUsurio = new JMenuItem("Usu\u00E1rio");
		mnCadastro.add(mntmUsurio);
		
		JMenuItem mntmPessoa = new JMenuItem("Pessoa");
		mnCadastro.add(mntmPessoa);

		mnNewMenu_1 = new JMenu("Sess\u00E3o");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmHorrioExibio = new JMenuItem("Hor\u00E1rio Exibi\u00E7\u00E3o");
		mnNewMenu_1.add(mntmHorrioExibio);

		mnCaixa = new JMenu("Consultas");
		menuBar.add(mnCaixa);
		
		JMenuItem mntmFilmes = new JMenuItem("Filmes");
		mnCaixa.add(mntmFilmes);
		
		JMenuItem mntmAvaliaes = new JMenuItem("Avalia\u00E7\u00F5es");
		mnCaixa.add(mntmAvaliaes);
		
		mnSair = new JMenu("Sair");
		menuBar.add(mnSair);
		
		mntmLogoof = new JMenuItem("Trocar usu\u00E1rio");
		mntmLogoof.setIcon(new ImageIcon(FrameSistema.class.getResource("/br/com/projeto/cinema/imagens/padraoFeminino.png")));
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
		mntmFecharSistema.setIcon(new ImageIcon(FrameSistema.class.getResource("/br/com/projeto/cinema/imagens/Close.png")));
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

	private void AbrirTela(JInternalFrame tela) {
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

		}
		else{

		}
	}
	
	private void bloquearMenu(){
		mnCadastro.setEnabled(true);
		mnNewMenu_1.setEnabled(true);
		mnCaixa.setEnabled(true);
	}
	
	private class AbrirCadastroAtor implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JInternalFrame tela = null;
			
			if(e.getSource()==mntmAtor) { tela = new CadastroAtor(); }
			else if(e.getSource()==mntmCategoriaFilme) { tela = new CadastroCategoriaFilme(); }
			
			FrameSistema.getInstancia().AbrirTela(tela);
			tela.setVisible(true);	
		}
		
	}
}
