package br.com.projeto.cinema.view.cadastros;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Testes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFilmePromocao frame = new CadastroFilmePromocao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}