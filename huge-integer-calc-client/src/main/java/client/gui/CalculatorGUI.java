package client.gui;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread.UncaughtExceptionHandler;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import feras.calculator.CalculatorFactory;

public class CalculatorGUI {

	public static void main(String[] args) {	
		inicializaTela();
	}

	private static void inicializaTela() throws HeadlessException {
		Thread.setDefaultUncaughtExceptionHandler(new GlobalHandler());
		JFrame tela = new JFrame();
		tela.setLayout(new FlowLayout());
		tela.setSize(540, 150);
		tela.setTitle("Calculator of the Beasts");
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lbl = new JLabel();
		lbl.setText("Termo 1: ");		
		final JTextField termo1 = new JTextField(40);		
			
		JLabel lbl2 = new JLabel();
		lbl2.setText("Termo 2: ");		
		final JTextField termo2 = new JTextField(40);
				
		JButton botao = new JButton();
		botao.setText("+");
		JButton botao2 = new JButton();
		botao2.setText("-");		
		JButton botao3 = new JButton();
		botao3.setText("=");
					
		final JTextField resultado = new JTextField(40);
		
		tela.add(lbl);
		tela.add(termo1);
		tela.add(lbl2);
		tela.add(termo2);
		tela.add(botao);
		tela.add(botao2);
		tela.add(botao3);		
		tela.add(resultado);		
		
		tela.setVisible(true);
		tela.setResizable(false);
		tela.setLocationRelativeTo(null);

		botao.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                resultado.setText(CalculatorFactory.newCalculator().add(termo1.getText(), termo2.getText()));
            }
        });
		
		botao2.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
            	resultado.setText(CalculatorFactory.newCalculator().subtract(termo1.getText(), termo2.getText()));
            }
        });
		
		botao3.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
            	resultado.setText(CalculatorFactory.newCalculator().compareTo(termo1.getText(), termo2.getText()).toString());
            }
        });
	}

}

class GlobalHandler implements UncaughtExceptionHandler{

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		JOptionPane.showMessageDialog(null, "\\o/¬o\n mãos para cima, isso é um assalto!!");
	}
	
}
