# @Validate 和 @valid

@Valid是Bean Validation的定义,可以添加在`普通方法`,`构造方法`,`方法参数`,`方法返回`,`成员变量上`.

@Validate,是Spring Validate定义,可以添加在`类`,`方法参数`,`普通方法`上. 支持分组校验.


区别:
1. Spring Validate仅对@Validate注解实现声明式校验.
2. Spring Validate的@validate具有分组校验功能.
3. 嵌套校验: 有嵌套对象的时候,只能使用@Valid注解.

