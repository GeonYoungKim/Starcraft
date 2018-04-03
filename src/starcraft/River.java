package starcraft;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class River extends Unit {
	JButton riverUnit;
	int x=600;
	int y=300;
	int life=20;
	static int attack=5;
	static int range=300;
	public River(){
		riverUnit=new JButton("리버");
		riverUnit.setName("true");
		riverUnit.setSize(70,70);
		riverUnit.setLocation(600, 300);
		StartView.onePanel.add(riverUnit);
		StartView.onePanel.repaint();
		StartView.wide.add(StartView.onePanel);
		StartView.wide.setVisible(true);
		System.out.println(riverUnit.getName());
		riverUnit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Status riverfocus=new Status();
				riverfocus.riverstatus(riverUnit);	
			}
		});
		riverUnit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					for(int i=0;i<StartView.zletList.size();i++) {
						if(StartView.zletList.get(i).zletUnit.getName().equals("false")) {
							Point riverpoint = riverUnit.getLocation();
							Point zletpoint=StartView.zletList.get(i).zletUnit.getLocation();
							if(Math.abs(zletpoint.x-riverpoint.x)>Zlet.range||Math.abs(zletpoint.y-riverpoint.y)>Zlet.range) {
								if(riverpoint.x>zletpoint.x) {
									StartView.zletList.get(i).x=riverpoint.x-Zlet.range;
									
								}else {
									StartView.zletList.get(i).x=riverpoint.x+Zlet.range;
								}
								if(riverpoint.y>zletpoint.y) {
									StartView.zletList.get(i).y=riverpoint.y-Zlet.range;
								}else {
									StartView.zletList.get(i).y=riverpoint.y+Zlet.range;
								}
							}else if(Math.abs(zletpoint.x-riverpoint.x)<=Zlet.range&&Math.abs(zletpoint.y-riverpoint.y)<=Zlet.range){
								life=attack(life,Zlet.attack);
							}
							System.out.println(life);
						}
					}for(int i=0;i<StartView.dragoonList.size();i++) {
						if(StartView.dragoonList.get(i).dragoonUnit.getName().equals("false")) {
							Point riverpoint = riverUnit.getLocation();
							Point dragoonpoint=StartView.dragoonList.get(i).dragoonUnit.getLocation();
							if(Math.abs(dragoonpoint.x-riverpoint.x)>Dragoon.range||Math.abs(dragoonpoint.y-riverpoint.y)>Dragoon.range) {
								if(riverpoint.x>dragoonpoint.x) {
									StartView.dragoonList.get(i).x=riverpoint.x-Dragoon.range;
									
								}else {
									StartView.dragoonList.get(i).x=riverpoint.x+Dragoon.range;
								}
								if(riverpoint.y>dragoonpoint.y) {
									StartView.dragoonList.get(i).y=riverpoint.y-Dragoon.range;
								}else {
									StartView.dragoonList.get(i).y=riverpoint.y+Dragoon.range;
								}
							}else if(Math.abs(dragoonpoint.x-riverpoint.x)<=Dragoon.range&&Math.abs(dragoonpoint.y-riverpoint.y)<=Dragoon.range){
								life=attack(life,Zlet.attack);
							}
							System.out.println(life);
						}
					}
					if(life<=0) {
						StartView.onePanel.remove(riverUnit);
						StartView.onePanel.repaint();
					}
				}
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		new Thread() {
			Point point = riverUnit.getLocation();
			public void run() {
				while(true){
					if(x==point.x&&y==point.y){
						riverUnit.setLocation(point.x,point.y);
					}else{
						if(x>point.x){
							point.x+=1;
						}else if(x<point.x){
							point.x-=1;
						}
						if(y>point.y){
							point.y+=1;
						}else if(y<point.y){
							point.y-=1;
						}
						riverUnit.setLocation(point.x,point.y);
					}
					try{
						Thread.sleep(15);
					}catch (InterruptedException e) {
						e.printStackTrace();								
					}
				}
								
			}
		}.start();

	}

	@Override
	int attack(int life,int attack) {
		return life-attack;
		
	}	
	
}
