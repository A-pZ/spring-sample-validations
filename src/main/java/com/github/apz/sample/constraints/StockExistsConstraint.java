package com.github.apz.sample.constraints;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RUNTIME)
@Target({FIELD, METHOD})
@Constraint(validatedBy = StockExistsValidator.class)
public @interface StockExistsConstraint {
	String message() default "在庫がありません";
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
