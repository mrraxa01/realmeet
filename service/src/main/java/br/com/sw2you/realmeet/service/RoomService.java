package br.com.sw2you.realmeet.service;

import br.com.sw2you.realmeet.api.model.RoomDTO;
import br.com.sw2you.realmeet.domain.entity.Room;
import br.com.sw2you.realmeet.domain.repository.RoomRepository;
import br.com.sw2you.realmeet.exception.RoomNotFoundException;
import br.com.sw2you.realmeet.mapper.RoomMapper;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    public RoomDTO getRoom(Long id) {
        Objects.requireNonNull(id);

        Room room = roomRepository
            .findByIdAndActive(id, true)
            .orElseThrow(() -> new RoomNotFoundException("ROOM NOT FOUND: " + id));
        //return new RoomDTO().name(room.getName()).id(room.getId()).seats(room.getSeats());
        //com o mapstruct o código acima fica desnecessário
        return roomMapper.fromEntityToDto(room);
    }
}
