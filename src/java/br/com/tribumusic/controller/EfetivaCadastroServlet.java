/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tribumusic.controller;

import br.com.tribumusic.dao.UsuarioDAO;
import br.com.tribumusic.model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.jdbc.pool.DataSource;

/**
 *
 * @author alexandre_guedes
 */
public class EfetivaCadastroServlet extends HttpServlet {
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina = "myaccount.jsp";
        
        String nome = request.getParameter("txtNome");
        String email = request.getParameter("TxtEmail");
        String senha = request.getParameter("txtSenha");
        
        Usuario usuario = new Usuario();
        
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        
        DataSource dataSource = new DataSource();
        UsuarioDAO usuarioDAO = new UsuarioDAO(dataSource);
        usuarioDAO.create(usuario);
        
        System.out.println(usuario);
        
        try{
            dataSource.getConnection().close();
        }
        catch(SQLException ex){
            System.out.println("Erro ao fechar a conexão"+ex.getMessage());
            request.setAttribute("ErroMSG", "Erro ao criar conta do usuario");
            pagina = "error.jsp";
        }
        
        if(usuario.getId() != 0)
            request.getSession().setAttribute("Usuario", usuario);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/newuser.jsp");
        dispatcher.forward(request,response);
    }
}
