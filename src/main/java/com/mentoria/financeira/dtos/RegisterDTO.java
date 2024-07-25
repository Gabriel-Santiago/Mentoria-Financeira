package com.mentoria.financeira.dtos;

import com.mentoria.financeira.enums.Role;

public record RegisterDTO(
        String login,
        String senha,
        Role role
) {
}
