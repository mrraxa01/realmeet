package br.com.sw2you.realmeet.controller;

import static java.util.concurrent.CompletableFuture.supplyAsync;

import br.com.sw2you.realmeet.api.facade.RoomsApi;
import br.com.sw2you.realmeet.api.model.RoomDTO;
import br.com.sw2you.realmeet.service.RoomService;
import br.com.sw2you.realmeet.util.ResponseEntityUtils;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController implements RoomsApi {
    private final Executor controllerExecutor;
    private final RoomService roomService;

    public RoomController(Executor controllerExecutor, RoomService roomService) {
        this.controllerExecutor = controllerExecutor;
        this.roomService = roomService;
    }

    @Override
    public CompletableFuture<ResponseEntity<RoomDTO>> getRoom(Long id) {
        // return CompletableFuture.supplyAsync(() -> ResponseEntity.ok(roomService.getRoom(id)));

        // return supplyAsync(()-> roomService.getRoom(id), controllerExecutor).thenApply(r -> ResponseEntity.ok(r));

        // o código acima vai executar assincronamente "supplyAsync" o getRoom através da thread do controllerExecutor
        // quando acabar a execução será retornado uma room 'r' (r é aleatório)  'thenApply' faz esperar,
        // r será retornado dentro do response entity
        //abaixo o código refatorado com reference methods
        return supplyAsync(() -> roomService.getRoom(id), controllerExecutor).thenApply(ResponseEntityUtils::ok);
    }
}
