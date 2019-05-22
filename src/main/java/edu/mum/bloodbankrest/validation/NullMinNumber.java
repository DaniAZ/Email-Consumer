package edu.mum.bloodbankrest.validation;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import java.lang.annotation.*;


@NotNull
@Min(value = 0)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
@SupportedValidationTarget(ValidationTarget.ANNOTATED_ELEMENT)
@ReportAsSingleViolation
public @interface NullMinNumber {

    String message() default "Number must have minimum value";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {  };

    @OverridesAttribute(constraint = Min.class, name = "value")
    long value();
}

