package dev.damianlis.bookrental.identity;

record IdentityView(
        String identityId,
        Email email,
        IdentityStatus identityStatus
) {
}
