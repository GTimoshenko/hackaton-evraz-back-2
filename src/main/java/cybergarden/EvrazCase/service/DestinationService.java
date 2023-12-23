package cybergarden.EvrazCase.service;


import cybergarden.EvrazCase.entity.DestinationEntity;
import cybergarden.EvrazCase.exception.destination.DestinationNotFoundByIdException;

import java.util.List;

public interface DestinationService {
    DestinationEntity createDestination(DestinationEntity destination, Long destId);

    void deleteDestination(Long destId) throws DestinationNotFoundByIdException;

    List<DestinationEntity> getAllDestinations();
}
