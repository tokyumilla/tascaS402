package cat.itacademy.barcelonactiva.millaolaya.juan.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.millaolaya.juan.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.millaolaya.juan.s04.t02.n01.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http:localhost:8080")
@RestController("/fruita")
public class FruitaController {

    @Autowired
    FruitaRepository fruitaRepository;

    @GetMapping("getAll")
    public ResponseEntity <List<Fruita>> getAllFruites (){
        try {
            List<Fruita> fruites = fruitaRepository.findAll();

            if (fruites.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(fruites,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getOne (@PathVariable("id") int id) {
        Optional<Fruita> fruitaData = fruitaRepository.findById(id);

        if (fruitaData.isPresent()) {
            return new ResponseEntity<>(fruitaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }








}
