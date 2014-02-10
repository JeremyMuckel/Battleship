package project;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Listener for the buttons on the board	while playing game
	public class InternetListener implements ActionListener
	{	
		int i,j;
		
		public void actionPerformed(ActionEvent v)
		{						
			
			System.out.println(Project.getPlayers(0).getMove());
			if
			(Project.getPlayers(0).getMove())			
			{				
				System.out.println("WooHoo");
				Object source = v.getSource();
				outer:						
				for (i=0;i<10;i++)
				{				
					for (j=0;j<10;j++)
					{					
						if (source==Project.getPlayers(1).getBboard(i,j))
						{								
							if ((Project.getPlayers(1).getBboard(i,j).getBackground()==Color.black)||
								(Project.getPlayers(1).getBboard(i,j).getBackground()==Color.orange)||
								(Project.getPlayers(1).getBboard(i,j).getBackground()==Color.blue))
							{
								JOptionPane.showMessageDialog(null,"You tri"
								+"ed that spot already.","Wasted Shot",
								JOptionPane.ERROR_MESSAGE);
								Project.getClient().fireShot();								
							}
							else
							{
								Project.getClient().fireShot(i,j);							
							}
							break outer;						
						}
						else if (source==(Project.getPlayers(0).getBboard(i
							,j)))
						{
							JOptionPane.showMessageDialog(null,"You are not suppose"
							+"d to fire on your own board!","Lost Turn",
							JOptionPane.WARNING_MESSAGE);
							Project.getClient().fireShot();		
							break outer;							
						}			
					}
				}						
				Player.isStatsOpen();
				Project.getPlayers(0).setMove(false);													
			}
			else
			{
				if (!Project.getGameOver())
				{
					JOptionPane.showMessageDialog(null,"You cannot not play yet.",
					"Wait",JOptionPane.WARNING_MESSAGE);				
				}
				else
				{
					for (i=0;i<10;i++)
					{				
						for (j=0;j<10;j++)
						{
							Project.getPlayers(0).getBboard(i
							,j).setEnabled(false);
							Project.getPlayers(0).getBboard(i,j).setEnabled(false);
						}
					}
				}
			}								
		}
	}	
