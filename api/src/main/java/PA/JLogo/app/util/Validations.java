package src.main.java.PA.JLogo.app.util;

import org.gradle.internal.impldep.jakarta.xml.bind.ValidationException;
import org.gradle.internal.impldep.org.jetbrains.annotations.Contract;

import javax.annotation.Nullable;

public class Validations {

    @Contract("null -> fail")
    public static void validateSyntax(@Nullable String token, String expectedToken) throws ValidationException {
        if (token == null)
            throw new ValidationException("Token was null");
        if (!token.equals(expectedToken))
            throw new ValidationException("");
    }

}
