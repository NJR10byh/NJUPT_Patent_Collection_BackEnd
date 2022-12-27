package cn.njupt.njupt_patent_collection_backend.controller.VO;
/**
 * @author baoyuhao
 * @version [1.0]
 * @date 2022/12/27 22:30:16
 * @description
 */

import cn.njupt.njupt_patent_collection_backend.service.model.PatentSearchModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class SearchPatentVO {
    @ApiModelProperty("当前页")
    private Integer currPage;
    @ApiModelProperty("每页数据大小")
    private Integer size;

    @NotNull(message = "搜索条件为空")
    @Valid
    private PatentSearchModel searchCondition;
}
