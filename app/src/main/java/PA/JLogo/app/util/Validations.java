package PA.JLogo.app.util;

import org.gradle.internal.impldep.jakarta.xml.bind.ValidationException;
import org.gradle.internal.impldep.org.jetbrains.annotations.Contract;

import javax.annotation.Nullable;

public class Validations {

    @Contract("null -> fail")
    public static void validateTranslation(@Nullable Coordinate2D c) throws ValidationException {
        if (c == null)
            throw new ValidationException("");
    }
}
