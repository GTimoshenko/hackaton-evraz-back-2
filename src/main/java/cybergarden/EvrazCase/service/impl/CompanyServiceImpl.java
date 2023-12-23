package cybergarden.EvrazCase.service.impl;

import cybergarden.EvrazCase.entity.CompanyEntity;
import cybergarden.EvrazCase.repo.CompanyRepo;
import cybergarden.EvrazCase.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepo companyRepo;

    @Autowired
    public CompanyServiceImpl(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override
    public CompanyEntity createCompany(CompanyEntity company, Long companyId) {
        return  companyRepo.save(company);
    }

    @Override
    public void deleteCompany(Long companyId) {
        companyRepo.deleteById(companyId);
    }

    @Override
    public List<CompanyEntity> getAllCompanies(){
        return companyRepo.findAll();
    }
}
