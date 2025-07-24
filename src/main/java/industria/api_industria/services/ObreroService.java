/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package industria.api_industria.services;

import industria.api_industria.entities.Obrero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import industria.api_industria.repositories.ObreroRepository;

/**
 *
 * @author solra
 */

@RestController
public class ObreroService {

    ObreroService(ObreroRepository obreroRepository) {
        this.obreroRepository = obreroRepository;
    }

    @Autowired
    public ObreroRepository obreroRepository;

    public List<Obrero> getAll() {
        return obreroRepository.findAll();
    }
    
    public Obrero getById(Long id ) {
        return obreroRepository.findById(id).orElse(null);
    }
    
    public Obrero create(Obrero obrero) {
        return obreroRepository.save(obrero);
    }

    public Obrero update(Long id, Obrero updated) {
        return obreroRepository.findById(id).map(obr -> {
            obr.setNombre(updated.getNombre());
            obr.setApellido(updated.getApellido());
            obr.setArea(updated.getArea());
            return obreroRepository.save(obr);
        }).orElse(null);
    }
    
    public void delete(Long id) {
        obreroRepository.deleteById(id);
    }

}
