package cn.njupt.njupt_patent_collection_backend.controller.VO;

import cn.njupt.njupt_patent_collection_backend.service.model.FormSearchModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author baoyuhao
 * @version [版本号]
 * @time 2022/12/16 14:11:20
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Data
public class SearchFormVO {
    @ApiModelProperty("当前页")
    private Integer currPage;
    @ApiModelProperty("每页数据大小")
    private Integer size;

    @NotNull(message = "搜索条件为空")
    @Valid
    private FormSearchModel searchCondition;
}
