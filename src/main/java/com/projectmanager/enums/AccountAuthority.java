package com.projectmanager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountAuthority {
    ROLE_GUEST("ROLE_GUEST"),
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_SUPER_ADMIN("ROLE_SUPER_ADMIN");

    private String authority;
}
