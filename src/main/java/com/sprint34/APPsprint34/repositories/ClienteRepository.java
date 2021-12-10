package com.sprint34.APPsprint34.repositories;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprint34.APPsprint34.models.ClienteModel;

public interface ClienteRepository extends MongoRepository<ClienteModel, String>{

    ArrayList<ClienteModel> findByNombre (String nombre);

    ArrayList<ClienteModel> findByApellido (String apellido);

    @Query(value="{'address.ciudad':?0, 'address.departamento':?1}", fields = "{'nombre':1, 'apellido':1}")
    ArrayList<ClienteModel> clientesPorCiudadDepartamento(String ciudad, String departamento);

    ArrayList<ClienteModel> findByPuntosGreaterThanEqual(Long puntos);

    @Query("{'puntos':{$lte:?0}}")
    ArrayList<ClienteModel> clientesMenorIgualPuntos(Long puntos);

    //Se busca fechas despues de la fecha escrita por parametro
    ArrayList<ClienteModel> findByfRegistroAfter(Date fecha);

    //Se busca fechas antes de la fecha escrita por parametro
    ArrayList<ClienteModel> findByfRegistroBefore(Date fecha);

    //Clientes con sus productos correspondientes se pasa el nombre por parametro
    @Query(value="{'nombre':?0}", fields = "{'nombre':1, 'apellido':1, 'productos.nombre':1,'productos.cantidad':1, 'productos.price':1}")
    ArrayList<ClienteModel> clientesProductos(String nombre);
}
