package com.example.accessingmongodbdatarest.comercio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
public class ComercioController {

    @Autowired
    private ComercioRepository ComercioRepository;

    public ComercioController(ComercioRepository ComercioRepository) {
        this.ComercioRepository = ComercioRepository;
    }

    @GetMapping("/Comercios")
    public List<Comercio> getAllComercios() {
        return ComercioRepository.findAll();
    }

    @GetMapping("/Comercios/{id}")
    public ResponseEntity< Comercio > getComercioById(@PathVariable(value = "id") String ComercioId)
            throws ResourceNotFoundException {
        Comercio Comercio = ComercioRepository.findById(ComercioId)
                .orElseThrow(() -> new ResourceNotFoundException("Comercio not found for this id :: " + ComercioId));
        return ResponseEntity.ok().body(Comercio);
    }

    @PostMapping("/Comercios")
    public Comercio createComercio(@RequestBody Comercio Comercio) {
        return ComercioRepository.save(Comercio);

    }

    @PutMapping("/Comercios/{id}")
    public ResponseEntity < Comercio > updateComercio(@PathVariable(value = "id") String ComercioId,
                                                  @RequestBody Comercio ComercioDetails) throws ResourceNotFoundException {
        Comercio Comercio = ComercioRepository.findById(ComercioId)
                .orElseThrow(() -> new ResourceNotFoundException("Comercio not found for this id :: " + ComercioId));

        Comercio.setDescuento(ComercioDetails.getDescuento());
        Comercio.setNombreComercio(ComercioDetails.getNombreComercio());
        final Comercio updatedComercio = ComercioRepository.save(Comercio);
        return ResponseEntity.ok(updatedComercio);
    }

    @DeleteMapping("/Comercios/{id}")
    public Map< String, Boolean > deleteComercio(@PathVariable(value = "id") String ComercioId)
            throws ResourceNotFoundException {
        Comercio Comercio = ComercioRepository.findById(ComercioId)
                .orElseThrow(() -> new ResourceNotFoundException("Comercio not found for this id :: " + ComercioId));

        ComercioRepository.delete(Comercio);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}