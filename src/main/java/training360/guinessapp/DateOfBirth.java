package training360.guinessapp;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = DateOfBirthValidator.class)
public @interface DateOfBirth {

    String message() default "must be in the past";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
