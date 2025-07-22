package john.babybeach.controller;


import john.babybeach.dto.AddBeach;
import john.babybeach.model.Beach;
import john.babybeach.service.BeachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/beaches")
@RequiredArgsConstructor
public class BeachController {

    private final BeachService beachService;

    @GetMapping("/{beachId}")
    public ResponseEntity<Beach> getBeachById(@PathVariable String beachId) {
        Beach beach = beachService.getBeachById(beachId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Stranden finns inte"));
        return ResponseEntity.ok(beach);
    }
    @GetMapping(value = "/all")
    public ResponseEntity<List<Beach>> getAllBeaches() {
        return ResponseEntity.ok(beachService.getAllBeaches());
    }

    @PostMapping("/add")
    public ResponseEntity<Beach> addBeach(@RequestBody AddBeach beachDto) {
        return ResponseEntity.ok(beachService.getFromDTO(beachDto));
    }
}
