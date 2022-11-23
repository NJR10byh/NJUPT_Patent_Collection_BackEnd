package cn.njupt.njupt_patent_collection_backend.handle;

import java.lang.annotation.*;

/**
 * @ClassName: Auth
 * @Description: TODO
 * @Author: Ran
 * @Date: 2022/4/6 16:15
 * @Version: v1.0
 */
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth
{
    String[] permission() default {};
}