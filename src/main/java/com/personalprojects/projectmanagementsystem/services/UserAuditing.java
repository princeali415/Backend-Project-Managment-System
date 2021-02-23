package com.personalprojects.projectmanagementsystem.services;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class UserAuditing implements AuditorAware<String>
{
    /**
     * The current user
     *
     * @return Optional(String) of current user
     */
    @Override
    public Optional<String> getCurrentAuditor()
    {
        String uname;
        uname = "llama";
        return Optional.of(uname);
    }
}
