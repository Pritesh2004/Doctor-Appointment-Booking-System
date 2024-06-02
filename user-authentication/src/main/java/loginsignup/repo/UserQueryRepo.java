package loginsignup.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import loginsignup.model.UserQuery;

public interface UserQueryRepo extends JpaRepository<UserQuery, Long>{

	 

}
