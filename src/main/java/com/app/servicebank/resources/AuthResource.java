package com.app.servicebank.resources;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.app.servicebank.dto.CpfDTO;
import com.app.servicebank.dto.EmailDTO;
import com.app.servicebank.security.JWTUtil;
import com.app.servicebank.security.UserSS;
import com.app.servicebank.services.AuthService;
import com.app.servicebank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService service;

    @RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        UserSS user = UserService.authenticated();
        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("access-control-expose-headers", "Authorization");
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/forgot", method = RequestMethod.POST)
    public ResponseEntity<Void> forgot(@Valid @RequestBody CpfDTO cpfDTO) {
        service.sendNewPassword(cpfDTO.getCpf());
        return ResponseEntity.noContent().build();
    }
}
