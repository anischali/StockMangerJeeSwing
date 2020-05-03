package View;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import Controller.OrderController;
import Controller.OrderMenuController;

public class OrderMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnAddArticle;
	private JList<OrderController> list;
	private JButton btnValidate;
	private JButton btnCancel;
	private JButton btnBack;
	private JLabel lblNewLabel_2;
	private JLabel label;
	private JLabel lblArticlesNumber;
	private OrderMenuController controller;

	/**
	 * Create the frame.
	 */
	public OrderMenu(OrderMenuController controller) {
		this.controller = controller;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		btnAddArticle = new JButton("Add Article");
		btnAddArticle.addActionListener(this::btnAddListenenr);
		list = new JList<>();
		btnValidate = new JButton("Validate");
		btnCancel = new JButton("Cancel");
		
		JLabel lblNewLabel = new JLabel("Barcode");
		lblNewLabel.setForeground(Color.yellow);
		
		btnBack = new JButton("Back");
		//controller.btnBackEvent();
		btnBack.addActionListener(this::btnBackListener);
		
		JLabel lblNewLabel_1 = new JLabel("Total Price");
		lblNewLabel_1.setForeground(Color.YELLOW);
		
		lblNewLabel_2 = new JLabel("0.0");
		lblNewLabel_2.setForeground(Color.YELLOW);
		
		lblArticlesNumber = new JLabel("Articles Number");
		lblArticlesNumber.setForeground(Color.YELLOW);
		
		label = new JLabel("0");
		label.setForeground(Color.YELLOW);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 573, Short.MAX_VALUE)
							.addComponent(btnValidate)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnBack)
							.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
							.addComponent(lblNewLabel)
							.addGap(80)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
							.addGap(256))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(339)
					.addComponent(btnAddArticle)
					.addContainerGap(342, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(list, GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblArticlesNumber)
						.addComponent(label))
					.addGap(55))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAddArticle))
						.addComponent(btnBack))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(lblNewLabel_2)
							.addGap(14)
							.addComponent(lblArticlesNumber)
							.addGap(16)
							.addComponent(label)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnValidate)
						.addComponent(btnCancel))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	

	private void btnBackListener(ActionEvent event)
	{
		super.dispose();
	}
	
	private void btnAddListenenr(ActionEvent event)
	{
		controller.btnAddEvent(list ,textField.getText(), this.label, this.lblNewLabel_2);
	}
	
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


	public JPanel getPanel()
	{
		return contentPane;
	}
}
