package dev.damianlis.bookrental.identity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "identities")
class Identity {

    @Id
    private String identityId;
    @Enumerated(EnumType.STRING)
    private IdentityStatus identityStatus;
    @Embedded
    private Email email;
    private String password;

    Identity(Email email, String password) {
        this.identityId = UUID.randomUUID().toString();
        this.identityStatus = IdentityStatus.ACTIVE;
        this.email = email;
        this.password = password;
    }

    private Identity() {

    }

    String getIdentityId() {
        return identityId;
    }

    IdentityStatus getIdentityStatus() {
        return identityStatus;
    }

    Email getEmail() {
        return email;
    }

    String getPassword() {
        return password;
    }

    private void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    private void setIdentityStatus(IdentityStatus identityStatus) {
        this.identityStatus = identityStatus;
    }

    private void setEmail(Email email) {
        this.email = email;
    }

    private void setPassword(String password) {
        this.password = password;
    }
}
