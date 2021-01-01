package de.elmasconsulting.ecmanagement.repository;

import de.elmasconsulting.ecmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}
