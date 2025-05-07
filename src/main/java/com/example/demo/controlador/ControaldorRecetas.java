package com.example.demo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

@Controller
public class ControaldorRecetas {

    private static String[] listaRecetas = {"Pizza", "Espagueti", "Lasaña"};
    private static HashMap<String, String[]> recetasConIngredientes = new HashMap<>();

    public ControaldorRecetas() {
        String[] pizza = {"Pan", "Salsa de tomate", "Queso", "Pepperoni"};
        recetasConIngredientes.put("Pizza", pizza);

        String[] espagueti = {"Pasta", "Salsa de tomate", "Carne molida", "Queso parmesano"};
        recetasConIngredientes.put("Espagueti", espagueti);

        String[] lasaña = {"Pasta", "Salsa de tomate", "Queso", "Albahaca", "Espinaca", "Champiñones"};
        recetasConIngredientes.put("Lasaña", lasaña);
    }

    @GetMapping("/recetas")
    public String obtenerTodasLasRecetas(Model model) {
    	System.out.println("aaaaa");
        model.addAttribute("listaRecetas", listaRecetas);
        return "index";
    }

    @GetMapping("/recetas/{nombre}")
    public String obtenerRecetaPorNombre(@PathVariable String nombre, Model model) {
        if (recetasConIngredientes.containsKey(nombre)) {
            model.addAttribute("nombreReceta", nombre);
            model.addAttribute("ingredientes", recetasConIngredientes.get(nombre));
        } else {
            model.addAttribute("error", "La receta no se encuentra en nuestra lista.");
        }
        return "detalleReceta";
    }
}
