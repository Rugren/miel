package com.example.miel.controladores;


import com.example.miel.modelo.EntradaMiel;
import com.example.miel.repositorios.RepositorioEntradas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
// hay que darle a importar @Controller

public class Principal {
    @Autowired
    RepositorioEntradas repo;

    @GetMapping({"/", "/index", "/index.html"})
    public String paginaInicial(Model model){
        EntradaMiel entradaMiel=new EntradaMiel();
        entradaMiel.setFecha(LocalDate.now());
        entradaMiel.setParaje("CienLagos");
        entradaMiel.setFlor("Romero");
        entradaMiel.setLote("123-abc");
        repo.save(entradaMiel);

        model.addAttribute("listaEntradas", repo.findAll());

        return "index";
    }


    /**
     * Así era de un ejemplo que hicimos
     * public String paginaInicial(Model model){
        ArrayList<String> miArray=new ArrayList<>();
        miArray.add("Patata");
        miArray.add("Lechuga");
        miArray.add("Tomillo");
        model.addAttribute("lista", miArray);

        model.addAttribute("nombre", "Rubén");
        return "index";
    }
     **/


    @GetMapping("/ubicacion")
    public String paginaUbicacion(Model model){
        return "ubicacion";
    }

}
