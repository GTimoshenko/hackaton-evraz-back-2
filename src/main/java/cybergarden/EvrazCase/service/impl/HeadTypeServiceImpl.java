package cybergarden.EvrazCase.service.impl;

import cybergarden.EvrazCase.entity.HeadTypeEntity;
import cybergarden.EvrazCase.repo.HeadTypeRepo;
import cybergarden.EvrazCase.service.HeadTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeadTypeServiceImpl implements HeadTypeService {
    private final HeadTypeRepo headTypeRepo;

    @Autowired
    public HeadTypeServiceImpl(HeadTypeRepo headTypeRepo) {
        this.headTypeRepo = headTypeRepo;
    }

    @Override
    public HeadTypeEntity createHead(HeadTypeEntity head, Long headId) {
        return headTypeRepo.save(head);
    }

    @Override
    public void deleteHead(Long headId) {
        headTypeRepo.deleteById(headId);
    }

    @Override
    public List<HeadTypeEntity> getAllHeadTypes() {
        return headTypeRepo.findAll();
    }
}
