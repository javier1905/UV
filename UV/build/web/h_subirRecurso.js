$(document).ready(function(){
   var cbx_puv_priv=$("#cbx_puv_priv") ;
   
  
   cbx_puv_priv.change(function(){
       
       
       
      if(cbx_puv_priv.is(':checked'))
      {
          cbx_puv_priv.val(true);
      }else
      {
          cbx_puv_priv.val(false);
      }     
       
   });


});

