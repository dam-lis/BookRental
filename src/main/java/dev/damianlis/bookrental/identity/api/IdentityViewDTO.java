package dev.damianlis.bookrental.identity.api;

public record IdentityViewDTO(
        String identityId,
        String email,
        IdentityStatusDTO identityStatus
) {
}
