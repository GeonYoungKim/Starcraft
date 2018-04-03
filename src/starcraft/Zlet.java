package starcraft;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.SliderUI;

public class Zlet extends Unit{
	JButton zletUnit;
	int life=10;
	static int attack=2;
	int x=200;
	int y=50;
	static int range=100;
	
	public Zlet(){	
		zletUnit=new JButton("즐럿");
		zletUnit.setName("true");
		zletUnit.setSize(70,70);
		zletUnit.setLocation(200,50);
		StartView.onePanel.add(zletUnit);
		StartView.onePanel.repaint();
		StartView.wide.add(StartView.onePanel);
		StartView.wide.setVisible(true);
		System.out.println(zletUnit.getName());
		zletUnit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Status zlertfocus=new Status();
				zlertfocus.zletstatus(zletUnit);				
							
			
			}
		});
		zletUnit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					for(int i=0;i<StartView.dragoonList.size();i++) {
						if(StartView.dragoonList.get(i).dragoonUnit.getName().equals("false")) {
							Point zletpoint = zletUnit.getLocation();
							Point dragoonpoint=StartView.dragoonList.get(i).dragoonUnit.getLocation();
							if(Math.abs(zletpoint.x-dragoonpoint.x)>Dragoon.range||Math.abs(zletpoint.y-dragoonpoint.y)>Dragoon.range) {
								if(zletpoint.x>dragoonpoint.x) {
									StartView.dragoonList.get(i).x=zletpoint.x-Dragoon.range;
								}else {
									StartView.dragoonList.get(i).x=zletpoint.x+Dragoon.range;
								}
								if(zletpoint.y>dragoonpoint.y) {
									StartView.dragoonList.get(i).y=zletpoint.y-Dragoon.range;
								}else {
									StartView.dragoonList.get(i).y=zletpoint.y+Dragoon.range;
								}
							}else if(Math.abs(zletpoint.x-dragoonpoint.x)<=Dragoon.range&&Math.abs(zletpoint.y-dragoonpoint.y)<=Dragoon.range){
								life=attack(life,Dragoon.attack);
							}
							System.out.println(life);
						}
					}
					for(int i=0;i<StartView.riverList.size();i++) {
						if(StartView.riverList.get(i).riverUnit.getName().equals("false")) {
							Point zletpoint = zletUnit.getLocation();
							Point riverpoint=StartView.riverList.get(i).riverUnit.getLocation();
							if(Math.abs(zletpoint.x-riverpoint.x)>River.range||Math.abs(zletpoint.y-riverpoint.y)>River.range) {
								if(zletpoint.x>riverpoint.x) {
									StartView.riverList.get(i).x=zletpoint.x-River.range;
									
								}else {
									StartView.riverList.get(i).x=zletpoint.x+River.range;
								}
								if(zletpoint.y>riverpoint.y) {
									StartView.riverList.get(i).y=zletpoint.y-River.range;
								}else {
									StartView.riverList.get(i).y=zletpoint.y+River.range;
								}
							}else if(Math.abs(zletpoint.x-riverpoint.x)<=River.range&&Math.abs(zletpoint.y-riverpoint.y)<=River.range){
								life=attack(life,River.attack);
							}
							System.out.println(life);
						}
					}
					if(life<=0) {
						StartView.onePanel.remove(zletUnit);
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
				
			}
		});
		
		new Thread() {
			Point point = zletUnit.getLocation();
			public void run() {
				while(true){
					if(x==point.x&&y==point.y){
						zletUnit.setLocation(point.x,point.y);
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
						zletUnit.setLocation(point.x,point.y);
					}
					try{
						Thread.sleep(3);
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
