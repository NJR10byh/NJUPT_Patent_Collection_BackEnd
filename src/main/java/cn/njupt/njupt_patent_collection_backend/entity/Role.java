package cn.njupt.njupt_patent_collection_backend.entity;

/**
 * @author baoyuhao
 * @version [版本号]
 * @time 2022/12/16 17:09:34
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("role")
public class Role {
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty("权限主键ID")
    private int id;

    @ApiModelProperty("权限名称")
    private String roleName;
}
