package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controle.Controle;
import entidades.VeiculosAutonomos;

public class ViewPrimeiraTela extends JFrame {

	private JPanel contentPane;
	private JTextField longitudeOrigemText;
	private JTextField latitudeOrigemText;
	private JTextField latitudeDestinoText;
	private JTextField longitudeDestinoText;
	private JTextField pesoText;

	private Controle controle = new Controle();
	
	public void novo(){
		latitudeOrigemText.setText(null);
		longitudeOrigemText.setText(null);
		latitudeDestinoText.setText(null);
		longitudeDestinoText.setText(null);
		pesoText.setText(null);
	}

	/**
	 * Create the frame.
	 */
	public ViewPrimeiraTela(ViewSegundaTela frame2) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 421);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(350, 80);
		setContentPane(contentPane);
		// botao1.setSize(350,80);
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setForeground(new Color(255, 0, 255));
		btnBuscar.setBounds(148, 250, 103, 23);
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					
					double latitudeOrigem = Double.parseDouble(latitudeOrigemText.getText());
					double longitudeOrigem = Double.parseDouble(longitudeOrigemText.getText());
					double latitudeDestino = Double.parseDouble(latitudeDestinoText.getText());
					double longitudeDestino = Double.parseDouble(longitudeDestinoText.getText());
					double peso = Double.parseDouble(pesoText.getText());
					// System.out.println("Cliquei no Botão" +pes);

					VeiculosAutonomos veiculo = controle.buscarVeiculoMenorValor(peso, longitudeOrigem, latitudeOrigem,
							longitudeDestino, latitudeDestino);
					frame2.setInfVeiculo(veiculo, controle.calcularCustoCorrida(veiculo, peso, longitudeOrigem,
							latitudeOrigem, longitudeDestino, latitudeDestino), longitudeDestino, latitudeDestino);

					frame2.setVisible(true);
					setVisible(false);

				} catch (Exception e2) {
					setVisible(false);
					System.out.println(" Verificar Dados!!!");
				}

			}
		});
		contentPane.setLayout(null);
		btnBuscar.setVerticalAlignment(SwingConstants.BOTTOM);
		contentPane.add(btnBuscar);

		JLabel lblNewLabel = new JLabel("Origem");
		lblNewLabel.setForeground(new Color(255, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(25, 86, 60, 23);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Destino");
		lblNewLabel_1.setForeground(new Color(255, 0, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(25, 120, 60, 23);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Peso");
		lblNewLabel_2.setForeground(new Color(255, 0, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(25, 154, 44, 23);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("LOG\u00CDSTICA  VE\u00CDCULOS");
		lblNewLabel_3.setForeground(Color.MAGENTA);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(92, 11, 215, 31);
		contentPane.add(lblNewLabel_3);

		longitudeOrigemText = new JTextField();
		longitudeOrigemText.setBounds(148, 88, 44, 23);
		contentPane.add(longitudeOrigemText);
		longitudeOrigemText.setColumns(10);

		latitudeOrigemText = new JTextField();
		latitudeOrigemText.setColumns(10);
		latitudeOrigemText.setBounds(95, 89, 44, 23);
		contentPane.add(latitudeOrigemText);

		latitudeDestinoText = new JTextField();
		latitudeDestinoText.setColumns(10);
		latitudeDestinoText.setBounds(95, 123, 44, 23);
		contentPane.add(latitudeDestinoText);

		longitudeDestinoText = new JTextField();
		longitudeDestinoText.setColumns(10);
		longitudeDestinoText.setBounds(148, 123, 44, 23);
		contentPane.add(longitudeDestinoText);

		pesoText = new JTextField();
		pesoText.setColumns(10);
		pesoText.setBounds(95, 157, 44, 23);
		contentPane.add(pesoText);
	}
}