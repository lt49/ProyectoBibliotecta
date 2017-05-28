/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.dao.impl;

import java.util.List;
import ofelia.model.dao.CategoriaDAO;
import ofelia.model.entity.Categoria;
import ofelia.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Cristian Perales D
 */
public class CategoriaDaoImpl implements CategoriaDAO{

    @Override
    public List<Categoria> listarCategoria() {
        SessionFactory sf = null;
        Session session = null;
        
        List<Categoria> lista = null;
        Criteria criteria = null;
        Query query = null;
        
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            criteria = session.createCriteria(Categoria.class);
            lista = criteria.list();
        } catch (Exception e) {
            System.out.println("Error Lisar Categoria: "+e.getMessage());
        }finally{
            if (session !=null) {
                session.close();
            }
        }return lista; 
    }

    @Override
    public boolean agregarCategoria(Categoria ca) {
        
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(ca);
            tx.commit();
            session.close();
            flat = true;
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            tx.rollback();
            session.close();
            flat = false;
        }
        return flat;
    }

    @Override
    public boolean editarCategoria(Categoria ca) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Categoria cat = null;
        
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            cat = new Categoria();
            cat = (Categoria) session.get(Categoria.class, ca.getIdcategoria());
            cat.setDescripcion(ca.getDescripcion());
            cat.setIdcategoria(ca.getIdcategoria());
            cat.setIdcategoria_sup(ca.getIdcategoria_sup());
            cat.setNombre(ca.getNombre());
            cat.setNro(ca.getNro());
            session.update(ca);
            tx.commit();
            session.close();
            flat = true;
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            tx.rollback();
            session.close();
            flat = false;
        }
        return flat;
    }

    @Override
    public boolean eliminarCategoria(int id) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Categoria cat = null;
        
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            cat = new Categoria();
            cat = (Categoria) session.get(Categoria.class, id);
            session.delete(cat);
            tx.commit();
            session.close();
            flat = true;
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
      return flat;  
    }

    @Override
    public Categoria buscarCategoria(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
