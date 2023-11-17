package com.example.miel.controladores;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
// hay que darle a importar @Controller

public class Principal {
    @GetMapping({"/", "/index", "/index.html"})
    public String paginaInicial(Model model){
        ArrayList<String> miArray=new ArrayList<>();
        miArray.add("Patata");
        miArray.add("Lechuga");
        miArray.add("Tomillo");
        model.addAttribute("lista", miArray);



        model.addAttribute("nombre", "Rubén");
        return "index";
    }

    @GetMapping("/ubicacion")
    public String paginaUbicacion(Model model){
        return "ubicacion";
    }

}
