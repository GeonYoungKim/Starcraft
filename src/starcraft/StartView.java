package starcraft;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartView {
	static JFrame wide;
	static JPanel onePanel;
	static ArrayList<Zlet> zletList=new ArrayList<Zlet>();
	static ArrayList<River> riverList=new ArrayList<River>();
	static ArrayList<Dragoon> dragoonList=new ArrayList<Dragoon>();
	public StartView(){
		wide=new JFrame("스타크래프트");
		wide.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wide.setSize(1500, 1000);
		
		URL zletURL = getClass().getResource("/image/zlet.jpg");
		ImageIcon zletim=new ImageIcon(zletURL);
		URL dragoonURL = getClass().getResource("/image/dragoon.png");
		ImageIcon dragoonim=new ImageIcon(dragoonURL);
		URL riverURL = getClass().getResource("/image/river.jpg");
		ImageIcon riverim=new ImageIcon(riverURL);
		
		onePanel=new JPanel();
		onePanel.setLayout(null);
		JButton zlet=new JButton(zletim);
		zlet.setSize(200, 330);
		zlet.setLocation(0, 0);
		JButton river=new JButton(riverim);
		river.setSize(200, 330);
		river.setLocation(0, 330);
		JButton dragoon=new JButton(dragoonim);
		dragoon.setSize(200, 330);
		dragoon.setLocation(0, 660);
		zlet.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				Zlet zletcreate=new Zlet();
				zletList.add(zletcreate);
			}
		});
		river.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				River rivercreate=new River();	
				riverList.add(rivercreate);
			}
		});
		dragoon.addActionListener(new ActionListener() {						
			public void actionPerformed(ActionEvent e) {
				Dragoon dragooncreate=new Dragoon();
				dragoonList.add(dragooncreate);
			}
		});	
		
		onePanel.addMouseListener(new starcraft.MouseEvent());
		onePanel.add(zlet);
		onePanel.add(river);
		onePanel.add(dragoon);
			
		wide.add(onePanel);
		wide.setVisible(true);
		
	}
}
