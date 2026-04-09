package Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.User;

@Repository
public interface  UserRepo extends JpaRepository<User,Integer> {

    User findByUsername(String Username);
}
