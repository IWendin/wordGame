package game;
import javax.swing.*;
import java.awt.event.*;

public class Window {
	JFrame window;
//	Container con;
	JTextField jtf;
//	JTextArea jta;
	
	public Window() {
		//add(jtf);//, BorderLayout.SOUTH);
		window = new JFrame("Magic returns");
		window.setSize(800,500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
	//	con = window.getContentPane();
		
		jtf = new JTextField();
		jtf.setBounds(0, 400, 800, 30);
		jtf.addActionListener(action);
	//	jta = new JTextArea(30,50);
		
	//	con.add(jtf);
		window.add(jtf);
		window.setLayout(null);
		window.setVisible(true);
	}
	
	Action action = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent enterPressed) {
			System.out.println("Enter has been pressed");
		}
	};
	
	public static void main(String[] args) {
		
		/*SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new Window();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		});
	*/
		new Window();
		
	}
}
