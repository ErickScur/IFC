package aula29ant.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aula29ant.dao.LivroDAO;
import aula29ant.model.Livro;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JanelaPrincipal extends JFrame {

	private LivroDAO livroDao = new LivroDAO();
	private JPanel contentPane;
	private JTextField titulo;
	private JTextField autor;
	private JTextField editora;
	private JTextField edicao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal frame = new JanelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaPrincipal() {
		
		setTitle("Biblioteca");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 376);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Livros");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 0, 144, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTtulo.setBounds(10, 37, 45, 30);
		contentPane.add(lblTtulo);
		
		titulo = new JTextField();
		titulo.setBounds(68, 45, 96, 19);
		contentPane.add(titulo);
		titulo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Autor:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 91, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		autor = new JTextField();
		autor.setColumns(10);
		autor.setBounds(68, 90, 96, 19);
		contentPane.add(autor);
		
		editora = new JTextField();
		editora.setColumns(10);
		editora.setBounds(68, 131, 96, 19);
		contentPane.add(editora);
		
		JLabel lblNewLabel_1_1 = new JLabel("Editora:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 133, 55, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Edi\u00E7\u00E3o:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(10, 175, 55, 13);
		contentPane.add(lblNewLabel_1_1_1);
		
		edicao = new JTextField();
		edicao.setColumns(10);
		edicao.setBounds(68, 174, 96, 19);
		contentPane.add(edicao);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Livro livro = new Livro();
				livro.setTitulo(titulo.getText());
				livro.setAutor(autor.getText());
				livro.setEditora(editora.getText());
				livro.setEdicao(Integer.parseInt(edicao.getText()));
				
				livroDao.inserirLivro(livro);
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCadastrar.setBounds(10, 220, 96, 30);
		contentPane.add(btnCadastrar);
	}
}
