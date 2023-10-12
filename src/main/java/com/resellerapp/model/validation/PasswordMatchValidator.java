package com.resellerapp.model.validation;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class PasswordMatchValidator implements ConstraintValidator<PasswordValidator, Object> {
    private String first;
    private String second;
    private String message;


    @Override
    public void initialize(PasswordValidator constraintAnnotation) {
        this.first = constraintAnnotation.first();
        this.second = constraintAnnotation.second();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);
        Object password = beanWrapper.getPropertyValue(this.first);
        Object confirmPassword = beanWrapper.getPropertyValue(this.second);

        boolean isValid = Objects.equals(password, confirmPassword);

        if(!isValid) {
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(second)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }
        return isValid;
    }
}
