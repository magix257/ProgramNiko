import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Klasa extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	JButton bGenerujWyraz;
	JButton bDodajWyrazy;
	JButton bOdtworzPonownie;
	JButton bPodpowiedz;
	JTextField tWpisanyWyraz;
	JTextField tWynik;
	JTextField tIloscLiter;
	JLabel lOdpowiedz;
	JLabel lWynik;
	JLabel lIloscLiter;
	
	
	ReadFileToString rfts = new ReadFileToString();//POBIERA GENEROWANE WYRAZY Z PLIKU Z KLASY W OSOBNYM PLIKU READFILETOSTRING
	
	String[] wyrazy = rfts.readfiletostring();
	String[] wylosowany = new String[] {""};
	
	public String[] generuj() {	//generuje liczbe pseudolosowa i podaje jako index tablicy z wyrazami zawraca wyraz
		int indlast = wyrazy.length;
		Random ran = new Random();
	    //int generator = ran.nextInt(5) + 0;
		int generator = ran.nextInt(indlast) + 0;
	    wylosowany[0] = wyrazy[generator];
		
		return wylosowany;
				
	}
	
	public void metoda() {//generuje obiekty okienkowe
		
		bGenerujWyraz = new JButton("");
		bOdtworzPonownie = new JButton("ODTWORZ PONOWNIE");
		bPodpowiedz = new JButton("PODPOWIEDZ");
		bDodajWyrazy = new JButton("");
		
		tWpisanyWyraz = new JTextField(10);
		tWynik = new JTextField(10);
		tIloscLiter = new JTextField(2);
		
		lOdpowiedz = new JLabel("TU WPISZ ODPOWIEDZ: ");
		lWynik = new JLabel("TWOJ WYNIK");
		lIloscLiter = new JLabel("ILOŒÆ LITER:");
		
		add(bGenerujWyraz);
		bGenerujWyraz.addActionListener(this);
		bGenerujWyraz.setBounds(250, 50, 300, 100);
		bGenerujWyraz.setText("<html><center>"+"GENERUJ"+"<br>"+"WYRAZ"+"</center></html>");
		bGenerujWyraz.setFont(new Font("SansSerif",Font.BOLD, 30));
		
		add(bOdtworzPonownie);
		bOdtworzPonownie.addActionListener(this);
		bOdtworzPonownie.setBounds(20, 50, 200, 50);
		
		add(bDodajWyrazy);
		bDodajWyrazy.addActionListener(this);
		bDodajWyrazy.setText("<html><center>"+"DODAJ"+"<br>"+"WYRAZY"+"</center></html>");
		bDodajWyrazy.setBounds(100, 450, 150, 50);
		
		add(bPodpowiedz);
		bPodpowiedz.addActionListener(this);
		bPodpowiedz.setBounds(300, 450, 200, 50);
		
		add(tWpisanyWyraz);
		tWpisanyWyraz.setBounds(240, 200, 320, 60);
		tWpisanyWyraz.setFont(new Font("SansSerif",Font.BOLD, 50));
		tWpisanyWyraz.setHorizontalAlignment(JTextField.CENTER);
		tWpisanyWyraz.addActionListener(this);
		
		add(tWynik);
		tWynik.setBounds(100, 300, 600, 60);
		tWynik.setEditable(false);
	
		add(tIloscLiter);
		tIloscLiter.setBounds(650, 10, 50, 40);;
		tIloscLiter.setHorizontalAlignment(JTextField.CENTER);
		tIloscLiter.setEditable(false);
		tIloscLiter.setFont(new Font("SansSerif",Font.BOLD, 30));
		
		add(lOdpowiedz);
		lOdpowiedz.setBounds(100, 200, 150, 60);
		
		add(lWynik);
		lWynik.setBounds(100, 340, 600, 60);
		lWynik.setHorizontalAlignment(JLabel.CENTER);
		
		add(lIloscLiter);
		lIloscLiter.setBounds(530, -20, 150, 100);;
		lIloscLiter.setHorizontalAlignment(JLabel.CENTER);
	
		setLayout(null);
		setTitle("PROGRAM DLA NIKOSIA - WPISZ US£YSZANY WYRAZ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		setSize(800,600);
		setVisible(true);
	
	}

	public static void main(String[] args) {
	Klasa k = new Klasa();
	k.metoda();	
	}
			

	
@Override
public void actionPerformed(ActionEvent e) {
	Object zrodlo =	e.getSource();

	if (zrodlo == bGenerujWyraz) {//generuje nowy wyraz i odtwarza
				
		generuj();
		czysc();
		String wybranyWyraz = wylosowany[0];
		int dlugoscwyrazu = wybranyWyraz.length();
		
		tIloscLiter.setText(Integer.toString(dlugoscwyrazu));
		
		try {
			
			dzwiek();
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	else if (zrodlo == bDodajWyrazy) {
		OknoDodajWyrazy odw = new OknoDodajWyrazy();
		
		odw.oknododajwyrazy();
		
		
	}
	
	else if (zrodlo == bOdtworzPonownie) { //odtwarza ponownie wybrany wyraz
		tWpisanyWyraz.requestFocus();
		   try {
			 
			dzwiek();
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	else if (zrodlo == tWpisanyWyraz) {
				
		odpowiedz();
	}
	
	else if (zrodlo == bPodpowiedz) {
		//podpowiedz();
		DanezPliku dzp = new DanezPliku();
		//tWpisanyWyraz.requestFocus();
		tWpisanyWyraz.setText( Integer.toString(dzp.dlugoscpliku()));
		ReadFileToString rfts = new ReadFileToString();
		rfts.readfiletostring();
		System.out.println(dzp.wyrazy());
	}
	
	
}
	String odpok = "DOBRZE!!! BRAWO!!!";
	String odpnie = "SPRÓBUJ JESZCZE RAZ";
		
	public void odpowiedz() { //sprawdza odpowiedz i ustawia akcje 

		String porownanie = wylosowany[0];
		String pobrany = tWpisanyWyraz.getText();
		if (pobrany.equals(porownanie)) {
		tWynik.setText(odpok);
		tWynik.setBackground(Color.GREEN);
		tWynik.setFont(new Font("SansSerif",Font.BOLD, 50));
		tWynik.setHorizontalAlignment(JTextField.CENTER);
		}
		else {
			tWynik.setText(odpnie);
			tWynik.setBackground(Color.RED);
			tWynik.setFont(new Font("SansSerif",Font.BOLD, 50));
			tWynik.setHorizontalAlignment(JTextField.CENTER);
			
		}
	}
	
	public void czysc() {
		tWynik.setText("");
		tWpisanyWyraz.setText("");
		tWpisanyWyraz.requestFocus();
		tWynik.setBackground(new Color(238, 238, 238));
		
	}

	
	public void podpowiedz() {
		String wybranyWyraz = wylosowany[0];
		String wpisanyWyraz = tWpisanyWyraz.getText();
		
		String[] splitedArrayWpiWyr = null;
		splitedArrayWpiWyr = wpisanyWyraz.split("");
		
		String splitedWybWyr = new String(wybranyWyraz); 
		String[] splitedArrayWybWyr = null;
		splitedArrayWybWyr = splitedWybWyr.split("");
		int dlugoscTablicyWpisanych = splitedArrayWpiWyr.length;
		if (dlugoscTablicyWpisanych>splitedArrayWybWyr.length) 
		{
			dlugoscTablicyWpisanych = splitedArrayWybWyr.length;
			
		}
		
		for (int i = 0 ; i < dlugoscTablicyWpisanych ; i++) {
		   
			if (wpisanyWyraz.equals(""))
			{
				tWpisanyWyraz.setText(""+splitedArrayWybWyr[0]);
			}
					
							
			else if (!splitedArrayWybWyr[i].equals(splitedArrayWpiWyr[i]))
			{
				//System.out.println(i);
				
				tWpisanyWyraz.setText(wybranyWyraz.substring(0, i+1));
				break;
			   
				//String s = String.join(splitedArrayWybWyr[i], splitedArrayWpiWyr[i]);
			
			}
			else {
				int a = dlugoscTablicyWpisanych+1;
				if (a>splitedArrayWybWyr.length)
				{
					a = splitedArrayWybWyr.length;
				}
				tWpisanyWyraz.setText(wybranyWyraz.substring(0, a));
			}
			}
			
			
		}
		
	
	
	//odtwarza dzwiek po nacisnieciu guzika
		Clip clip;
			
		AudioInputStream audioInputStream; 
						
			// constructor to initialize streams and clip 
		public void dzwiek() 
			throws UnsupportedAudioFileException, 
			IOException, LineUnavailableException 
			{
			// create AudioInputStream object 
			String plik = "A\\AUDIO\\"+ wylosowany[0] + ".wav";
			audioInputStream = 
					AudioSystem.getAudioInputStream(new File(plik).getAbsoluteFile()); 
			
			// create clip reference 
			clip = AudioSystem.getClip(); 
			
			// open audioInputStream to the clip 
			clip.open(audioInputStream); 
									
			clip.start(); 
			
		}
		
	
}	