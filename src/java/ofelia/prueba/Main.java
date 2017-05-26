/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.prueba;

import java.util.List;
import ofelia.model.dao.PersonaDAO;
import ofelia.model.dao.UsuarioDAO;
import ofelia.model.dao.impl.PersonaDaoImpl;
import ofelia.model.dao.impl.UsuarioDaoImpl;
import ofelia.model.entity.Persona;
import ofelia.model.entity.Usuario;

/**
 *
 * @author Emmanuel
 */
public class Main {
    
    public static void main(String[] args) {
        Main m = new Main();
//        m.validarUsuario("lt49", "123");
//        m.TestListarUsuario();
//        m.TestAgregarUsuario();
//        m.TestEditarUsuario();
//        m.TestEliminarUsuario();
//        -----PERSONA
        m.TestListarPersona();
//        m.TestAgregarPersona();
//        m.TestEliminarPersona();
//        m.TestEditarPersona();
        
    }
    
    public void validarUsuario(String user, String pass) {
        UsuarioDAO dao = new UsuarioDaoImpl();
        Usuario u = dao.validarUsuario(user, pass);
        System.out.println("Usuario: " + u.getUsuario());
    }
    
    public void TestListarUsuario() {
        UsuarioDAO dao = new UsuarioDaoImpl();
        List<Usuario> u = dao.listarUsuario();
        for (Usuario us : u) {
            System.out.println("Nombre :" + us.getUsuario() + " Clave: " + us.getClave());
        }
    }
    
    public void TestAgregarUsuario() {
        Usuario u = new Usuario();
        UsuarioDAO dao = new UsuarioDaoImpl();
        u.setUsuario("Lavado");
        u.setClave("123");
        u.setIdrol(1);
        u.setIdpersona(3);
        if (dao.agregarUsuario(u)) {
            System.out.println("Se agrego correctamente");
        } else {
            System.out.println("Noooo agrego correctamente");
        }
        
    }
    
    public void TestEditarUsuario() {
        Usuario u = new Usuario();
        UsuarioDAO dao = new UsuarioDaoImpl();
        u.setIdusuario(3);
        u.setUsuario("Lavado Lokito");
        u.setClave("123");
        u.setIdrol(1);
        u.setIdpersona(3);
        if (dao.editarUsuario(u)) {
            System.out.println("Se edito correctamente");
        } else {
            System.out.println("Noooo edito correctamente");
        }
    }
    
    public void TestEliminarUsuario() {
        UsuarioDAO dao = new UsuarioDaoImpl();
        if (dao.eliminarUsuario(4)) {
            System.out.println("Se elimino Correctaamente SIIIIIIIIIIIII");
        } else {
            System.out.println("No se elimino Noooo xQQQ no te lo puedo Creer ");
        }
    }
    
    public void TestListarPersona() {
        PersonaDAO pdao = new PersonaDaoImpl();
        List<Persona> p = pdao.listarPersona();
        for (Persona per : p) {
            System.out.println("Nombre :" + per.getNombres() + " Apellido: " + per.getApellidos());
        }
    }
    
    public void TestAgregarPersona() {
        Persona p = new Persona();
        PersonaDAO pdao = new PersonaDaoImpl();
        p.setNombres("Jhonerly");
        p.setApellidos("Bustamente");
        p.setIdtipo_doc(1);
        p.setNro_doc("27672610");
        p.setFecha_nac("2017/10/06");
        p.setDireccion("Encuentrame si puedes");
        p.setCondicion("En buen estado");
        if (pdao.agregarPersona(p)) {
            System.out.println("Se agrego correctamente");
        } else {
            System.out.println("Noooo agrego correctamente");
        }
    }
    
    public void TestEditarPersona() {
        Persona p = new Persona();
        PersonaDAO pdao = new PersonaDaoImpl();
        p.setIdpersona(6);
        p.setNombres("Jhonerly Lokita");
        p.setApellidos("Bustamente");
        p.setIdtipo_doc(1);
        p.setNro_doc("27672610");
        p.setFecha_nac("2017/10/06");
        p.setDireccion("Encuentrame si puedes");
        p.setCondicion("En buen estado");
        if (pdao.editarPersona(p)) {
            System.out.println("Se edito correctamente");
        } else {
            System.out.println("Noooo edito correctamente");
        }
        
    }
    
    public void TestEliminarPersona() {
           PersonaDAO pdao = new PersonaDaoImpl();
        if (pdao.eliminarPersona(5)) {
            System.out.println("Se elimino Correctaamente SIIIIIIIIIIIII");
        } else {
            System.out.println("No se elimino Noooo xQQQ no te lo puedo Creer ");
        }
    }
    
}
