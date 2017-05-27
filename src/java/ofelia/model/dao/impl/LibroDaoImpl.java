/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.dao.impl;

import java.util.List;
import ofelia.model.dao.LibroDAO;
import ofelia.model.entity.Libro;
import ofelia.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author user
 */
public class LibroDaoImpl implements LibroDAO{

    @Override
    public List<Libro> listarLibro() {
        List<Libro> lista = null;
        SessionFactory sf = null;
        Session session = null;
        Criteria criteria = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            criteria = session.createCriteria(Libro.class);
            lista = criteria.list();
        } catch (Exception e) {
            System.out.println("Error listarLibro: "+e.getMessage());
        }finally{
            if (session!=null) {
                session.close();
            }
        }
        return lista;
    }

    @Override
    public boolean agregarLibro(Libro li) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editarLibro(Libro li) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarLibro(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Libro buscarLibro(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
