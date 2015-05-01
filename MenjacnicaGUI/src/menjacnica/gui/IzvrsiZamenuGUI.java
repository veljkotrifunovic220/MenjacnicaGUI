package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldKupovniKurs;
	private JTextField textFieldProdajniKurs;
	private JTextField textFieldIznos;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvrsiZamenuGUI frame = new IzvrsiZamenuGUI();
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
	public IzvrsiZamenuGUI() {
		setResizable(false);
		setTitle("Izvrsi zamenu");
		setIconImage(Toolkit.getDefaultToolkit().getImage(IzvrsiZamenuGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kupovni kurs");
		lblNewLabel.setBounds(10, 11, 140, 14);
		contentPane.add(lblNewLabel);
		
		textFieldKupovniKurs = new JTextField();
		textFieldKupovniKurs.setEditable(false);
		textFieldKupovniKurs.setBounds(10, 31, 140, 20);
		contentPane.add(textFieldKupovniKurs);
		textFieldKupovniKurs.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"EUR", "USD", "CHF"}));
		comboBox.setBounds(176, 31, 66, 20);
		contentPane.add(comboBox);
	
		JLabel lblNewLabel_1 = new JLabel("Prodajni kurs");
		lblNewLabel_1.setBounds(264, 11, 160, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldProdajniKurs = new JTextField();
		textFieldProdajniKurs.setEditable(false);
		textFieldProdajniKurs.setBounds(264, 31, 160, 20);
		contentPane.add(textFieldProdajniKurs);
		textFieldProdajniKurs.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Iznos");
		lblNewLabel_2.setBounds(10, 79, 140, 14);
		contentPane.add(lblNewLabel_2);
		
		textFieldIznos = new JTextField();
		textFieldIznos.setBounds(10, 101, 140, 20);
		contentPane.add(textFieldIznos);
		textFieldIznos.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Vrsta transakcije");
		lblNewLabel_3.setBounds(176, 79, 140, 14);
		contentPane.add(lblNewLabel_3);
		
		final JRadioButton rdbtnKupovina = new JRadioButton("Kupovina");
		buttonGroup.add(rdbtnKupovina);
		rdbtnKupovina.setBounds(196, 100, 109, 23);
		contentPane.add(rdbtnKupovina);
		
		final JRadioButton rdbtnProdaja = new JRadioButton("Prodaja");
		buttonGroup.add(rdbtnProdaja);
		rdbtnProdaja.setBounds(196, 126, 109, 23);
		contentPane.add(rdbtnProdaja);
		
		final JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				textFieldIznos.setText("" + slider.getValue());
			}
		});
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setBounds(10, 162, 414, 67);
		contentPane.add(slider);
		
		JButton btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
		btnIzvrsiZamenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String zamenjen = "Nepoznato";
				if (rdbtnKupovina.isSelected()) {
					zamenjen = "Zamenjen = Valuta: " + comboBox.getSelectedItem() + ", Iznos: " + textFieldIznos.getText() + ", Vrsta transakcije: Kupovina"; 
				}
				if (rdbtnProdaja.isSelected()) {
					zamenjen = "Zamenjen = Valuta: " + comboBox.getSelectedItem() + ", Iznos: " + textFieldIznos.getText() + ", Vrsta transakcije: Prodaja"; 
				}
				MenjacnicaGUI.textAreaSTATUS.append(zamenjen + "\n");
			}
		});
		btnIzvrsiZamenu.setBounds(10, 251, 169, 23);
		contentPane.add(btnIzvrsiZamenu);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOdustani.setBounds(255, 251, 169, 23);
		contentPane.add(btnOdustani);
				
	}

}
