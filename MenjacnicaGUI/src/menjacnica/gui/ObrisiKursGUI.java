package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.Toolkit;

public class ObrisiKursGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSifra;
	private JTextField textFieldProdajniKurs;
	private JTextField textFieldSrednjiKurs;
	private JTextField textFieldNaziv;
	private JTextField textFieldKupovniKurs;
	private JTextField textFieldSkraceniNaziv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ObrisiKursGUI frame = new ObrisiKursGUI();
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
	public ObrisiKursGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ObrisiKursGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setResizable(false);
		setTitle("Obrisi kurs");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSifra = new JLabel("Sifra");
		lblSifra.setBounds(10, 11, 151, 14);
		contentPane.add(lblSifra);
		
		textFieldSifra = new JTextField();
		textFieldSifra.setEditable(false);
		textFieldSifra.setBounds(10, 30, 151, 20);
		contentPane.add(textFieldSifra);
		textFieldSifra.setColumns(10);
		
		JLabel lblProdajniKurs = new JLabel("Prodajni kurs");
		lblProdajniKurs.setBounds(10, 74, 151, 14);
		contentPane.add(lblProdajniKurs);
		
		textFieldProdajniKurs = new JTextField();
		textFieldProdajniKurs.setEditable(false);
		textFieldProdajniKurs.setBounds(10, 92, 151, 20);
		contentPane.add(textFieldProdajniKurs);
		textFieldProdajniKurs.setColumns(10);
		
		JLabel lblSrednjiKurs = new JLabel("Srednji kurs");
		lblSrednjiKurs.setBounds(10, 137, 151, 14);
		contentPane.add(lblSrednjiKurs);
		
		textFieldSrednjiKurs = new JTextField();
		textFieldSrednjiKurs.setEditable(false);
		textFieldSrednjiKurs.setBounds(10, 159, 151, 20);
		contentPane.add(textFieldSrednjiKurs);
		textFieldSrednjiKurs.setColumns(10);
		
		final JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String obrisan = "Obrisan = Sifra: " + textFieldSifra.getText() + ", Skraceni naziv: " + textFieldSkraceniNaziv.getText() + 
						", Prodajni kurs: " + textFieldProdajniKurs.getText() + ", Srednji kurs: " + textFieldSrednjiKurs.getText() + 
						", Kupovni kurs: " + textFieldKupovniKurs.getText() + ", Naziv: " + textFieldNaziv.getText();
				
				MenjacnicaGUI.textAreaSTATUS.append(obrisan + "\n");
			}
		});
		btnObrisi.setEnabled(false);
		btnObrisi.setBounds(10, 231, 151, 23);
		contentPane.add(btnObrisi);
		
		JLabel lblNaziv = new JLabel("Naziv");
		lblNaziv.setBounds(225, 11, 151, 14);
		contentPane.add(lblNaziv);
		
		textFieldNaziv = new JTextField();
		textFieldNaziv.setEditable(false);
		textFieldNaziv.setBounds(225, 30, 151, 20);
		contentPane.add(textFieldNaziv);
		textFieldNaziv.setColumns(10);
		
		JLabel lblKupovniKurs = new JLabel("Kupovni kurs");
		lblKupovniKurs.setBounds(225, 74, 151, 14);
		contentPane.add(lblKupovniKurs);
		
		textFieldKupovniKurs = new JTextField();
		textFieldKupovniKurs.setEditable(false);
		textFieldKupovniKurs.setBounds(225, 92, 151, 20);
		contentPane.add(textFieldKupovniKurs);
		textFieldKupovniKurs.setColumns(10);
		
		JLabel lblSkraceniNaziv = new JLabel("Skraceni naziv");
		lblSkraceniNaziv.setBounds(225, 137, 151, 14);
		contentPane.add(lblSkraceniNaziv);
		
		textFieldSkraceniNaziv = new JTextField();
		textFieldSkraceniNaziv.setEditable(false);
		textFieldSkraceniNaziv.setBounds(225, 159, 151, 20);
		contentPane.add(textFieldSkraceniNaziv);
		textFieldSkraceniNaziv.setColumns(10);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOdustani.setBounds(225, 231, 151, 23);
		contentPane.add(btnOdustani);
		
		final JCheckBox chckbxZaistaObrisiKurs = new JCheckBox("Zaista obrisi kurs");
		chckbxZaistaObrisiKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxZaistaObrisiKurs.isSelected()) {
					btnObrisi.setEnabled(true);
				}
				else {
					btnObrisi.setEnabled(false);
				}
			}
		});
		chckbxZaistaObrisiKurs.setBounds(10, 201, 151, 23);
		contentPane.add(chckbxZaistaObrisiKurs);
	}
}
