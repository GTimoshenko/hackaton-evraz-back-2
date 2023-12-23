package cybergarden.EvrazCase.controller;


import cybergarden.EvrazCase.entity.DestinationEntity;
import cybergarden.EvrazCase.exception.destination.DestinationNotFoundByIdException;
import cybergarden.EvrazCase.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {
    private final DestinationService destinationService;

    @Autowired
    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @PostMapping("/new")
    public ResponseEntity createDestination(@RequestBody DestinationEntity dest, @RequestParam Long destId) {
        try {
            return ResponseEntity.ok().body(destinationService.createDestination(dest, destId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping()
    public ResponseEntity deleteDestination(@RequestParam Long destId) {
        try {
            destinationService.deleteDestination(destId);
            return ResponseEntity.ok().body("Вы успешно удалили точку назначения.");
        } catch (DestinationNotFoundByIdException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllDestinations() {
        try {
            List<DestinationEntity> destinations = destinationService.getAllDestinations();
            return ResponseEntity.ok().body(destinations);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
