/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tribumusic.controller;

import br.com.tribumusic.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexandre_guedes
 */
public class MyPlaylistsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paginaRetorno;
        Usuario usuario = (Usuario)request.getSession().getAttribute("Usuario");
        //confirmar se o cara ta logado
        if (usuario == null){
            paginaRetorno = "/index.html";
        }
        else{
            paginaRetorno = "/myplaylists.jsp";
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaRetorno);
        dispatcher.forward(request,response);
        
    }
}
