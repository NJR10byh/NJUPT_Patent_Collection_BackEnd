package cn.njupt.njupt_patent_collection_backend.controller;

import cn.njupt.njupt_patent_collection_backend.controller.VO.SearchPatentVO;
import cn.njupt.njupt_patent_collection_backend.entity.Patent;
import cn.njupt.njupt_patent_collection_backend.error.BusinessException;
import cn.njupt.njupt_patent_collection_backend.error.EmBusinessError;
import cn.njupt.njupt_patent_collection_backend.response.ReturnType;
import cn.njupt.njupt_patent_collection_backend.service.PatentService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author baoyuhao
 * @version [1.0]
 * @date 2022/12/27 22:17:30
 * @description
 */

@CrossOrigin
@RestController
@RequestMapping("/patent")
public class PatentController {

    @Autowired
    private PatentService patentService;

    /**
     * 条件查询专利信息（分页）
     *
     * @param searchVO
     * @param bindingResult
     * @return
     * @throws BusinessException
     */
    @PostMapping("/getPatentPageByCondition")
    @ApiOperation("条件查询专利信息（分页）")
    @ApiResponses({@ApiResponse(code = 200, message = "success", response = Patent.class)})
    public ReturnType getPatentPageByCondition(HttpServletRequest request, @Valid @RequestBody SearchPatentVO searchVO, BindingResult bindingResult)
            throws BusinessException {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }

        Page<Patent> result = patentService.getPatentPageByCondition(request, searchVO);
        return ReturnType.create(result);
    }
}
