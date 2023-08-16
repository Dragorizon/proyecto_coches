package com.project.coches.controllers;

import com.project.coches.domain.dto.MarcaCocheDto;
import com.project.coches.domain.service.IMarcaCocheService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador rest de marca coche
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/marcas-coches")
public class MarcaCocheController {

    /**
     * Servicio de marca coche
     */
    private final IMarcaCocheService iMarcaCocheService;

    /**
     * Devuelve lista de marca coche
     * @return HTTPCode OK con lista de marca coche
     */
    @GetMapping()
    public ResponseEntity<List<MarcaCocheDto>> getAll() {
        return ResponseEntity.ok(iMarcaCocheService.getAll());

//        return ResponseEntity.status(HttpStatus.OK) //alternativa para crear response_entity
//                .body(iMarcaCocheService.getAll());

        //return new ResponseEntity<>(iMarcaCocheService.getAll(), HttpStatus.OK); alternativa para crear response_entity
    }

    /**
     * Devuelve una marca coche dada su id
     * @param id Id de la marca coche a buscar
     * @return HttpCode OK si la encuentra, HttpCode Not found si no la encuentra
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<MarcaCocheDto> getMarcaCoche(@PathVariable Integer id){
        return ResponseEntity.of(iMarcaCocheService.getMarcaCoche(id));
    }

    /**
     * Crea una nueva marca coche
     * @param marcaCocheDtoNew marca coche a crear
     * @return HttpCode Create si la guarda correctamente, HttpCode BAD REQUEST de lo contrario
     */
    @PostMapping()
    public ResponseEntity<MarcaCocheDto> save(@RequestBody MarcaCocheDto marcaCocheDtoNew) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body((iMarcaCocheService.save(marcaCocheDtoNew)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .build();

        }
    }

    /**
     * Actualiza un marca coche
     * @param marcaCocheDtoUpdate Marca coche actualizada
     * @return HttCode OK si la actualiza correctamente
     */
    @PatchMapping
    public ResponseEntity<MarcaCocheDto> update(@RequestBody MarcaCocheDto marcaCocheDtoUpdate){

        return ResponseEntity.of(iMarcaCocheService.update(marcaCocheDtoUpdate));

    }

    /**
     * Elimina un marca coche dado su Id
     * @param id Id de la marca coche a eliminar
     * @return HttpCode Ok si la elimina, HttpCode NOT FOUND si no existe
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iMarcaCocheService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
