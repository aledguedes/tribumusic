/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tribumusic.dao;

import br.com.tribumusic.model.Usuario;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.tomcat.jdbc.pool.DataSource;

/**
 *
 * @author alexa
 */
public class UsuarioDAO implements GenericDAO{
    public DataSourse dataSource;
    
    public UsuarioDAO(DataSourse dataSourse){
        this.dataSource = dataSourse;
    }

    public UsuarioDAO(DataSource ds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public  void create(Object o){
        try{
            if (o instanceof Usuario){
                String SQL = "INSERT INTO tblusuario VALUES (null, ?, ?, ?)";
                Usuario usuario = (Usuario)o;
                PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                stm.setString(1, usuario.getNome());
                stm.setString(2, usuario.getEmail());
                stm.setString(3, usuario.getSenha());
                int res = stm.executeUpdate();
                if (res != 0){
                    java.sql.ResultSet rs = stm.getGeneratedKeys();
                    if(rs.next()){
                        usuario.setId(rs.getInt(1));
                    }
                    rs.close();
                }
                stm.close();
            }
            else{
                throw new RuntimeException("Invalid User Model Object");
            }
        }
        catch(SQLException ex){
            System.out.println("Erro ao inserir usuario"+ex.getMessage());
        }
    }
    public  List<Object> read(Object o){        
        try{
            if (o instanceof Usuario){//passar como parametro um objeto tipo usuário
                Usuario incompleto = (Usuario)o;
                //receber usuário (login e senha) e recuperar do banco tudo e retorne uma lista 
                //dessa restrição
                String SQL = "SELECT * FROM tblusuario WHERE email = ? AND senha = ?";
                //para recuperar algum usuário com senha e usuário que foi passado para USUARIO INCOMPLETO
                
                PreparedStatement stm;
                stm = dataSource.getConnection().prepareStatement(SQL);
                stm.setString(1, incompleto.getEmail());
                stm.setString(2, incompleto.getSenha());
                java.sql.ResultSet rs = stm.executeQuery();
                ArrayList<Object> result = new ArrayList<Object>();
                if(rs.next()){
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("idUsuario"));
                    usuario.setNome(rs.getString("nome"));                    
                    usuario.setEmail(rs.getString("email"));
                    usuario.setSenha(rs.getString("senha"));
                    result.add(usuario);
                }
                stm.close();
                rs.close();
                return result;
            }
            else{
                throw new RuntimeException("Invalid Object");
            }
        }
        catch(SQLException ex){
            System.out.println("Erro ao recuper usuário"+ex.getMessage());
        }
        return null;
        /*Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setEmail("alexandredguedes@gmail.com");
        usuario.setNome("Alexandre Guedes");
        usuario.setSenha("123");
        
        //USUÁRIO TEM PLAYLIST
        ArrayList<PlayList> playlists = new ArrayList<PlayList>();
        
        //CRIAR UMA ARRAY LIST DA LISTA
        PlayList lista1 = new PlayList();
        lista1.setId(1);
        lista1.setTitulo("Nacionais");
        
        //MUSICAS DA PLAYLIST
        ArrayList<Musica> musicaP1 = new ArrayList<Musica>();
        Musica m1 = new Musica();
        m1.setId(1);
        m1.setArtista("Biquini Cavadão");
        m1.setTitulo("Vento Ventania");
        m1.setEstilo(1);
        m1.setAlbum("Ao Vivo em Fortaleza");
        m1.setLinkMP3("musicas/biquini/aovivo/vento_ventania.mp3");
        
        musicaP1.add(m1); // add na lista Playlist
        lista1.setMusicas(musicaP1);
        playlists.add(lista1);
        usuario.setPaylists(playlists);// add usuario
        
        ArrayList<Object> resultado = new ArrayList<Object>();
        resultado.add(usuario);
        return resultado;*/
    }
    public  void update(Object o){ 
        
    }
    public  void delete(Object o){
        
    }
}
