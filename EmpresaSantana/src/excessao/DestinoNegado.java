package excessao;

import javax.swing.JOptionPane;

public class DestinoNegado extends Exception {

public DestinoNegado() {
		super();
		this.destinoNegado();
	}

	private void destinoNegado() {
		JOptionPane.showMessageDialog(null, "Destino Negado");

	}

}
