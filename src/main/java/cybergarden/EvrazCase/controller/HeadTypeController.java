package cybergarden.EvrazCase.controller;

import cybergarden.EvrazCase.entity.HeadTypeEntity;
import cybergarden.EvrazCase.service.HeadTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/heads")
public class HeadTypeController {
    private final HeadTypeService headTypeService;

    @Autowired
    public HeadTypeController(HeadTypeService headTypeService) {
        this.headTypeService = headTypeService;
    }

    @PostMapping("/new")
    public ResponseEntity createHead(@RequestBody HeadTypeEntity head, @RequestParam Long headId) {
        try {
            return ResponseEntity.ok().body(headTypeService.createHead(head, headId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteHead(Long headId){
        try {
            headTypeService.deleteHead(headId);
            return ResponseEntity.ok().body("Вы успешно удалили тип состава.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllHeadTypes() {
        try {
            List<HeadTypeEntity> headTypes = headTypeService.getAllHeadTypes();
            return ResponseEntity.ok().body(headTypes);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
