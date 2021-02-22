<!DOCTYPE html>
<jsp:useBean id="Usuario" type="br.com.tribumusic.model.Usuario" scope="session" />
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>.... TribuMusicFy ....</title>

        <meta name="description" content="Source code generated using layoutit.com">
        <meta name="author" content="LayoutIt!">

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

    </head>
    <body>

    <div class="container-fluid">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12"> 
                    <p id="topo" align="right" >Desevolvido por Alexandre Guedes</p>
                </div>
            </div>
        </div>
            <div class="row">
                <div class="col-md-12">
                    <p></p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12"> 
                    <img src="imagens/logo.jpg" class="rounded mx-auto d-block" width="25%" align="center" />
                    <p></p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <h3 class="text-center text-info">
                        <font style="vertical-align: inherit;">TriboMusic!<br>Sua Musica no melhor lugar!</font>
                    </h3>
                 </div>
            </div>
	</div>
        
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12"> 
                    <h4 align="center">Minhas Playlist's</h4>
                </div>
            </div>
        </div>
        <div class="row" id="menu">
            <div class="col-md-3"> 
                &nbsp;
            </div>
            <div class="col-md-6" id="navbarNav"> 
                <ul class="nav">
                    <li class="nav-item dropdown ml-md-auto">
                        <a class="nav-link active" href="#">Nova Playlist</a>
                    </li>
                    <li class="nav-item ml-md-auto">
                        <a class="nav-link" href="/myplaylists">Minha Playlist</a>
                    </li>
                    <li class="nav-item ml-md-auto">
                        <a class="nav-link" href="#">Upload Playlist</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-md-3"> 
            
        </div>
        <c:forEach var="playlist" items="${Usuario.paylists}">
            <!-- ITERAÇÕES -->
            <div class="row">
                <div class="col-md-3">&nbsp;</div>
                <div class="col-md-6">
                    <strong>${playlist.titulo}</strong><br/>
                    <ul>
                        <c:forEach var="musica" items="${playlist.musicas}">
                            <li>${musica.titulo} (${musica.artista})</li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="col-md-3">&nbsp;</div>
            </div>
        </c:forEach>
                
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>