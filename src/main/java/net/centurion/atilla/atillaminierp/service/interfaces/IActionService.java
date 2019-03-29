package net.centurion.atilla.atillaminierp.service.interfaces;

import net.centurion.atilla.atillaminierp.entities.Action;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.Collection;

public interface IActionService{
    void save (Action action);

    Iterable<Action> listAction ( );

    Page<Action> listAction (Pageable pageable);

    @Transactional
    void delete (String url);

    @Transactional
    void delete (Collection<String> urls);

    Page<Action> search (String url, Pageable pageable);
}
