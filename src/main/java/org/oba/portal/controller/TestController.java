package org.oba.portal.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {
    @GetMapping("/ping")	//	standarduser
    public String ping() {
        return "OK!";
    }

    @PreAuthorize("hasAnyRole('USERMAN', 'GROUPUSERMAN')")	//	admin
    @GetMapping("/authping")
    public String securedPing() {
        return "OK!!";
    }

    @PreAuthorize("hasRole('ROLEMAN')")	//	superAdmin
    @GetMapping("/superping")
    public String securedAuthPing() {
        return "OK!!!";
    }
}
