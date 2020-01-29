/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.aizaga.service;

import ec.edu.espe.distribuidas.aizaga.dao.FuncionalidadDAO;
import ec.edu.espe.distribuidas.aizaga.dao.ModuloDAO;
import ec.edu.espe.distribuidas.aizaga.enums.EstadoActivoInactivoEnum;
import ec.edu.espe.distribuidas.aizaga.model.Funcionalidad;
import ec.edu.espe.distribuidas.aizaga.model.Modulo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Aizaga Steven
 */
@Stateless
@LocalBean
public class ConjuntaService {
    @EJB
    private ModuloDAO moduloDao;
    
    @EJB
    private FuncionalidadDAO funcionalidadDao;


    /**
     * Obtiene un listado de Funcionalidades.
     *
     * @return Listado Funcionalidads en base al estado.
     */
    public List<Funcionalidad> obtenerTodosFuncionalidad() {
        return funcionalidadDao.findAll();
    }

    /**
     * Obtiene un Funcionalidad en base a la clave primaria.
     *
     * @param codigo El código con el que se va a realizar la busqueda.
     * @return Funcionalidad en base al código.
     */
    public Funcionalidad obtenerPorPK(Integer codigo) {
        return funcionalidadDao.find(codigo);
    }

    /**
     * Obtiene un listado de Funcionalidades en base al código del modulo.
     *
     * @param codModulo Código del modulo que se va a buscar.
     *
     * @return Listado Funcionalidades en base al codigo del modulo.
     */
    public List<Funcionalidad> obtenerPorEstado(String codModulo) {
        return funcionalidadDao.findByCodModulo(codModulo);
    }

    /**
     * Obtiene un Funcionalidad en base a un nombre.
     *
     * @param nombre Nombre del modulo al cual se busca.
     *
     * @return Un modulo que coincida con el nombre.
     */
    public Funcionalidad obtenerPorNombreFuncionalidad(String nombre) {
        return funcionalidadDao.findByNombre(nombre);
    }

    /**
     * Crea un nuevo Funcionalidad.
     *
     * @param modulo Nombre del modulo al cual se busca.
     */
    public void create(Funcionalidad modulo) {
        if (modulo.getModulo().getCodigo().isEmpty()) {
            throw new UnsupportedOperationException("La funcionalidad debe estar asociada a un modulo.");
        }
        if (modulo.getNombre().isEmpty() || modulo.getUrlPrincipal().isEmpty()) {
            if (modulo.getNombre().isEmpty()) {
                throw new UnsupportedOperationException("El nombre de la funcionalidad no puede ir vacio.");
            }
            if (modulo.getUrlPrincipal().isEmpty()) {
                throw new UnsupportedOperationException("La URL de la funcionalidad no puede ir vacia.");
            }
        }

        funcionalidadDao.create(modulo);
    }

    /**
     * Actualiza un nuevo Funcionalidad.
     *
     * @param modulo Nombre del modulo al cual se busca.
     */
    public void update(Funcionalidad modulo) {
        if (modulo.getCodigo() == null) {
            throw new UnsupportedOperationException("Para actualizar la funcionalidad debe poseer un codigo por el cual buscar.");
        }

        if (modulo.getNombre().isEmpty() || modulo.getUrlPrincipal().isEmpty() || modulo.getModulo().getCodigo().isEmpty()) {
            if (modulo.getNombre().isEmpty()) {
                throw new UnsupportedOperationException("El nombre de la funcionalidad no puede ir vacio.");
            }
            if (modulo.getUrlPrincipal().isEmpty()) {
                throw new UnsupportedOperationException("La URL de la funcionalidad no puede ir vacia.");
            }
            if (modulo.getModulo().getCodigo().isEmpty()) {
                throw new UnsupportedOperationException("La funcionalidad debe estar asociada a un modulo.");
            }
        }

        funcionalidadDao.edit(modulo);
    }
    
    /**
     * Obtiene un listado de Modulos.
     *
     * @return Listado Modulos en base al estado.
     */
    public List<Modulo> obtenerTodosModulo() {
        return moduloDao.findAll();
    }

    /**
     * Obtiene un Modulo en base a la clave primaria.
     *
     * @param codigo El código del modulo con el que se va a realizar la
     * busqueda.
     * @return Modulo en base al código.
     */
    public Modulo obtenerPorPK(String codigo) {
        return moduloDao.find(codigo);
    }

    /**
     * Obtiene un listado de Modulos en base al estado.
     *
     * @param estado Estado de los modulos que se van a buscar.
     *
     * @return Listado Modulos en base al estado.
     */
    public List<Modulo> obtenerPorEstado(EstadoActivoInactivoEnum estado) {
        return moduloDao.findByEstado(estado);
    }

    /**
     * Obtiene un Modulo en base a un nombre.
     *
     * @param nombre Nombre del modulo al cual se busca.
     *
     * @return Un modulo que coincida con el nombre.
     */
    public Modulo obtenerPorNombreModulo(String nombre) {
        return moduloDao.findByNombre(nombre);
    }

    /**
     * Crea un nuevo Modulo.
     *
     * @param modulo Nombre del modulo al cual se busca.
     */
    public void create(Modulo modulo) {
        if (modulo.getCodigo().isEmpty()) {
            throw new UnsupportedOperationException("El modulo no se puede crear con un código vacio.");
        }
        if (modulo.getEstado() == null || modulo.getNombre().isEmpty()) {
            if (modulo.getNombre().isEmpty()) {
                throw new UnsupportedOperationException("El nombre del modulo no puede ir vacio.");
            }
            if (modulo.getEstado() == null) {
                throw new UnsupportedOperationException("El estado del modulo no se puede ir vacio.");
            }
        }

        moduloDao.create(modulo);
    }

    /**
     * Actualiza un nuevo Modulo.
     *
     * @param modulo Nombre del modulo al cual se busca.
     */
    public void update(Modulo modulo) {
        if (modulo.getCodigo().isEmpty()) {
            throw new UnsupportedOperationException("El modulo no se puede actualizar con un código vacio.");
        }
        if (modulo.getEstado() == null || modulo.getNombre().isEmpty()) {
            if (modulo.getNombre().isEmpty()) {
                throw new UnsupportedOperationException("El nombre del modulo no puede ir vacio.");
            }
            if (modulo.getEstado() == null) {
                throw new UnsupportedOperationException("El estado del modulo no se puede ir vacio.");
            }
        }

        moduloDao.edit(modulo);
    }
    
}
