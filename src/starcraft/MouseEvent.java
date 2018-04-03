package starcraft;

import java.awt.Point;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class MouseEvent implements MouseListener{

	JButton zletUnit,dragoonUnit,riverUnit;
	
	public void mouseClicked(java.awt.event.MouseEvent e) {
		for(int i=0;i<StartView.zletList.size();i++){
			if(StartView.zletList.get(i).zletUnit.getName().equals("false")){
				StartView.zletList.get(i).x=e.getX();
				StartView.zletList.get(i).y=e.getY();
				
			}
		}
		for(int i=0;i<StartView.dragoonList.size();i++){
			if(StartView.dragoonList.get(i).dragoonUnit.getName().equals("false")){
				StartView.dragoonList.get(i).x=e.getX();
				StartView.dragoonList.get(i).y=e.getY();
				
			}
		}
		for(int i=0;i<StartView.riverList.size();i++){
			if(StartView.riverList.get(i).riverUnit.getName().equals("false")){
				StartView.riverList.get(i).x=e.getX();
				StartView.riverList.get(i).y=e.getY();
				
			}
		}
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
