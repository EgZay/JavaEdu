package ru.noorsoft.javaeducation;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends CrudRepository<User, Long> {
    User getOne(Long id);
}