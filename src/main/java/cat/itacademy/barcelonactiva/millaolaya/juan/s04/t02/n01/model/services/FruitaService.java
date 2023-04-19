package cat.itacademy.barcelonactiva.millaolaya.juan.s04.t02.n01.model.services;

import cat.itacademy.barcelonactiva.millaolaya.juan.s04.t02.n01.model.domain.Fruita;

import java.util.List;
import java.util.Optional;

public interface FruitaService {
    public List<Fruita> findAll();
    public Optional<Fruita> findById(int id);
    public Fruita save(Fruita fruita);
    public void deleteById(int id);
}
