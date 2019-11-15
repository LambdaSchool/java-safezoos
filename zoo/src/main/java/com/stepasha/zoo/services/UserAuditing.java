package com.stepasha.zoo.services;

import com.stepasha.zoo.logging.Loggable;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Loggable
@Component
public class UserAuditing implements AuditorAware<String>
{
    @Override
    public Optional<String> getCurrentAuditor()
    {
        String uname;

        uname = "SYSTEM";

        return Optional.of(uname);
    }
}
