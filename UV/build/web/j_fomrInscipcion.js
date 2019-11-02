$(document).ready(function(){
   
    var listaAlumnos=$("#list_alumnos");
    var lista_materias=$("#lista_materias");
    
   listaAlumnos.val(parseInt(listaAlumnos.attr("value"))); 
   lista_materias.val(parseInt(lista_materias.attr("value")));
    
     alert(listaAlumnos.attr("value"));
    
})

