package io.github.bibhasmondal1996.repositories;

import java.util.List;
import io.github.bibhasmondal1996.models.UserModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Long> {
	@Query(value = "SELECT * FROM users WHERE name=:name", nativeQuery = true)
	List<UserModel> findByName(@Param("name") String name);
	List<UserModel> findAll();
}
