package cybergarden.EvrazCase.service.impl;

import cybergarden.EvrazCase.entity.DestinationEntity;
import cybergarden.EvrazCase.exception.destination.DestinationNotFoundByIdException;
import cybergarden.EvrazCase.repo.DestRepo;
import cybergarden.EvrazCase.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationServiceImpl implements DestinationService {

    private final DestRepo destRepo;

    @Autowired
    public DestinationServiceImpl(DestRepo destRepo) {
        this.destRepo = destRepo;
    }

    @Override
    public DestinationEntity createDestination(DestinationEntity dest, Long destId) {
        return destRepo.save(dest);
    }

    @Override
    public void deleteDestination(Long destId) throws DestinationNotFoundByIdException {
        DestinationEntity dest = destRepo.findById(destId).orElse(null);
        if(dest == null){
            throw new DestinationNotFoundByIdException("Точки назначения с таким ID не найдено.");
        }
        destRepo.deleteById(destId);
    }

    @Override
    public List<DestinationEntity> getAllDestinations() {
        return destRepo.findAll();
    }

}
