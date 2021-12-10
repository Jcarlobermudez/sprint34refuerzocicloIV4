package com.sprint34.APPsprint34.controllers;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sprint34.APPsprint34.models.ClienteModel;
import com.sprint34.APPsprint34.services.ClienteService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping()
    public ArrayList<ClienteModel> obtenerClientes(){
        return  clienteService.obtenerClientes();
    }

    @PostMapping()
    public ClienteModel guardarCliente(@RequestBody ClienteModel cliente){

        return clienteService.guardarCliente(cliente);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarClientePorId(@PathVariable("id") String id){
        boolean resultadoEliminar=this.clienteService.eliminarCliente(id);
        if (resultadoEliminar){
            return "Se eliminó el usuario con id: "+id;
        }else{
            return "No se pudo eliminar el usuario con el id: "+id;
        }
    }

    @GetMapping(path = "/{id}")
    public Optional<ClienteModel> obtenerClientePorId(@PathVariable("id") String id){
        return this.clienteService.obtenerClientePorId(id);
    }

    @GetMapping(path= "/nombre/{nombre}")
    public ArrayList<ClienteModel> clientePorNombre(@PathVariable("nombre") String nombre) {
        return this.clienteService.obtenerPorNombre(nombre);
    }

    @GetMapping(path= "/apellido/{apellido}")
    public ArrayList<ClienteModel> clientePorApellido(@PathVariable("apellido") String apellido) {
        return this.clienteService.obtenerPorApellido(apellido);
    }

    @GetMapping(path= "/address/{ciudad}/{departamento}")
    public ArrayList<ClienteModel> clientePorAddress(@PathVariable("ciudad") String ciudad, @PathVariable("departamento") String departamento){
        return this.clienteService.obtenerCiudadYDepartamento(ciudad, departamento);
    }

    @GetMapping(path= "/puntosmayor/{puntos}")
    public ArrayList<ClienteModel> clienteMayorIgualPuntos(@PathVariable("puntos") Long puntos) {
        return this.clienteService.obtenerClientesMayorIgualPuntos(puntos);
    }

    @GetMapping(path= "/puntosmenor/{puntos}")
    public ArrayList<ClienteModel> clienteMenorIgualPuntos(@PathVariable("puntos") Long puntos) {
        return this.clienteService.obtenerClientesMenorIgualPuntos(puntos);
    }

    @GetMapping(path= "/fechadespues/{fecha}")
    public ArrayList<ClienteModel> clientePorFechaDespues(@PathVariable("fecha") String fechaString) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        Date fecha = null;
        try {
            fecha = formatoFecha.parse(fechaString.toString());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return this.clienteService.obtenerPorFechaDespues(fecha);
    }

    @GetMapping(path= "/fechantes/{fecha}")
    public ArrayList<ClienteModel> clientePorFechaAntes(@PathVariable("fecha") String fechaString) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        Date fecha = null;
        try {
            fecha = formatoFecha.parse(fechaString.toString());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return this.clienteService.obtenerPorFechaAntes(fecha);
    }

    @GetMapping(path= "/clienteproductos/{nombre}")
    public ArrayList<ClienteModel> clienteConProductos(@PathVariable("nombre") String nombre) {
        return this.clienteService.clienteProductos(nombre);
    }

}
