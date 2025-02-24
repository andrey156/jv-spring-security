package mate.academy.spring.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {
    private static final Pattern PATTERN = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]"
            + "+(\\\\\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\\\\\."
            + "[A-Za-z0-9-]+)*(\\\\\\\\.[A-Za-z]{2,})$");

    @Override
    public boolean isValid(String email, ConstraintValidatorContext
            constraintValidatorContext) {
        if (email == null) {
            return false;
        }
        Matcher matcher = PATTERN.matcher(email);
        return matcher.matches();
    }
}
