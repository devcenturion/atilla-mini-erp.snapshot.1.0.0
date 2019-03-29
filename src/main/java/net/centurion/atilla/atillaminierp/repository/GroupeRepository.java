package net.centurion.atilla.atillaminierp.repository;

import net.centurion.atilla.atillaminierp.entities.Groupe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface GroupeRepository extends CrudRepository<Groupe, String>{

    public Page<Groupe> findByNomContainingOrDescriptionContaining (String mot, String mot1, Pageable pageable);
}
