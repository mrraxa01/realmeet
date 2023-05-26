package br.com.sw2you.realmeet.validator;

import static br.com.sw2you.realmeet.validator.ValidatorConstants.*;
import static br.com.sw2you.realmeet.validator.ValidatorUtils.*;
import static java.util.Objects.isNull;

import java.time.OffsetDateTime;
import java.util.Objects;

import org.springframework.stereotype.Component;
import br.com.sw2you.realmeet.api.model.AllocationDTO;
import br.com.sw2you.realmeet.api.model.CreateAllocationDTO;
import br.com.sw2you.realmeet.api.model.CreateRoomDTO;
import br.com.sw2you.realmeet.api.model.UpdateRoomDTO;
import br.com.sw2you.realmeet.domain.repository.AllocationRepository;
import br.com.sw2you.realmeet.domain.repository.RoomRepository;

@Component
public class AllocationValidator {
    private final AllocationRepository allocationRepository;

    public AllocationValidator(AllocationRepository allocationRepository) {

        this.allocationRepository = allocationRepository;
    }

    public void validate(CreateAllocationDTO createAllocationDTO) {
        var validationErrors = new ValidationErrors();

        validateSubject(createAllocationDTO.getSubject(), validationErrors);
        validateEmployeeName(createAllocationDTO.getEmployeeName(), validationErrors);
        validateEmployeeEmail(createAllocationDTO.getEmployeeEmail(),validationErrors);
        validateDates(createAllocationDTO.getStartAt(),createAllocationDTO.getEndAt(),validationErrors);

        throwOnError(validationErrors);
    }


    private boolean validateSubject(String subject, ValidationErrors validationErrors) {
        return (
            validateRequired(subject, ALLOCATION_SUBJECT, validationErrors) &&
            validateMaxLength(subject, ALLOCATION_SUBJECT, ALLOCATION_SUBJECT_MAX_LENGTH, validationErrors)
        );
    }
    private boolean validateEmployeeName(String employeeName, ValidationErrors validationErrors) {
        return (
                validateRequired(employeeName, ALLOCATION_EMPLOYEE_NAME, validationErrors) &&
                        validateMaxLength(employeeName, ALLOCATION_EMPLOYEE_NAME, ALLOCATION_EMPLOYEE_NAME_MAX_LENGTH, validationErrors)
        );
    }
    private boolean validateEmployeeEmail(String employeeEmail, ValidationErrors validationErrors) {
        return (
                validateRequired(employeeEmail, ALLOCATION_EMPLOYEE_EMAIL, validationErrors) &&
                        validateMaxLength(employeeEmail, ALLOCATION_EMPLOYEE_EMAIL, ALLOCATION_EMPLOYEE_EMAIL_LENGTH, validationErrors)
        );
    }

    private void validateDates(OffsetDateTime startAt, OffsetDateTime endAt, ValidationErrors validationErrors){
        validateDatesPresent(startAt,endAt,validationErrors);
    }

    private boolean validateDatesPresent(OffsetDateTime startAt, OffsetDateTime endAt, ValidationErrors validationErrors){
       return (
        validateRequired(startAt, ALLOCATION_START_AT, validationErrors) &&
        validateRequired(endAt, ALLOCATION_END_AT, validationErrors)
    );
    }
}
