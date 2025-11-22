package dev.damianlis.bookrental.identity.rest;

import dev.damianlis.bookrental.identity.IdentityFacade;
import dev.damianlis.bookrental.identity.api.IdentityViewDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/identities")
class IdentityRestController {

    private final IdentityFacade identityFacade;

    IdentityRestController(IdentityFacade identityFacade) {
        this.identityFacade = identityFacade;
    }

    @PostMapping
    ResponseEntity<Void> postIdentity(
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) {
        identityFacade.registerIdentity(email, password);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    ResponseEntity<IdentityViewDTO> getIdentity(
            @PathVariable("id") String identityId
    ) {
        IdentityViewDTO identityViewDTO = identityFacade.getIdentity(identityId);
        return ResponseEntity.ok(identityViewDTO);
    }

}
