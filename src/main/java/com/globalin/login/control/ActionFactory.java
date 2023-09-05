package com.globalin.login.control;

import com.globalin.login.action.Action;



import com.globalin.login.action.DeleteFormAction;
import com.globalin.login.action.DeleteProcAction;
import com.globalin.login.action.IdCheckAction;
import com.globalin.login.action.IndexAction;
import com.globalin.login.action.LoginFormAction;
import com.globalin.login.action.LoginProcAction;
import com.globalin.login.action.LogoutAction;
import com.globalin.login.action.ModifyFormAction;
import com.globalin.login.action.ModifyProcAction;
import com.globalin.login.action.RegFormAction;
import com.globalin.login.action.RegProcAction;


public class ActionFactory {

     private static ActionFactory factory;
	
	private ActionFactory() {	}
	
	public static synchronized ActionFactory getInstance() {
		
		if(factory == null) {
			factory = new  ActionFactory();
		}
		return factory;
	}
	
	public Action getAction(String cmd) {
		
		Action action = null;
		
		switch(cmd) {
		
		case "index" :
			action = new IndexAction();
		    break;
		    
		case "regForm" :
			action = new RegFormAction();
		    break;
		    
		case "idCheck" :
			action = new IdCheckAction();
		    break;   
		      
			    
		case "regProc" :
			action = new RegProcAction();
		    break; 
		    
		case "login" :
			action = new LoginFormAction();
		    break;     
		    
		case "loginProc" :
			action = new LoginProcAction();
		    break; 
		    
		    
		case "logout" :
			action = new LogoutAction();
		    break;   
		    
		case "modifyForm" :
			action = new ModifyFormAction();
		    break; 
		    
		case "modifyProc" :
			action = new ModifyProcAction();
		    break; 
		    
		case "delete" :
			action = new DeleteFormAction();
		    break; 
		    
		    
		case "deleteProc" :
			action = new DeleteProcAction();
		    break;  
		    
		
		default :
			action = new IndexAction();
			break;
		}
		
		
		return action;
		
	}
	
	
	
	
	
	
	
}
