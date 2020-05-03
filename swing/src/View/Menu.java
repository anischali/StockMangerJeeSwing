package View;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.OrderMenuController;

public class Menu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MainMenu mainMenu;

	
	
	public Menu(OrderMenuController controller) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		this.mainMenu = new MainMenu(controller);
		this.contentPane = mainMenu.getPanel();
		setContentPane(this.contentPane);
	}
	

	
}