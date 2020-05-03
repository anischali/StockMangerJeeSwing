package com.gest.controller;

import java.awt.event.ActionEvent;

import com.gest.view.Home;

public class HomeController extends Home {
	private static final long serialVersionUID = 1L;
	private GestController gcontroller;
	private OrderController ocontroller;
	
	public HomeController()
	{
		super();
		gcontroller = new GestController();
		gcontroller.setVisible(false);
		ocontroller = new OrderController();
		ocontroller.setVisible(false);
		super.setVisible(true);
		super.btnSessionGestionnaire.addActionListener(this::sessionGestBtnListener);
		super.caisseBtn.addActionListener(this::sessionCaisseBtnListener);
	}
	
	/**
	 * écoute les évenements sur le button session gestionnaire
	 * @param event l'évenement écouté.
	 */
	private void sessionGestBtnListener(ActionEvent event)
	{
		gcontroller.setVisible(true);
	}
	

	/**
	 * écoute les évenements sur le button session gestionnaire
	 * @param event l'évenement écouté.
	 */
	private void sessionCaisseBtnListener(ActionEvent event)
	{
		ocontroller.setVisible(true);
	}

}
