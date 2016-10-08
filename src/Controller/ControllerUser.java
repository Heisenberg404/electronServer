package Controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import Beans.Users;
import Model.ModelUser;

@RequestScoped
@ManagedBean(name = "ControllerUser")
@ViewScoped
public class ControllerUser implements Serializable{
	
	private static final long serialVersionUID = 1L;
	ModelUser modelUser = new ModelUser();
	
	public void saveUser(Users users){
		try {
			modelUser.saveUser(users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}