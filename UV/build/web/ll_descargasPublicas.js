$(document).ready(function(){  

    
     var descarga=$('.txt_descargar');
     descarga.click(()=>{      
     document.forFile.target="null";
     $('.cargarDescarga').submit();  

     });    
});

