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

public class FrameSistema extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private JPanel painelAux;
	
	private static JMenu mnNewMenu = new JMenu("Cadastro");
	private static JMenu mnNewMenu_1 = new JMenu("Consultas");
	private static JMenu mnCaixa = new JMenu("Caixa");
	private static JMenu mnApontamento = new JMenu("Apontamento");

	
	private static FrameSistema frame;
    JDesktopPane plPrincipal;
    
    private static Usuario usuario; 
    private JMenu mnSair;
    private JMenuItem mntmLogoof;
    private JMenuItem mntmFecharSistema;
    
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

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1374, 723);
		this.setLocationRelativeTo(null);
		// this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnNewMenu = new JMenu("Cadastro");
		menuBar.add(mnNewMenu);

		mnNewMenu_1 = new JMenu("Consultas");
		menuBar.add(mnNewMenu_1);

		mnCaixa = new JMenu("Caixa");
		menuBar.add(mnCaixa);

		mnApontamento = new JMenu("Apontamento");
		menuBar.add(mnApontamento);
		
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

		if(usuario.getAdministrador() == 1){

		}
		else{

		}
	}
	
	private void bloquearMenu(){
		mnNewMenu.setEnabled(false);
		mnNewMenu_1.setEnabled(false);
		mnCaixa.setEnabled(false);
		mnApontamento.setEnabled(false);
	}
}
