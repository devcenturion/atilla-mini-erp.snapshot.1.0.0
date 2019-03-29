package net.centurion.atilla.atillaminierp.repository;


import net.centurion.atilla.atillaminierp.entities.Action;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface ActionRepository extends CrudRepository<Action, String>{
    Page<Action> findAll (Pageable pageable);

    Page<Action> findByUrlContaining (Pageable pageable);

    Page<Action> findByUrlContaining (String url, Pageable pageable);


}
