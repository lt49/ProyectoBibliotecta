/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.prueba;

import ofelia.model.dao.UsuarioDAO;
import ofelia.model.dao.impl.UsuarioDaoImpl;
import ofelia.model.entity.Usuario;

/**
 *
 * @author Emmanuel
 */
public class Main {
    
    public static void main(String[] args) {
        Main m = new Main();
        //m.validarUsuario("lt49", "123");
        m.listarUsuarios();
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
    
}
