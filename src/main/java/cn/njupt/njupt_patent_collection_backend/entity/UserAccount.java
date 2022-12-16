package cn.njupt.njupt_patent_collection_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author baoyuhao
 * @version [版本号]
 * @time 2022/12/16 16:38:32
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

@Data
@TableName("userAccount")
public class UserAccount {
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty("用户登录信息主键ID")
    private int id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;
}
