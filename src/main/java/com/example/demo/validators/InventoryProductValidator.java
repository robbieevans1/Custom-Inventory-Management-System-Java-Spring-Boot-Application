package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class InventoryProductValidator implements ConstraintValidator<ValidInventory, Product> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidInventory constraintAnnotation) {
        //ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {
        if (product.getInv() > product.getMaxInv()){
            constraintValidatorContext.buildConstraintViolationWithTemplate("Fix Inventory, It's greater than max value").addConstraintViolation();
            return false;
        } else if (product.getInv()<product.getMinInv()) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Fix Inventory, It's less than min value").addConstraintViolation();
            return false;
        }
        return true;
    }
}
