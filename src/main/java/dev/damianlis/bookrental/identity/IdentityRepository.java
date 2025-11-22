package dev.damianlis.bookrental.identity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface IdentityRepository extends JpaRepository<Identity, String> {

    Optional<Identity> findByEmail(Email email);
}
