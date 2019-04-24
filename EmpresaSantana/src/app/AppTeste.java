package app;

import view.ViewPrimeiraTela;
import view.ViewSegundaTela;


public class AppTeste {
	
	public static void main(String[] args) throws Exception {
		ViewSegundaTela frame2 = new ViewSegundaTela();
		ViewPrimeiraTela frame = new ViewPrimeiraTela(frame2);
		frame2.setFrame(frame);
		frame.setVisible(true);
	}

}
