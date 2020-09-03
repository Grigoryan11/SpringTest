package am.basic.springTest.controller;


import am.basic.springTest.model.Phone;
import am.basic.springTest.model.exceptions.DuplicateDataException;
import am.basic.springTest.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/phone")
public class PhoneController {
    @Autowired
    private PhoneService phoneService;


    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/test1", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Phone> getAllByBody() {
        return phoneService.getAll();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(phoneService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.of(phoneService.findById(id));
    }

    @PostMapping(/*spasum a back@ */consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity add(@Valid @RequestBody Phone phone) throws DuplicateDataException {
        return ResponseEntity.ok(phoneService.save(phone));
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@PathVariable int id, @Valid @RequestBody Phone phone) throws DuplicateDataException {
        phone.setId(id);
        return ResponseEntity.ok(phoneService.update(phone));
    }



}

