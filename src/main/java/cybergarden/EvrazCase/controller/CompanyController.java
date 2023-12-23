package cybergarden.EvrazCase.controller;

import cybergarden.EvrazCase.entity.CompanyEntity;
import cybergarden.EvrazCase.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/new")
    public ResponseEntity createCompany(@RequestBody CompanyEntity company, @RequestParam Long companyId){
        try {
            return ResponseEntity.ok().body(companyService.createCompany(company, companyId));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping()
    public ResponseEntity deleteCompany(@RequestParam Long companyId) {
        try {
            companyService.deleteCompany(companyId);
            return ResponseEntity.ok().body("Компания успешно удалена.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllCompanies() {
        try {
            List<CompanyEntity> companies = companyService.getAllCompanies();
            return ResponseEntity.ok().body(companies);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
