package sb.monsterBrewer.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sb.monsterBrewer.exceptions.MonsterNotFoundException;
import sb.monsterBrewer.models.Monster;
import sb.monsterBrewer.repositories.MonsterRepository;

@RestController
class MonsterController {

    private final MonsterRepository repository;

    MonsterController(MonsterRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/monsters")
    List<Monster> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/monsters")
    Monster newMonster(@RequestBody Monster newMonster) {
        return repository.save(newMonster);
    }

    // Single item

    @GetMapping("/monsters/{id}")
    Monster one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new MonsterNotFoundException(id));
    }

    @PutMapping("/monsters/{id}")
    Monster replaceMonster(@RequestBody Monster newMonster, @PathVariable Long id) {

        return repository.findById(id)
                .map(monster -> {
                    monster.setName(newMonster.getName());
                    monster.setRole(newMonster.getRole());
                    return repository.save(monster);
                })
                .orElseGet(() -> {
                    newMonster.setId(id);
                    return repository.save(newMonster);
                });
    }

    @DeleteMapping("/monsters/{id}")
    void deleteMonster(@PathVariable Long id) {
        repository.deleteById(id);
    }
}