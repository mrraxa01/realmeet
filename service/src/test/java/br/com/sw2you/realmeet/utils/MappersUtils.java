package br.com.sw2you.realmeet.utils;

import br.com.sw2you.realmeet.mapper.AllocationMapper;
import br.com.sw2you.realmeet.mapper.RoomMapper;
import org.mapstruct.factory.Mappers;

public final class MappersUtils {

    private MappersUtils() {}

    public static RoomMapper roomMapper() {
        return Mappers.getMapper(RoomMapper.class);
    }

    public static AllocationMapper allocationMapper() {
        return Mappers.getMapper(AllocationMapper.class);
    }
}
