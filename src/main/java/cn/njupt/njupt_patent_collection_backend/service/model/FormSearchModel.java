package cn.njupt.njupt_patent_collection_backend.service.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author baoyuhao
 * @version [版本号]
 * @time 2022/12/16 14:14:52
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Data
public class FormSearchModel {
    @ApiModelProperty("成果名称")
    private String achievementName;

    @ApiModelProperty("成果联系人")
    private String achievementContactPerson;

    @ApiModelProperty("工号")
    private String jobNumber;

}
