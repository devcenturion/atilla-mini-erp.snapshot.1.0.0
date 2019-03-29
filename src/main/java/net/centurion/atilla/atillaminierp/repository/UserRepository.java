package net.centurion.atilla.atillaminierp.repository;

import net.centurion.atilla.atillaminierp.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String>{

    public Page<User> findAllByFirstNameContainingOrLastNameContainingOrNumeroTelephoneContainingOrCniContainingOrDateNaissanceContainingOrLoginContainingOrEmailContainingOrAddressContainingOrSexeContaining (String mot, String mot1, String mot2, String mot3, String mot4, String mot5, String mot6, String mot7, String mot8, Pageable pageable);

    Page<User> findAllBySexe (String sexe, Pageable pageable);

    Page<User> findAllByAddressContaining (String address, Pageable pageable);

    Page<User> findAllByCniContaining (String cni, Pageable pageable);

    Page<User> findAllByNumeroTelephoneContaining (String phone, Pageable pageable);

    Page<User> findAllByLastNameContaining (String lastName, Pageable pageable);

    Page<User> findAllByFirstNameContaining (String firstName, Pageable pageable);
}
