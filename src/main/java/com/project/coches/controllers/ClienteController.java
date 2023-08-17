package com.project.coches.controllers;

import com.project.coches.domain.dto.ClienteDto;
import com.project.coches.domain.dto.ResponseClienteDto;
import com.project.coches.domain.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    /**
     * Servicio de clientes
     */
    private final IClienteService iClienteService;

    /**
     * Devuelve lista de clientes
     * @return HTTPCode OK con lista de clientes
     */
    @GetMapping()
    public ResponseEntity<List<ClienteDto>> getAll() {
        return ResponseEntity.ok(iClienteService.getAll());

//        return ResponseEntity.status(HttpStatus.OK) //alternativa para crear response_entity
//                .body(iMarcaCocheService.getAll());

        //return new ResponseEntity<>(iMarcaCocheService.getAll(), HttpStatus.OK); alternativa para crear response_entity
    }

    /**
     * Devuelve un cliente dada su id
     * @param carnetId Id del cliente a buscar
     * @return HttpCode OK si la encuentra, HttpCode Not found si no la encuentra
     */
    @GetMapping(path = "/{carnetId}")
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable String carnetId){
        return ResponseEntity.of(iClienteService.getClienteByCarnetId(carnetId));
    }

    /**
     * Devuelve un cliente dado su email
     * @param email email del cleinte a buscar
     * @return HttpCode OK si la encuentra, HttpCode Not found si no la encuentra
     */
    @GetMapping(path = "/email/{email}")
    public ResponseEntity<ClienteDto> getClienteByEmail(@PathVariable String email){
        return ResponseEntity.of(iClienteService.getClienteByEmail(email));
    }


    /**
     * Crea un nuevo cliente
     * @param clienteDtoNew cliente a crear
     * @return HttpCode Create si la guarda correctamente, HttpCode BAD REQUEST de lo contrario
     */
    @PostMapping()
    public ResponseEntity<ResponseClienteDto> save(@RequestBody ClienteDto clienteDtoNew) {
//        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body((iClienteService.save(clienteDtoNew)));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(new ResponseClienteDto(e.getMessage()));
//
//        }
    }


    /**
     * Actualiza un cliente
     * @param clienteDtoUpdate cliente actualizada
     * @return HttCode OK si la actualiza correctamente
     */
    @PatchMapping
    public ResponseEntity<ClienteDto> update(@RequestBody ClienteDto clienteDtoUpdate){

        return ResponseEntity.of(iClienteService.update(clienteDtoUpdate));

    }

    /**
     * Elimina un cliente dado su carnetID
     * @param carnetId carnetId del cliente a eliminar
     * @return HttpCode Ok si la elimina, HttpCode NOT FOUND si no existe
     */
    @DeleteMapping(path = "/{carnetId}")
    public ResponseEntity<Boolean> delete(@PathVariable String carnetId){
        return new ResponseEntity<>(this.iClienteService.delete(carnetId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
