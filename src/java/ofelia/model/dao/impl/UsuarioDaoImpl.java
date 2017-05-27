package ofelia.model.dao.impl;


import java.util.List;
import ofelia.model.entity.Usuario;
import ofelia.model.dao.UsuarioDAO;
import ofelia.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




public class UsuarioDaoImpl implements UsuarioDAO{

//    private Connection cn;
    
    @Override
    public List<Usuario> listarUsuario() {
        SessionFactory sf = null;
        Session session = null;
        List<Usuario> lista = null;
        Criteria criteria = null;
        Query query = null;
        try {
           sf = HibernateUtil.getSessionFactory();
           session = sf.openSession();
           criteria = session.createCriteria(Usuario.class);
           lista = criteria.list();
           //Usuario user = (Usuario)session.get(Usuario.class, 1);
           
//           query = session.createQuery("from Usuario"); 
//           lista = query.list();
        } catch (Exception e) {
            System.out.println("Error listarUsuario: "+e.getMessage());
        }finally{
            if (session!=null) {
                session.close();
            }
        }
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
