package edu.mum.bloodbankrest.validation;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Size;
import java.lang.annotation.*;

@NotEmpty( )
@Size
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@ReportAsSingleViolation
@Documented
public @interface EmptyOrSize {
	String message() default "Validation for an optional numeric field failed.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {  };
	
	@OverridesAttribute(constraint=Size.class, name="min")
    int min() default 10;

    @OverridesAttribute(constraint=Size.class, name="max")
    int max() default 15;
    
	
}
