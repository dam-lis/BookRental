package dev.damianlis.bookrental.identity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

class IdentityService {

    private final IdentityRepository identityRepository;
    private final PasswordEncoder passwordEncoder;

    IdentityService(IdentityRepository identityRepository, PasswordEncoder passwordEncoder) {
        this.identityRepository = identityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    void registerIdentity(Email email, String password) {
        validateRegistration(email);
        String encodedPassword = passwordEncoder.encode(password);
        Identity identity = new Identity(email, encodedPassword);
        identityRepository.save(identity);
    }

    private void validateRegistration(Email email) {
        Optional<Identity> identity = identityRepository.findByEmail(email);
        if (identity.isPresent()) {
            throw new IllegalStateException("Email exists");
        }
    }

    @Transactional(readOnly = true)
    IdentityView getIdentity(String identityId) {
        Identity identity = identityRepository.findById(identityId)
                .orElseThrow();
        return new IdentityView(
                identity.getIdentityId(),
                identity.getEmail(),
                identity.getIdentityStatus()
        );
    }

}
