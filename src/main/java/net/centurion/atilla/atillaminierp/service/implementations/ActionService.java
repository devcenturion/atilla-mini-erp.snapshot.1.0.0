package net.centurion.atilla.atillaminierp.service.implementations;

import net.centurion.atilla.atillaminierp.entities.Action;
import net.centurion.atilla.atillaminierp.repository.ActionRepository;

import net.centurion.atilla.atillaminierp.service.interfaces.IActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class ActionService implements IActionService{

    @Autowired
    private ActionRepository actionRepository;

    @Override
    public void save (Action action) {
        actionRepository.save(action);
    }

    public void update (String newUrl, String oldUrl) {
        Action action = actionRepository.findOne(oldUrl);
        action.setUrl(newUrl);
        actionRepository.save(action);
    }

    @Override
    public Iterable<Action> listAction ( ) {
        return actionRepository.findAll();
    }

    @Override
    public Page<Action> listAction (Pageable pageable) {
        return actionRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public void delete (String url) {

        actionRepository.delete(actionRepository.findOne(url));
    }

    @Transactional
    @Override
    public void delete (Collection<String> urls) {
        urls.forEach(s -> {
            actionRepository.delete(actionRepository.findOne(s));
        });
    }

    @Override
    public Page<Action> search (String url, Pageable pageable) {
        return actionRepository.findByUrlContaining(url, pageable);
    }

}
