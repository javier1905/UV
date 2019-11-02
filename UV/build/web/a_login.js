$(document).ready(function (){
 var txt_usuario= $("#txt_usuario");
 var txt_pass=$("#txt_password");
 var formularioLogin =$("#formularioLogin"); 
 
 txt_usuario.keypress(function(tecla) {
        if(tecla.charCode < 48 || tecla.charCode > 57) return false;        
    });
    txt_pass.keypress(function(tecla) {
        if(tecla.charCode < 48 || tecla.charCode > 57) return false;        
    });

 formularioLogin.submit(function(e){
  
             if(txt_usuario.val()=='' || txt_pass.val()=='')
             {
                e.preventDefault();
             }
//             if (!Number.isInteger(paseInt(txt_usuario.val())))
//             {
//                 e.preventDefault();
//             }
//             if (!Number.isInteger(parseInt(txt_pass.val())))
//             {
//                 e.preventDefault();
//             }
     
      });
     
 });