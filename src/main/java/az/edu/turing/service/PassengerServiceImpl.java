package az.edu.turing.service;

import az.edu.turing.domain.dao.PassengerDao;
import az.edu.turing.domain.entities.PassengerEntity;
import az.edu.turing.exception.AlreadyExistsException;
import az.edu.turing.exception.DatabaseException;
import az.edu.turing.exception.NotFoundException;
import az.edu.turing.mapper.PassengerMapper;
import az.edu.turing.model.dto.PassengerDto;
import az.edu.turing.model.dto.request.CreatePassengerRequest;

import java.util.Optional;

public class PassengerServiceImpl implements PassengerService {

    private final PassengerDao passengerDao;
    private final PassengerMapper passengerMapper;

    public PassengerServiceImpl(PassengerDao passengerDao, PassengerMapper passengerMapper) {
        this.passengerDao = passengerDao;
        this.passengerMapper = passengerMapper;
    }

    @Override
    public PassengerDto createPassenger(CreatePassengerRequest request) throws DatabaseException {
        Optional<PassengerEntity> existingPassenger = passengerDao.getAll().stream()
                .filter(p -> p.getId().equals(request.getId()))
                .findFirst();

        if (existingPassenger.isPresent()) {
            throw new AlreadyExistsException("Student already exists with pin: " + request.getId());
        }

        PassengerEntity save = passengerDao.save(new PassengerEntity(
                request.getId(),
                request.getFirstName(),
                request.getLastName()
        ));
        return passengerMapper.toDto(save);

    }

    @Override
    public PassengerDto findById(long id) throws DatabaseException {
        return passengerDao.getById(id)
                .map(passengerMapper::toDto)
                .orElseThrow(() -> new NotFoundException("id " + id + " not found"));

    }

    @Override
    public boolean existById(long id) throws DatabaseException {
        return passengerDao.existById(id);
    }
}
