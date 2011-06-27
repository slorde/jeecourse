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

import feras.calculator.Calculator;
import feras.calculator.CalculatorFactory;
import feras.proxy.CalculatorServerProxy;

public class CalculatorGUI {

	private Calculator calculator = null;
	
	public CalculatorGUI() {
		calculator = CalculatorFactory.newCalculator();
		calculator = new CalculatorServerProxy();
		inicializaTela();
	}
	
	public static void main(String[] args) {		
		new CalculatorGUI();
	}

	private void inicializaTela() throws HeadlessException {
		Thread.setDefaultUncaughtExceptionHandler(new GlobalHandler());
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setSize(540, 150);
		frame.setTitle("Calculator of the Beasts");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lbl = new JLabel();
		lbl.setText("Termo 1: ");		
		final JTextField term1 = new JTextField(40);		
			
		JLabel lbl2 = new JLabel();
		lbl2.setText("Termo 2: ");		
		final JTextField term2 = new JTextField(40);
				
		JButton botao = new JButton();
		botao.setText("+");
		JButton botao2 = new JButton();
		botao2.setText("-");		
		JButton botao3 = new JButton();
		botao3.setText("=");
					
		final JTextField resultado = new JTextField(40);
		
		frame.add(lbl);
		frame.add(term1);
		frame.add(lbl2);
		frame.add(term2);
		frame.add(botao);
		frame.add(botao2);
		frame.add(botao3);		
		frame.add(resultado);		
		
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		botao.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                resultado.setText(calculator.add(term1.getText(), term2.getText()));
            }
        });
		
		botao2.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
            	resultado.setText(calculator.subtract(term1.getText(), term2.getText()));
            }
        });
		
		botao3.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
            	resultado.setText(calculator.compareTo(term1.getText(), term2.getText()).toString());
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
