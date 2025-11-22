package dev.damianlis.bookrental.identity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
record Email(
        @Column(name = "email_value")
        String value
) {

    Email(String value) {
        // email pattern validation
        this.value = value;
    }
}
