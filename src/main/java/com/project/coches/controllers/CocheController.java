package com.project.coches.controllers;

import com.project.coches.domain.dto.ClienteDto;
import com.project.coches.domain.dto.CocheDto;
import com.project.coches.domain.useCase.ICocheService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/coches")
public class CocheController {

    private final ICocheService iCocheService;


    @GetMapping()
    public ResponseEntity<List<CocheDto>> getAll() {
        return ResponseEntity.ok(iCocheService.getAll());

//        return ResponseEntity.status(HttpStatus.OK) //alternativa para crear response_entity
//                .body(iMarcaCocheService.getAll());

        //return new ResponseEntity<>(iMarcaCocheService.getAll(), HttpStatus.OK); alternativa para crear response_entity
    }

    @GetMapping(path = "/marca-coche/{marcaCocheId}")
    public ResponseEntity<List<CocheDto>> getByIdMarcaCoche(@PathVariable Integer marcaCocheId){
        return ResponseEntity.ok(iCocheService.getByIdMarcaCoche(marcaCocheId));
    }

    @GetMapping(path = "/precio/{precioCoche}")
    public ResponseEntity<List<CocheDto>> getCochesByPriceLessThan(@PathVariable Double precioCoche){
        return ResponseEntity.ok(iCocheService.getCochesByPriceLessThan(precioCoche));
    }

    @GetMapping(path = "/{idCoche}")
    public ResponseEntity<CocheDto> getCoche(@PathVariable Integer idCoche){
        return ResponseEntity.of(iCocheService.getCoche(idCoche));
    }


    @PostMapping()
    public ResponseEntity<CocheDto> save(@RequestBody CocheDto cocheDtoNew) {
//        try {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body((iCocheService.save(cocheDtoNew)));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(new ResponseClienteDto(e.getMessage()));
//
//        }
    }


    @PatchMapping
    public ResponseEntity<CocheDto> update(@RequestBody CocheDto cocheDtoUpdate){

        return ResponseEntity.of(iCocheService.update(cocheDtoUpdate));

    }

    @DeleteMapping(path = "/{cocheId}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer cocheId){
        return new ResponseEntity<>(this.iCocheService.delete(cocheId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
