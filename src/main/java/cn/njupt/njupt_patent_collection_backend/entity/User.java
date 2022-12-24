package cn.njupt.njupt_patent_collection_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author baoyuhao
 * @version [版本号]
 * @time 2022/12/16 16:38:40
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

@Data
@TableName("user")
public class User {
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty("用户ID")
    private int id;

    @ApiModelProperty("用户登录名")
    private String username;

    @ApiModelProperty("用户真实姓名")
    private String name;

    @ApiModelProperty("用户手机号")
    private String phone;

    @ApiModelProperty("用户邮箱")
    private String email;

    @ApiModelProperty("用户权限")
    private String role;
}
