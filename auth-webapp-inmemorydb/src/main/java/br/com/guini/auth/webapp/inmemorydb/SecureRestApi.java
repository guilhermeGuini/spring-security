package br.com.guini.auth.webapp.inmemorydb;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure/rest-api")
public class SecureRestApi {

    /**
     * It's necessary adding ROLE_ prefix
     * @return
     */
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getValue() {
        return ResponseEntity.ok("Secure Rest API");
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getValueAdmin() {
        return ResponseEntity.ok("ADMIN - Secure Rest API");
    }
}