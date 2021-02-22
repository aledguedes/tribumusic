<!DOCTYPE html>
<jsp:useBean id="erroSTR" class="java.lang.String" scope="request" />
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
                    <h3 class="text-center" id ="erro">ERRO!! ${erroSTR}</h3>
                </div>
            </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>