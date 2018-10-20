import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame JF=new JFrame();
		JF.setTitle("Ping-Pong");
		JF.setBounds(100, 100, 750, 478);
		JF.setVisible(true);
		JF.setDefaultCloseOperation(JF.EXIT_ON_CLOSE);
		JF.setResizable(true);
		Igra I=new Igra();
		JF.add(I);

	}

}
