package br.com.sw2you.realmeet.utils;

import static br.com.sw2you.realmeet.util.DateUtils.*;

import br.com.sw2you.realmeet.util.DateUtils;
import java.time.OffsetDateTime;

public final class TestConstants {
    public static final Long DEFAULT_ROOM_ID = 1L;
    public static final String DEFAULT_ROOM_NAME = "ROOM_A";
    public static final int DEFAULT_ROOM_SEATS = 6;

    public static final String DEFAULT_ALLOCATION_SUBJECT = "Some Subject";
    public static final String DEFAULT_EMPLOYEE_NAME = "John Doe";
    public static final String DEFAULT_EMPLOYEE_EMAIL = "john@email.com";
    public static final OffsetDateTime DEFAULT_ALLOCATION_START_AT = now().plusDays(1);
    public static final OffsetDateTime DEFAULT_ALLOCATION_END_AT = DEFAULT_ALLOCATION_START_AT.plusHours(1);

    private TestConstants() {}
}
