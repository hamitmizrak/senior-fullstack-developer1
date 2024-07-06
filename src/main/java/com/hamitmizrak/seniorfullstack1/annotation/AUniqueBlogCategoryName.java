package com.hamitmizrak.seniorfullstack1.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueBlogCategoryValidation.class})
public @interface AUniqueBlogCategoryName {
    String message() default "{blog.category.unique.validation.constraints.NotNull.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}