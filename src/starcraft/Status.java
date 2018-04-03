package starcraft;

import javax.swing.JButton;

public class Status {
	public void zletstatus(JButton zletUnit){
		if(zletUnit.getName().equals("true")){
			zletUnit.setName("false");
			System.out.println(zletUnit.getName());
		}else{
			zletUnit.setName("true");
			System.out.println(zletUnit.getName());
		}	
		for(int i=0;i<StartView.zletList.size();i++){
			if(StartView.zletList.get(i).zletUnit.equals(zletUnit)){
				continue;
			}
			if(StartView.zletList.get(i).zletUnit.getName().equals("false")){
				StartView.zletList.get(i).zletUnit.setName("true");
			}
		}	
		for(int i=0;i<StartView.riverList.size();i++){
			StartView.riverList.get(i).riverUnit.setName("true");
		}
		for(int i=0;i<StartView.dragoonList.size();i++){
			StartView.dragoonList.get(i).dragoonUnit.setName("true");
		}
	}
	public void riverstatus(JButton riverUnit){
		if(riverUnit.getName().equals("true")){
			riverUnit.setName("false");
			System.out.println(riverUnit.getName());
		}else{
			riverUnit.setName("true");
			System.out.println(riverUnit.getName());
		}	
		for(int i=0;i<StartView.riverList.size();i++){
			if(StartView.riverList.get(i).riverUnit.equals(riverUnit)){
				continue;
			}
			if(StartView.riverList.get(i).riverUnit.getName().equals("false")){
				StartView.riverList.get(i).riverUnit.setName("true");
			}
		}	
		for(int i=0;i<StartView.zletList.size();i++){
			StartView.zletList.get(i).zletUnit.setName("true");
		}
		for(int i=0;i<StartView.dragoonList.size();i++){
			StartView.dragoonList.get(i).dragoonUnit.setName("true");
		}		
	}
	public void dragoonstatus(JButton dragoonUnit){
		if(dragoonUnit.getName().equals("true")){
			dragoonUnit.setName("false");
			System.out.println(dragoonUnit.getName());
		}else{
			dragoonUnit.setName("true");
			System.out.println(dragoonUnit.getName());
		}	
		for(int i=0;i<StartView.dragoonList.size();i++){
			if(StartView.dragoonList.get(i).dragoonUnit.equals(dragoonUnit)){
				continue;
			}
			if(StartView.dragoonList.get(i).dragoonUnit.getName().equals("false")){
				StartView.dragoonList.get(i).dragoonUnit.setName("true");
			}
		}
		for(int i=0;i<StartView.zletList.size();i++){
			StartView.zletList.get(i).zletUnit.setName("true");
		}
		for(int i=0;i<StartView.riverList.size();i++){
			StartView.riverList.get(i).riverUnit.setName("true");
		}
	}
}
