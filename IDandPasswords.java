package ANPR_system;

import java.util.HashMap;

public class IDandPasswords {
  HashMap<String,String> logininfo = new HashMap<String,String>();
	
	IDandPasswords(){
		
		logininfo.put("sid003", "Sidali2003");
		logininfo.put("moha", "moha2010");
		logininfo.put("bro", "pizza");
	}
	public HashMap getlogininfo() {
		return logininfo;
	}
	
}
