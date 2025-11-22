package dev.damianlis.bookrental.identity;

import dev.damianlis.bookrental.identity.api.IdentityStatusDTO;
import dev.damianlis.bookrental.identity.api.IdentityViewDTO;

public class IdentityFacade {

    private final IdentityService identityService;

    IdentityFacade(IdentityService identityService) {
        this.identityService = identityService;
    }

    public void registerIdentity(String email, String password) {
        identityService.registerIdentity(new Email(email), password);
    }

    public IdentityViewDTO getIdentity(String identityId) {
        IdentityView identityView = identityService.getIdentity(identityId);
        return new IdentityViewDTO(
                identityView.identityId(),
                identityView.email().value(),
                IdentityStatusDTO.valueOf(identityView.identityStatus().name())
        );
    }
}
