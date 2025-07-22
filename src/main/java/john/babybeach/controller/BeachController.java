package john.babybeach.controller;


import john.babybeach.dto.AddBeach;
import john.babybeach.model.Beach;
import john.babybeach.service.BeachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/beaches")
@RequiredArgsConstructor
public class BeachController {

    private final BeachService beachService;

    @GetMapping("/{beachId}")
    public ResponseEntity<Beach> getBeachById(String id) {
        return ResponseEntity.ok(beachService.getBeachById(id));
    }

    @GetMapping("/All")
    public ResponseEntity<Beach> getAllBeaches(String name) {
        return ResponseEntity.ok(beachService.getAllBeaches(name));
    }

    @PostMapping("/add")
    public ResponseEntity<Beach> addBeach(@RequestBody AddBeach beachDto) {
        return ResponseEntity.ok(beachService.getFromDTO(beachDto));
    }
}
