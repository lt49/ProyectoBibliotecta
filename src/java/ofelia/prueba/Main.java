/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.prueba;

import ofelia.model.dao.UbigeoDAO;
import ofelia.model.dao.UsuarioDAO;
import ofelia.model.dao.impl.UbigeoDaoImpl;
import ofelia.model.dao.impl.UsuarioDaoImpl;
import ofelia.model.entity.Ubigeo;
import ofelia.model.entity.Usuario;

/**
 *
 * @author Emmanuel
 */
public class Main {
    
    public static void main(String[] args) {
        Main m = new Main();
        //m.validarUsuario("isai", "isa123");
        //m.listarUsuarios();
         //m.listarUbigeo();
         //m.agregarUbigeo();
         //m.actualizarUbigeo();
         m.eliminarUbigeo();
    }
    
    public void validarUsuario(String user, String pass){
        UsuarioDAO dao = new UsuarioDaoImpl();
        Usuario u = dao.validarUsuario(user, pass);
        System.out.println("Usuario: "+u.getUsuario());
    }
    
    public void listarUsuarios(){
        UsuarioDAO dao = new UsuarioDaoImpl();
        for (Usuario usuario : dao.listarUsuario()) {
            System.out.println("Usuario: "+usuario.getUsuario());
        }
    }
    
    public void listarUbigeo(){
        UbigeoDAO dao = new UbigeoDaoImpl();
        for(Ubigeo ubigeo : dao.listarUbigeo()){
            System.out.println("Ubigeo: "+ubigeo.getNombre());
        }
    }
    
    public void agregarUbigeo(){
        UbigeoDAO dao = new UbigeoDaoImpl();
        Ubigeo ubigeo = new Ubigeo();
        ubigeo.setNombre("New York");
        ubigeo.setUbigeo_sup(7);
        if(dao.agregarUbigeo(ubigeo)){
            System.out.println("exito");
        }
    }
    
    public void actualizarUbigeo(){
        UbigeoDAO dao = new UbigeoDaoImpl();
        Ubigeo ubigeo = new Ubigeo();
        ubigeo.setIdubigeo(15);
        ubigeo.setNombre("actualizado");
        ubigeo.setUbigeo_sup(1);
        if(dao.editarUbigeo(ubigeo)){
            System.out.println("exito");
        }
    }
    
    public void eliminarUbigeo(){
        UbigeoDAO dao = new UbigeoDaoImpl();
        Ubigeo ubigeo = new Ubigeo();
        ubigeo.setIdubigeo(15);
        if(dao.eliminarUbigeo(15)){
            System.out.println("Eliminado");
        }
    }
}
