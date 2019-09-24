import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OknoDodajWyrazy extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	JButton dodajWyraz;	
	JButton pokazWyrazy;	
	JTextField tWpisanyWyraz;
	JTextArea notatnik;
	
	
	public void oknododajwyrazy() {
		
		dodajWyraz = new JButton("DODAJ WYRAZ");
		pokazWyrazy = new JButton("POKAZ WYRAZY");
		
		tWpisanyWyraz = new JTextField(10);
	
		
		add(dodajWyraz);
		dodajWyraz.addActionListener(this);
		dodajWyraz.setBounds(300, 50, 200, 50);
		
		add(pokazWyrazy);
		pokazWyrazy.addActionListener(this);
		pokazWyrazy.setBounds(300, 200, 200, 50);
		
		add(tWpisanyWyraz);
		tWpisanyWyraz.addActionListener(this);
		tWpisanyWyraz.setBounds(200, 125, 400, 50);
		
		
		
		setLayout(null);
		setTitle("PROGRAM DLA NIKOSIA - WPISZ US£YSZANY WYRAZ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		setSize(800,700);
		setVisible(true);
		
		notatnik = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(notatnik);
		add(scrollPane);
		scrollPane.setBounds(150, 300, 500, 300);	
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object zrodlo =	e.getSource();

		if (zrodlo == pokazWyrazy) {
			DanezPliku dzp = new DanezPliku();
			String wydruk = dzp.wyrazy();
			notatnik.setText(wydruk);
		}
		
		if (zrodlo == dodajWyraz) {
			try {
				FileWriter fstream = new FileWriter("A\\WYRAZY\\input.metryka",true);
			String text = tWpisanyWyraz.getText();
			fstream.write(text);
			fstream.write("\n");
			fstream.close();
			
			DanezPliku dzp = new DanezPliku();
			String wydruk = dzp.wyrazy();
			notatnik.setText(wydruk);
			
			} 
			
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}
	
	
	
	

}
