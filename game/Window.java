package game;
import javax.swing.*;
import java.awt.event.*;

public class Window {
	JFrame window;
	JTextField jtf;
	JTextArea jta;
	JPanel jp;
	JScrollPane scroll;
	private final static String nl = "\n";
	
	public Window() {
		//add(jtf);//, BorderLayout.SOUTH);
		window = new JFrame("Magic returns");
		window.setSize(800,500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	//	con = window.getContentPane();
		
		jtf = new JTextField();
		jtf.setBounds(0, 400, 800, 30);
		jtf.addActionListener(action);
		jta = new JTextArea(30,50);
		jta.setEditable(false);
		jta.setBounds(0,10,780,350);
		scroll = new JScrollPane(jta);
		scroll.setBounds(0, 10, 780, 350);
		
		jp = new JPanel();
		//jp.add(jtf); // seems like jtf does not work with the JPane
		jp.add(scroll);
		
		window.add(jtf);	//move to JFrame instead of JPane
	//	window.add(jta);
		window.add(scroll);
		window.setLayout(null);
		window.setVisible(true);
	}
	
	Action action = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent enterPressed) {
			String text = jtf.getText();
			jtf.setText("");
			jta.append(text + nl);
			
		}
	};

	public void print(String text) {
		jta.append(text + nl);
	}
	
/*	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new Window();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		});
	
		new Window();
		
	}*/
}
