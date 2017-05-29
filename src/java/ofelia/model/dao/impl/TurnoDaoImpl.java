/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.dao.impl;

import java.util.List;
import ofelia.model.dao.TurnoDAO;
import ofelia.model.entity.Turno;
import ofelia.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author FIORELA S
 */
public class TurnoDaoImpl implements TurnoDAO{

    @Override
    public List<Turno> listarTurno() {
        SessionFactory sf = null;
        Session session = null;
        List<Turno> lista = null;
        Criteria criteria = null;
       
        try {
            sf = HibernateUtil.getSessionFactory();
           session = sf.openSession();
           criteria = session.createCriteria(Turno.class);
           lista = criteria.list();
        } catch (Exception e) {
            System.out.println("Error listarTurno: "+e.getStackTrace());
        }finally{
            if (session!=null) {
                session.close();
            }
        }
        return lista;
        
    }

    @Override
    public boolean agregarTurno(Turno tr) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(tr);
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
    public boolean editarTurno(Turno tr) {
     
    boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Turno turn = null;
        try {
            sf=HibernateUtil.getSessionFactory();
            session=sf.openSession();
            tx=session.beginTransaction();
            turn=new Turno();
            turn=(Turno)session.get(Turno.class, turn.getIdturno());
            turn.setTurno(turn.getTurno());
            session.update(turn);
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
    public boolean eliminarTurno(int id) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Turno turn = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            turn = new Turno();
            turn = (Turno)session.get(Turno.class, id);
            session.delete(turn);
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
    public Turno buscarTurno(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
