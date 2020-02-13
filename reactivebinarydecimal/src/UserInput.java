import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class UserInput extends JPanel {
	static JTextField userInput;
	JTextField textFieldWeight;
	JTextField textFieldHeight;

	public UserInput() {

		setBackground(Color.decode("#dbebfa"));

		final JLabel labelName = new JLabel("Enter Number:");
		labelName.setForeground(Color.decode("#000000"));

		JRadioButton dec2bin = new JRadioButton("Decimal to Binary");
		JRadioButton bin2dec = new JRadioButton("Binary to Decimal");

		userInput = new JTextField();
		userInput.setPreferredSize(new Dimension(100, 20));
		userInput.setText("0");
		userInput.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				if (dec2bin.isSelected()) {
					calculate();
				}
				else
				{
					
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (dec2bin.isSelected()) {
					calculate();
				}
				userInput.setBackground(Color.decode("#FF82A9"));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		this.add(dec2bin);
		this.add(bin2dec);
		this.add(userInput);

		ButtonGroup bg = new ButtonGroup();
		bg.add(dec2bin);
		bg.add(bin2dec);

		final GridBagConstraints gbc = new GridBagConstraints();
		final GridBagLayout layout = new GridBagLayout();

		setLayout(layout);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(dec2bin, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(bin2dec, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(userInput, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;

	}

	public static void calculate() {
		System.out.println();
		userInput.setBackground(Color.decode("#25d366"));
		int input = Integer.valueOf(userInput.getText());
		convert(input);
	}

	public static void convert(int number) {
		if (number > 1) {
			convert(number / 2);
		}
		System.out.print(number % 2);
	}

}