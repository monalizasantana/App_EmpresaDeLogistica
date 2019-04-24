package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import controle.Controle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidades.VeiculosAutonomos;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewSegundaTela extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	private ViewPrimeiraTela frame;

	private VeiculosAutonomos veiculo;
	private double latitude;
	private double longetude;
	
	private Controle controle = new Controle();

	/**
	 * Create the frame.
	 */
	public ViewSegundaTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(new Color(255, 0, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblCustoDoTransporte = new JLabel("Custo  R$");
		lblCustoDoTransporte.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCustoDoTransporte.setForeground(new Color(255, 0, 204));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.aceitarCorrida(getVeiculo(), getLongetude(), getLatitude());
				frame.novo();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(lblCustoDoTransporte, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnConfirmar)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
					.addGap(206))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(lblCustoDoTransporte, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(74)
					.addComponent(btnConfirmar)
					.addGap(60))
		);
		contentPane.setLayout(gl_contentPane);
		
	}

	public void setInfVeiculo(VeiculosAutonomos veiculo,Double custo,double longetude, double latitude) {
		setVeiculo(veiculo);
		setLongetude(longetude);
		setLatitude(latitude);
		textField.setText(veiculo.getId());
		textField_1.setText(custo.toString());
	}

	public VeiculosAutonomos getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculosAutonomos veiculo) {
		this.veiculo = veiculo;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongetude() {
		return longetude;
	}

	public void setLongetude(double longetude) {
		this.longetude = longetude;
	}

	public ViewPrimeiraTela getFrame() {
		return frame;
	}

	public void setFrame(ViewPrimeiraTela frame) {
		this.frame = frame;
	}
	
}
