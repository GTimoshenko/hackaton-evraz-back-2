package cybergarden.EvrazCase.service;

import cybergarden.EvrazCase.entity.CompanyEntity;

import java.util.List;

public interface CompanyService {
    CompanyEntity createCompany(CompanyEntity company, Long companyId);

    void deleteCompany(Long companyId);

    List<CompanyEntity> getAllCompanies();
}
