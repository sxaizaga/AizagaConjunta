/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.aizaga.dao;

import ec.edu.espe.distribuidas.aizaga.model.Funcionalidad;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author 404NotFound
 */
@LocalBean
@Stateless
public class FuncionalidadDAO extends AbstractDAO<Funcionalidad> {

    public FuncionalidadDAO() {
        super(Funcionalidad.class);
    }

    /**
     * Metodo Finder que obtiene un listado de funcionalidades en base al código
     * del Modulo.
     *
     * @param codModulo El código del modulo con el que se va a realizar la
     * busqueda.
     * @return Listado de funcionalidades en base al modulo.
     */
    public List<Funcionalidad> findByCodModulo(String codModulo) {
        return this.finder(
                "SELECT f FROM Funcionalidad f WHERE f.modulo.codigo = ?1",
                new Object[]{
                    codModulo
                }
        );
    }

    /**
     * Metodo Finder que obtiene una funcionalidad en base al nombre.
     *
     * @param nombre El nombre de la funcionalidad que se va a buscar.
     * @return Una funcionalidad en base al nombre.
     */
    public Funcionalidad findByNombre(String nombre) {
        return this.finder(
                "SELECT f FROM Funcionalidad f WHERE f.nombre = ?1",
                new Object[]{
                    nombre
                }
        ).get(0);
    }

}