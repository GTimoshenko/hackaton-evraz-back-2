package cybergarden.EvrazCase.service;

import cybergarden.EvrazCase.entity.HeadTypeEntity;

import java.util.List;

public interface HeadTypeService {
    HeadTypeEntity createHead(HeadTypeEntity head, Long headId);
    void deleteHead(Long headId);

    List<HeadTypeEntity> getAllHeadTypes();
}
