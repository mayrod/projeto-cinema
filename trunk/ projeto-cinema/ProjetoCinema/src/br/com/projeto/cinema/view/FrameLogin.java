package br.com.projeto.cinema.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.com.projeto.cinema.bean.Usuario;
import br.com.projeto.cinema.dao.UsuarioDAO;


public class FrameLogin extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUsuario;
	private JButton btnEntrar;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameLogin() 
	{
		setTitle("Login");
		setBounds(100, 100, 410, 266);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Acessar Sistema",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
					.addContainerGap())
		);

		JLabel lblUsurio = new JLabel("Login:");

		JLabel lblSenha = new JLabel("Senha:");

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);

		txtSenha = new JPasswordField();
		
				btnEntrar = new JButton("Entrar");
				btnEntrar.setIcon(new ImageIcon(FrameLogin.class.getResource("/br/com/projeto/cinema/imagens/login.png")));
				btnEntrar.addActionListener(new VerificarLogin());
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSenha)
								.addComponent(lblUsurio))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtSenha)
								.addComponent(txtUsuario, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(125)
							.addComponent(btnEntrar)))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsurio)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnEntrar)
					.addContainerGap(88, Short.MAX_VALUE))
					
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		getRootPane().setDefaultButton(btnEntrar);
		
		txtUsuario.setText("admin");
		txtSenha.setText("admin");
	}

	private class VerificarLogin implements ActionListener {

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {

			if(txtUsuario.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Preencha o campo de Login!");
				txtUsuario.setFocusable(true);
			}
			else if(txtSenha.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Preencha o campo de Senha!");
				txtUsuario.setFocusable(true);
			}else{
				verificaLogin();
			}
		}
	}

	@SuppressWarnings("deprecation")
	private void verificaLogin() 
	{		 
		try
		{
			Usuario usuario = new Usuario();
			usuario.setLogin(txtUsuario.getText());
			usuario.setSenha(txtSenha.getText());
			
			if(new UsuarioDAO().verificarLogin(usuario)!=null)
			{
//				FrameSistema.permissao();
				FrameLogin.this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Login ou senha inválidos!");
				txtUsuario.setFocusable(true);
			}
			
		}catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Login ou senha inválidos!");
			txtUsuario.setFocusable(true);
		}
	}
}

	
