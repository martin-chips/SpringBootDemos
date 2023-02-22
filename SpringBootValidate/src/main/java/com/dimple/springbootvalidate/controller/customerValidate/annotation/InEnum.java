package com.dimple.springbootvalidate.controller.customerValidate.annotation;

import com.dimple.springbootvalidate.controller.customerValidate.IntArrayValuable;
import com.dimple.springbootvalidate.controller.customerValidate.validator.InEnumValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * InEnum
 *
 * @author BianXiaofeng
 * @date 2/22/2023 10:59 AM
 */
@Documented
@Constraint(validatedBy = InEnumValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface InEnum {

    /**
     * @return 实现 IntArrayValuable 接口的
     */
    Class<? extends IntArrayValuable> value();

    /**
     * @return 提示内容
     */
    String message() default "必须在指定范围 {value}";

    /**
     * @return 分组
     */
    Class<?>[] groups() default {};

    /**
     * @return Payload 数组
     */
    Class<? extends Payload>[] payload() default {};

    /**
     * Defines several {@code @InEnum} constraints on the same element.
     */
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {

        InEnum[] value();

    }

}
