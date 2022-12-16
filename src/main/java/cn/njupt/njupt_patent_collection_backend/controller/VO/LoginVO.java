package cn.njupt.njupt_patent_collection_backend.controller.VO;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author baoyuhao
 * @version [版本号]
 * @time 2022/12/16 16:28:37
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

@Data
public class LoginVO {
    @NotBlank(message = "用户名为空")
    @NotBlank(message = "账号或密码错误")
    private String username;

    @NotBlank(message = "密码为空")
    @NotBlank(message = "账号或密码错误")
    private String password;
}
