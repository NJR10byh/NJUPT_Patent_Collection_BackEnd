package cn.njupt.njupt_patent_collection_backend.service.model;

/**
 * @author baoyuhao
 * @version [1.0]
 * @date 2022/12/27 22:31:03
 * @description
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PatentSearchModel
{
    @ApiModelProperty("是否授权")
    private Boolean authorize;
    
    @ApiModelProperty("专利名称")
    private String zlmc;
    
    @ApiModelProperty("专利号")
    private String zlh;
}
