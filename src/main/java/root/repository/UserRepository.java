package root.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import root.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
User findByEmail(String email);
}
