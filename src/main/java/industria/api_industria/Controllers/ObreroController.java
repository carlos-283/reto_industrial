/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package industria.api_industria.Controllers;

import industria.api_industria.entities.Obrero;
import industria.api_industria.services.ObreroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *
 * @author solra
 */
@RestController
@RequestMapping("/api/obreros")
public class ObreroController {

    private final ObreroService service;
    
    public ObreroController(ObreroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Obrero> getAllObreros() {
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Obrero> getById(@PathVariable Long id) {
        Obrero obr = service.getById(id);
        return obr != null ? ResponseEntity.ok(obr) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public Obrero create(@RequestBody Obrero obr) {
        return service.create(obr);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Obrero> update(@PathVariable Long id, @RequestBody Obrero updated) {
        Obrero obr = service.update(id, updated);
        return obr != null ? ResponseEntity.ok(obr) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}

