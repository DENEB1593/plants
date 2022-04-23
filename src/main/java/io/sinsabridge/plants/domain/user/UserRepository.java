package io.sinsabridge.plants.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUserNo(Long userNo);

    public Optional<User> findById(String id);

    public int deleteByUserNo(Long userNo);

    public int deleteById(String userId);
}
