package com.dimple.springbootvalidate.controller.customerValidate.validator;

import com.dimple.springbootvalidate.controller.customerValidate.IntArrayValuable;
import com.dimple.springbootvalidate.controller.customerValidate.annotation.InEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * InEnumValidator
 *
 * @author BianXiaofeng
 * @date 2/22/2023 11:00 AM
 */
public class InEnumValidator implements ConstraintValidator<InEnum, Integer> {
    /**
     * 值数组
     */
    private Set<Integer> values;

    @Override
    public void initialize(InEnum annotation) {
        IntArrayValuable[] values = annotation.value().getEnumConstants();
        if (values.length == 0) {
            this.values = Collections.emptySet();
        } else {
            this.values = Arrays.stream(values[0].array()).boxed().collect(Collectors.toSet());
        }
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (values.contains(value)) {
            return true;
        }
        context.disableDefaultConstraintViolation(); // 禁用默认的 message 的值
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()
                .replaceAll("\\{value}", values.toString())).addConstraintViolation(); // 重新添加错误提示语句
        return false;
    }

}
