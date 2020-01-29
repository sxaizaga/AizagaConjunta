/*
 * ESPE - DCC - APLICACIONES DISTRIBUIDAS
 * Sistema: Global-ejb
 * 
 * Creado: 15/12/2019 - 12:41:21
 * 
 * Los contenidos de este archivo son propiedad privada y estan protegidos por la licencia BSD.
 * 
 * 
 * Se puede utilizar, reproducir o copiar el contenido de este archivo.
 */
package ec.edu.espe.distribuidas.aizaga.web;

import ec.edu.espe.distribuidas.aizaga.model.Funcionalidad;
import ec.edu.espe.distribuidas.aizaga.model.Modulo;
import ec.edu.espe.distribuidas.aizaga.service.ConjuntaService;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Aizaga Steven
 */
@Named
@ViewScoped
public class ConjuntaBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(ConjuntaBean.class.getName());

    @Inject
    private ConjuntaService conjuntaService;
    
    private Modulo modulo;
    
    private List<Modulo> modulos;
    
    private Funcionalidad funcionalidad;
    
    @PostConstruct
    public void initIt() {
        modulo = new Modulo();
        modulos = conjuntaService.obtenerTodosModulo();
    }
    
    public void getAllModulos() {
        try {
            modulos = this.conjuntaService.obtenerTodosModulo();
        } catch (RuntimeException e) {
            LOG.info("Error en el búsqueda");
        }
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }
    
    
    
}
