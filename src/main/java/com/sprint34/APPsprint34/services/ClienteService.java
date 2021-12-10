package com.sprint34.APPsprint34.services;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint34.APPsprint34.models.ClienteModel;
import com.sprint34.APPsprint34.repositories.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public ArrayList<ClienteModel> obtenerClientes(){
        return (ArrayList<ClienteModel>) clienteRepository.findAll();
    }

    public ClienteModel guardarCliente(ClienteModel cliente){
        cliente.setNombre(cliente.getNombre().toLowerCase()); //Opcional, convertir la cadena a minúscula para facilitar buscar por nombre , esto normalmente se hace desde el frontend
        return clienteRepository.save(cliente);
    }

    public boolean eliminarCliente(String id){

        if (clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return true;
        }else{
            return false;
        }

    }
    public Optional<ClienteModel> obtenerClientePorId(String id){

        return clienteRepository.findById(id);
    }

    public ArrayList<ClienteModel> obtenerPorNombre(String nombre){
        return clienteRepository.findByNombre(nombre);
    }

    public ArrayList<ClienteModel> obtenerPorApellido(String apellido){
        return clienteRepository.findByApellido(apellido);
    }

    public ArrayList<ClienteModel> obtenerCiudadYDepartamento(String nombre, String departamento){
        return clienteRepository.clientesPorCiudadDepartamento(nombre, departamento);
    }

    public ArrayList<ClienteModel> obtenerClientesMayorIgualPuntos(Long puntos){
        return clienteRepository.findByPuntosGreaterThanEqual(puntos);
    }

    public ArrayList<ClienteModel> obtenerClientesMenorIgualPuntos(Long puntos){
        return clienteRepository.clientesMenorIgualPuntos(puntos);
    }

    //Se busca fechas despues de la fecha escrita por parametro
    public ArrayList<ClienteModel> obtenerPorFechaDespues(Date fecha){
        return clienteRepository.findByfRegistroAfter(fecha);
    }

    //Se busca fechas antes de la fecha escrita por parametro
    public ArrayList<ClienteModel> obtenerPorFechaAntes(Date fecha){
        return clienteRepository.findByfRegistroBefore(fecha);
    }

    //Clientes con sus productos correspondientes se pasa el nombre por parametro
    public ArrayList<ClienteModel> clienteProductos(String nombre){
        return clienteRepository.clientesProductos(nombre);
    }

}
