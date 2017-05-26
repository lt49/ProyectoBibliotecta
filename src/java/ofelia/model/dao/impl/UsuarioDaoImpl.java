package ofelia.model.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import ofelia.model.entity.Usuario;
import ofelia.model.dao.UsuarioDAO;
import ofelia.model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




public class UsuarioDaoImpl implements UsuarioDAO{

//    private Connection cn;
    
    @Override
    public List<Usuario> listarUsuario() {
       
        List<Usuario> lista = null;
        
        return lista;
    }

    @Override
    public boolean agregarUsuario(Usuario us) {
        boolean flat = false;
        
        return flat;
    }
    
    @Override
    public boolean editarUsuario(Usuario us) {
        boolean flat = false;

        return flat;
    }

    @Override
    public boolean eliminarUsuario(int id) {
        boolean flat = false;

        return flat;
    }

    @Override
    public Usuario buscarrUsuario(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario validarUsuario(String usuario, String clave) {
        SessionFactory sf = null;
        Session session = null;  
        Query query = null;
        Usuario usu=null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            query = session.createQuery("from Usuario where usuario = :user and clave = :pass");
            query.setParameter("user", usuario);
            query.setParameter("pass", clave);
            usu = new Usuario();
            usu = (Usuario)query.uniqueResult();
        } catch (Exception e) {
            System.out.println("Error validarUsuario: "+e.getMessage());
        }
        finally{
            if (session!=null) {
                session.close();
            }            
        }
        return usu;
    }
    
}
