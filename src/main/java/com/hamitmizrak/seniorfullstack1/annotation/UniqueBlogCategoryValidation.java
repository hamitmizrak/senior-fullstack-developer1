package com.hamitmizrak.seniorfullstack1.annotation;

import com.hamitmizrak.seniorfullstack1.data.repository.IBlogCategoryRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

// LOMBOK
@RequiredArgsConstructor

// <A,T> A=Annotation T=Type
public class UniqueBlogCategoryValidation implements ConstraintValidator<AUniqueBlogCategoryName, String> {

    // INJECTION
    /* 1.YOL
    @Autowired
    private final IBlogCategoryRepository iBlogCategoryRepository;
    */

    /*2.YOL
    private final IBlogCategoryRepository iBlogCategoryRepository;
    @Autowired
    public UniqueBlogCategoryValidation(IBlogCategoryRepository iBlogCategoryRepository) {
        this.iBlogCategoryRepository = iBlogCategoryRepository;
    }
    */

    // 3.YOL
    private final IBlogCategoryRepository iBlogCategoryRepository;

    //isValid
    @Override
    public boolean isValid(String categoryName, ConstraintValidatorContext constraintValidatorContext) {
        // 1.YOL
        // BlogCategoryEntity isSameCategoryName=iBlogCategoryRepository.findByCategoryName(categoryName).orElseThrow(()->new NotFound404Exception(categoryName+" Bulunmadı"));
        // 2.YOL
        boolean isSameCategoryName = iBlogCategoryRepository.findByCategoryName(categoryName).isPresent();
        // Eğer Aynı blogCategoryName varsa return false döndersin
        if (isSameCategoryName) {
            System.out.println(categoryName + " Aynı isimde Database bulunmaktadır. Farklı bir database giriniz");
            return false;
        } else {
            System.out.println(categoryName + " Harika bu category ismini yazabilirsiniz");
            return true;
        }
    } //isValid
} //end UniqueBlogCategoryValidation
