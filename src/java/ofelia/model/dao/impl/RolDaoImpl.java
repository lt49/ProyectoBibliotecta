/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.dao.impl;

import java.util.List;
import ofelia.model.dao.RolDAO;
import ofelia.model.entity.Rol;
import ofelia.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author FIORELA S
 */
public class RolDaoImpl implements RolDAO{

    @Override
    public List<Rol> listarRol() {
   SessionFactory sf = null;
        Session session = null;
        List<Rol> lista = null;
        Criteria criteria = null;
       
        try {
           sf = HibernateUtil.getSessionFactory();
           session = sf.openSession();
           criteria = session.createCriteria(Rol.class);
           lista = criteria.list();
        } catch (Exception e) {
            System.out.println("Error listarRol: "+e.getStackTrace());
        }finally{
            if (session!=null) {
                session.close();
            }
        }
        return lista; }

    @Override
    public boolean agregarRol(Rol rl) {
     boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(rl);
            tx.commit();
            session.close();
            flat = true;
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
            tx.rollback();
            session.close();
            flat = false;
        }
        return flat;
    }

    @Override
    public boolean editarRol(Rol rl) {
     boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Rol rol = null;
        try {
            sf=HibernateUtil.getSessionFactory();
            session=sf.openSession();
            tx=session.beginTransaction();
            rol=new Rol();
            rol=(Rol)session.get(Rol.class, rol.getIdRol());
            rol.setRol(rol.getRol());
            session.update(rol);
            tx.commit();
            session.close();
            flat=true;
        } catch (Exception e) {
            System.out.println("ERROR:"+e.getMessage());
            tx.rollback();
            session.close();
            flat=false;
        }
        return flat;
    }

    @Override
    public boolean eliminarRol(int id) {
    boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Rol rol = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            rol = new Rol();
            rol = (Rol)session.get(Rol.class, id);
            session.delete(rol);
            tx.commit();
            session.close();
            flat=true;
        } catch (Exception e) {
            System.out.println("ERROR:"+e.getMessage());
            tx.rollback();
            session.close();
            flat=false;
        }
        return flat;
    }

    @Override
    public Rol buscarRol(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
