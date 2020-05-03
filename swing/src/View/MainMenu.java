package View;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.OrderMenuController;

public class MainMenu extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private OrderMenu orderMenu;
	private UpdateMenu updateMenu;
	private OrderMenuController controller;
	
	/**
	 * @return the controller
	 */
	public OrderMenuController getController() {
		return controller;
	}


	/**
	 * @param controller the controller to set
	 */
	public void setController(OrderMenuController controller) {
		this.controller = controller;
	}


	/**
	 * Create the frame.
	 */
	public MainMenu(OrderMenuController controller) {
		this.controller = controller;
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JButton btnOrderMenu = new JButton("Order Menu");
		JButton btnUpdateStock = new JButton("Update stock");
		
		btnOrderMenu.addActionListener(this::btnOrderListener);
		btnUpdateStock.addActionListener(this::btnUpdateListener);
		GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(337)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnOrderMenu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnUpdateStock, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(338, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(201)
					.addComponent(btnOrderMenu)
					.addGap(18)
					.addComponent(btnUpdateStock)
					.addContainerGap(291, Short.MAX_VALUE))
		);
		this.contentPane.setLayout(gl_contentPane);
	}
	

	private void btnOrderListener(ActionEvent event)
	{
		this.orderMenu = new OrderMenu(this.controller);
		this.setVisible(false);
		this.orderMenu.setVisible(true);
	}

	private void btnUpdateListener(ActionEvent event)
	{
		this.updateMenu = new UpdateMenu(this.controller);
		this.setVisible(false);
		this.updateMenu.setVisible(true);
	}
	
	
	public JPanel getPanel()
	{
		return contentPane;
	}
}
