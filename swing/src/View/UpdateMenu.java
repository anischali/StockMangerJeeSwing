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

import Controller.OrderMenuController;
import Model.ArticleStock;

public class UpdateMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JList<ArticleStock> list;
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
	public UpdateMenu(OrderMenuController controller) {
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
		
		JButton btnAddArticle = new JButton("Add Article");
		btnAddArticle.addActionListener(this::btnAddArticle);
		list = new JList<ArticleStock>();
		controller.displayStock(list);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblBarcode = new JLabel("Barcode");
		lblBarcode.setForeground(Color.YELLOW);
		
		JLabel label = new JLabel("Article name");
		label.setForeground(Color.YELLOW);
		
		JLabel label_1 = new JLabel("Price");
		label_1.setForeground(Color.YELLOW);
		
		JLabel label_2 = new JLabel("Quantity");
		label_2.setForeground(Color.YELLOW);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(this::btnBackListener);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnBack)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBarcode)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(textField_1, Alignment.LEADING)
									.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)))
							.addGap(249))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(list, GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
							.addContainerGap())))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(339)
					.addComponent(btnAddArticle)
					.addContainerGap(342, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblBarcode))
						.addComponent(btnBack))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAddArticle)
					.addGap(18)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(42, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	private void btnBackListener(ActionEvent event)
	{
		this.dispose();
	}
	
	private void btnAddArticle(ActionEvent event)
	{
		controller.addToStock(textField_1, textField, textField_2, textField_3);
		controller.displayStock(list);
	}
	
	public JPanel getPanel()
	{
		return contentPane;
	}
}
