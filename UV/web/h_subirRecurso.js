$(document).ready(function(){
   var cbx_puv_priv=$("#cbx_puv_priv") ;
  var txt_detalle=$("#txt_detalle"); 
  var txt_formato=$("#txt_formato");
  var cbx_materias=$("#cbx_materias");
  var inputGroupFile03=$("#inputGroupFile03");
  
      var formularioMateria= $("#formularioAlta");
    var cajaError=$("#cajaError");
    
        cajaError.css('display','none');


   cbx_puv_priv.change(function(){
       
       
       
      if(cbx_puv_priv.is(':checked'))
      {
          cbx_puv_priv.val(true);
      }else
      {
          cbx_puv_priv.val(false);
      }     
       
   });
   
       formularioMateria.submit(function(e){
    
        if(!valida())
        {
             e.preventDefault();
        }else
        {
             cajaError.css('display','none');
        }     
        
        });
   
   
       function valida()
    {
        var bandera= true;
         var mensaje="";
        
        if(txt_detalle.val()=='undefined'  || txt_detalle.val()==null || txt_detalle.val()=='')
        {
            bandera=false;
            mensaje=mensaje+"Complete el campo detalle <br>"; 
            
        }
        if(txt_formato.val()=='undefined'  || txt_formato.val()==null || txt_formato.val()=='')
        {
            bandera=false;
            mensaje=mensaje+"Complete el campo formato <br>"; 
            
        }
        if(inputGroupFile03.val()=='undefined'  || inputGroupFile03.val()==null || inputGroupFile03.val()=='')
        {
            bandera=false;
            mensaje=mensaje+"Seleccione un archivo <br>"; 
            
        }


        if(bandera==false)
        {
             cajaError.css('display','block');
//             cajaError.effect('shake');
             cajaError.html(mensaje);
           
         }
        
        return bandera;
        
    }


});

