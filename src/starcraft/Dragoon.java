package starcraft;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class Dragoon extends Unit{
	JButton dragoonUnit;
	int x=500;
	int y=500;
	int life=15;
	static int attack=3;
	static int range=400;
	
	public Dragoon(){
		dragoonUnit=new JButton("드라군");
		dragoonUnit.setName("true");
		dragoonUnit.setSize(80,70);
		dragoonUnit.setLocation(500, 500);
		StartView.onePanel.add(dragoonUnit);
		StartView.onePanel.repaint();
		StartView.wide.add(StartView.onePanel);
		StartView.wide.setVisible(true);
		System.out.println(dragoonUnit.getName());
		dragoonUnit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Status dragoonfocus=new Status();
				dragoonfocus.dragoonstatus(dragoonUnit);
			}
		});
		dragoonUnit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					for(int i=0;i<StartView.riverList.size();i++) {
						if(StartView.riverList.get(i).riverUnit.getName().equals("false")) {
							Point dragoonpoint = dragoonUnit.getLocation();
							Point riverpoint=StartView.riverList.get(i).riverUnit.getLocation();
							if(Math.abs(riverpoint.x-dragoonpoint.x)>River.range||Math.abs(riverpoint.y-dragoonpoint.y)>River.range) {
								if(dragoonpoint.x>riverpoint.x) {
									StartView.riverList.get(i).x=dragoonpoint.x-River.range;
									
								}else {
									StartView.riverList.get(i).x=dragoonpoint.x+River.range;
								}
								if(dragoonpoint.y>riverpoint.y) {
									StartView.riverList.get(i).y=dragoonpoint.y-River.range;
								}else {
									StartView.riverList.get(i).y=dragoonpoint.y+River.range;
								}
							}else if(Math.abs(dragoonpoint.x-riverpoint.x)<=River.range&&Math.abs(dragoonpoint.y-riverpoint.y)<=River.range){
								life=attack(life,River.attack);
							}
							System.out.println(life);
						}
						
					}
					for(int i=0;i<StartView.zletList.size();i++) {
						if(StartView.zletList.get(i).zletUnit.getName().equals("false")) {
							Point dragoonpoint = dragoonUnit.getLocation();
							Point zletpoint=StartView.zletList.get(i).zletUnit.getLocation();
							if(Math.abs(dragoonpoint.x-zletpoint.x)>Zlet.range||Math.abs(dragoonpoint.y-zletpoint.y)>Zlet.range) {
								if(dragoonpoint.x>zletpoint.x) {
									StartView.zletList.get(i).x=dragoonpoint.x-Zlet.range;
								}else {
									StartView.zletList.get(i).x=dragoonpoint.x+Zlet.range;
								}
								if(dragoonpoint.y>zletpoint.y) {
									StartView.zletList.get(i).y=dragoonpoint.y-Zlet.range;
								}else {
									StartView.zletList.get(i).y=dragoonpoint.y+Zlet.range;
								}
							}else if(Math.abs(dragoonpoint.x-zletpoint.x)<=Zlet.range&&Math.abs(dragoonpoint.y-zletpoint.y)<=Zlet.range){
								life=attack(life,Zlet.attack);
							}
							System.out.println(life);
						}
					}
					
					if(life<=0) {
						StartView.onePanel.remove(dragoonUnit);
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
		System.out.println("��� ����");
		new Thread() {
			Point point = dragoonUnit.getLocation();
			public void run() {
				while(true){
					if(x==point.x&&y==point.y){
						dragoonUnit.setLocation(point.x,point.y);
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
						dragoonUnit.setLocation(point.x,point.y);
					}
					try{
						Thread.sleep(6);
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
