package Model;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import Beans.Products;
import Beans.Users;
import Utils.Conection;
import oracle.jdbc.OracleTypes;

public class ModelUser {
	

	public ModelUser() {
		super();
	}

	Conection conn = new Conection();

	public void saveUser(Users ref) throws Exception {
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		cs = con.prepareCall("{call PKG_Users.create_users(?,?,?,?,?,?,?)}");
		 // Parametros del procedimiento almacenado
		
		cs.setString(1, ref.getUsername());
		cs.setString(2, ref.getPass());
		cs.setString(3, ref.getComplete_name());
		cs.setString(4, ref.getLast_name());
		cs.setString(5, ref.getEmail());
		cs.setInt(6, ref.getNumber());
		// Definimos los tipos de los parametros de salida del procedimiento almacenado
        cs.registerOutParameter(7, java.sql.Types.VARCHAR);
		cs.execute();
		// Se obtienen la salida del procedimineto almacenado
        String back = cs.getString(7);
        System.out.println(back);

	}
	
	public List<Users> ReadUser()throws Exception{
		List<Users> lstUser = new ArrayList<Users>();
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		ResultSet rs = null;
		cs = con.prepareCall("{call PKG_Users.Read_USERS(?)}");
		cs.registerOutParameter(1, OracleTypes.CURSOR);
		cs.execute();
		rs = (ResultSet) cs.getObject(1);
		
		while (rs.next()) 
		{
			Users pr = new Users();
			
			pr.setId_users(rs.getInt("ID_USER"));
			pr.setUsername(rs.getString("USERNAME"));
			pr.setPass(rs.getString("PASS"));
			pr.setComplete_name(rs.getString("COMPLETE_NAME"));
			pr.setLast_name(rs.getString("LAST_NAME"));
			pr.setEmail(rs.getString("EMAIL"));
			pr.setNumber(rs.getInt("TELEPHONE"));
			
			lstUser.add(pr);
		}
		
		return lstUser;
		
	}
	//CAMBIAR LOS NOMBRES DE LAS VARIABLES 
	public void updateUsers(Users User) throws Exception {
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		cs = con.prepareCall("{call PKG_USERS.Update_USERS(?,?,?,?,?,?,?,?)}");
		 // Parametros del procedimiento almacenado	
		cs.setInt(1, User.getId_users());
		cs.setString(2, User.getUsername());
		cs.setString(3, User.getPass());
		cs.setString(4, User.getComplete_name());
		cs.setString(5, User.getLast_name());
		cs.setString(6, User.getEmail());	
		cs.setInt(7, User.getNumber());
		// Definimos los tipos de los parametros de salida del procedimiento almacenado
        cs.registerOutParameter(8, java.sql.Types.VARCHAR);
		cs.execute();
		// Se obtienen la salida del procedimineto almacenado
        String back = cs.getString(8);
        System.out.println(back);
	}
	public void deleteUsers(Users User) throws Exception {
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		cs = con.prepareCall("{call PKG_USERS.Delete_USERS(?,?)}");
		 // Parametros del procedimiento almacenado	
		cs.setInt(1, User.getId_users());		
		// Definimos los tipos de los parametros de salida del procedimiento almacenado
        cs.registerOutParameter(2, java.sql.Types.VARCHAR);
		cs.execute();
		// Se obtienen la salida del procedimineto almacenado
        String back = cs.getString(2);
        System.out.println(back);
	}
	
    public void iniciarSesion(Users user) throws Exception {
        Connection con = conn.getConnection();
        CallableStatement cs = null;
        cs = con.prepareCall("{call PKG_Users.QUERYUSER(?,?,?)}");
        // Parametros del procedimiento almacenado
        cs.setString(1, user.getUsername());
        cs.setString(2, user.getPass());
        // Definimos los tipos de los parametros de salida del procedimiento
        // almacenado
        cs.registerOutParameter(3, java.sql.Types.VARCHAR);
        cs.execute();
        // Se obtienen la salida del procedimineto almacenado     
        String back = cs.getString(3);
        System.out.println(back);       
        System.out.println(back);    
        
        if (back.equals("YES")) {

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", user);
            FacesContext.getCurrentInstance().getExternalContext().redirect("PrincipalMenu.xhtml");
        } else {
        	
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_WARN,"Error","User no existe")); 
        }

    }
    
    public void checkSession() {
        try {
            Users us = (Users) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            if (us == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("LoginUser.xhtml");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void closeSession() throws IOException{        
//        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();    
    }

}