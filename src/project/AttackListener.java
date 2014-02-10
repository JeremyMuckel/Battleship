package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Listener for the buttons on the board	while playing game
	public class AttackListener implements ActionListener
	{	
		int i,j;
		
		public void actionPerformed(ActionEvent v)
		{						
			Project.getPlayers(Project.getYou()).humanAttack(v);				
		}
	}	