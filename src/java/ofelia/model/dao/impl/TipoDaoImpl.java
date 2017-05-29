/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.dao.impl;

import java.util.List;
import ofelia.model.dao.TipoDAO;
import ofelia.model.entity.Tipo;
import ofelia.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author FIORELA S
 */
public class TipoDaoImpl implements TipoDAO{

    @Override
    public List<Tipo> listarTipo() {
        SessionFactory sf = null;
        Session session = null;
        List<Tipo> lista = null;
        Criteria criteria = null;
       
        try {
            sf = HibernateUtil.getSessionFactory();
           session = sf.openSession();
           criteria = session.createCriteria(Tipo.class);
           lista = criteria.list();
        } catch (Exception e) {
            System.out.println("Error listarTipo: "+e.getStackTrace());
        }finally{
            if (session!=null) {
                session.close();
            }
        }
        return lista;
    }

    @Override
    public boolean agregarTipo(Tipo ti) {
    
     boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(ti);
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
    public boolean editarTipo(Tipo ti) {
     boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Tipo tip = null;
        try {
            sf=HibernateUtil.getSessionFactory();
            session=sf.openSession();
            tx=session.beginTransaction();
            tip=new Tipo();
            tip=(Tipo)session.get(Tipo.class, tip.getIdtipo());
            tip.setNombre(tip.getNombre());
            session.update(tip);
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
    public boolean eliminarTipo(int id) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Tipo tip = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            tip = new Tipo();
            tip = (Tipo)session.get(Tipo.class, id);
            session.delete(tip);
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
    public boolean buscarTipo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        
    


    
}
