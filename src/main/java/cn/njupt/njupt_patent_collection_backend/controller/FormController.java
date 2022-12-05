package cn.njupt.njupt_patent_collection_backend.controller;

import cn.njupt.njupt_patent_collection_backend.entity.Form;
import cn.njupt.njupt_patent_collection_backend.error.BusinessException;
import cn.njupt.njupt_patent_collection_backend.error.EmBusinessError;
import cn.njupt.njupt_patent_collection_backend.response.ReturnType;
import cn.njupt.njupt_patent_collection_backend.service.FormService;
import cn.njupt.njupt_patent_collection_backend.validate.AddGroup;
import cn.njupt.njupt_patent_collection_backend.validate.UpdateGroup;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author baoyuhao
 * @date 2022/11/23 13:59:59
 * @description
 * @version [1.0]
 */

@CrossOrigin
@RestController
@RequestMapping("/form")
public class FormController
{
    @Autowired
    private FormService formService;
    
    @PostMapping("/getFormPage")
    @ApiOperation("获取成果征集表（分页）")
    @ApiResponses({@ApiResponse(code = 200, message = "success", response = Form.class)})
    public ReturnType getNoticePage(@RequestParam(value = "currPage") Integer currPage,
        @RequestParam(value = "size") Integer size)
        throws BusinessException
    {
        return ReturnType.create(formService.getFormPage(currPage, size));
    }
    
    @PostMapping("/getFormById")
    @ApiOperation("根据id获取成果征集表")
    @ApiResponses({@ApiResponse(code = 200, message = "success", response = Form.class)})
    public ReturnType getFormById(@ApiParam("成果征集表id") @RequestParam(value = "id") int id)
        throws BusinessException
    {
        return ReturnType.create(formService.getFormById(id));
    }
    
    @PostMapping("/addForm")
    @ApiOperation("新增一个成果征集表")
    @ApiResponses({@ApiResponse(code = 200, message = "success", response = Form.class)})
    public ReturnType addForm(@Validated(AddGroup.class) @RequestBody Form form, BindingResult bindingResult)
        throws BusinessException
    {
        if (bindingResult.hasErrors())
        {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,
                bindingResult.getFieldError().getDefaultMessage());
        }
        formService.addForm(form);
        return ReturnType.create("新增成功");
    }
    
    @PostMapping("/updateForm")
    @ApiOperation("修改一个成果征集表")
    @ApiResponses({@ApiResponse(code = 200, message = "success", response = Form.class)})
    public ReturnType updateForm(@Validated(UpdateGroup.class) @RequestBody Form form, BindingResult bindingResult)
        throws BusinessException
    {
        if (bindingResult.hasErrors())
        {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,
                bindingResult.getFieldError().getDefaultMessage());
        }
        formService.updateForm(form);
        return ReturnType.create("修改成功");
    }
    
    @PostMapping("/deleteForm")
    @ApiOperation("删除一个成果征集表")
    public ReturnType deleteForm(@ApiParam("成果征集表id") @RequestParam(value = "id") int id)
        throws BusinessException
    {
        formService.deleteForm(id);
        return ReturnType.create("删除成功");
    }
}
