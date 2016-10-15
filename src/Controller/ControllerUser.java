package Controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import Beans.Products;
import Beans.Users;
import Model.ModelUser;

@RequestScoped
@ManagedBean(name = "ControllerUser")
@ViewScoped
public class ControllerUser implements Serializable{
	
	private static final long serialVersionUID = 1L;
	ModelUser modelUser = new ModelUser();
	
	List<Users> lstUser = new ArrayList<Users>();
	
	public List<Users> getLstUser(){
		return lstUser;
	}

	public void setLstUser(List<Users> lstUser) {
		this.lstUser = lstUser;
	}
	
	@PostConstruct
	public void init() {
		try {
			getlistUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void saveUser(Users Users){
		try {
			modelUser.saveUser(Users);
			lstUser = modelUser.ReadUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getlistUser() throws Exception {

		lstUser = modelUser.ReadUser();
	}
	
	public void updateUsers(Users User)
	{
		try {
			modelUser.updateUsers(User);
			lstUser = modelUser.ReadUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteUser (Users User){
		try {
			modelUser.deleteUsers(User);
			lstUser = modelUser.ReadUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public void checkSession() throws Exception {
        modelUser.checkSession();
    }

    public void iniciarSesion(Users users) {
        try {
            modelUser.iniciarSesion(users);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void closeSession()
    {
        try {
            modelUser.closeSession();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

	
	
}