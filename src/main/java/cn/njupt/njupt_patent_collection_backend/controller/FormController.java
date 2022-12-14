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

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 分页查询列表
     * @param currPage
     * @param size
     * @return
     * @throws BusinessException
     */
    @PostMapping("/getFormPage")
    @ApiOperation("获取成果征集表（分页）")
    @ApiResponses({@ApiResponse(code = 200, message = "success", response = Form.class)})
    public ReturnType getFormPage(@RequestParam(value = "currPage") Integer currPage,
        @RequestParam(value = "size") Integer size)
        throws BusinessException
    {
        return ReturnType.create(formService.getFormPage(currPage, size));
    }

    @PostMapping("/getFormPageByCondition")
    @ApiOperation("条件查询成果征集表（分页）")
    @ApiResponses({@ApiResponse(code = 200, message = "success", response = Form.class)})
    public ReturnType getFormPageByCondition(HttpServletRequest request,
                                             @ApiParam("成果名称") @RequestParam(value = "achievementName") String achievementName,
                                             @ApiParam("成果联系人") @RequestParam(value = "achievementContactPerson") String achievementContactPerson,
                                             @ApiParam("工号") @RequestParam(value = "jobNumber") String jobNumber,
                                             @RequestParam(value = "currPage") Integer currPage,
                                             @RequestParam(value = "size") Integer size)
            throws BusinessException
    {
        System.out.println(achievementName);
        System.out.println(achievementContactPerson);
        System.out.println(jobNumber);
        System.out.println(currPage);
        System.out.println(size);
        return ReturnType.create(formService.getFormPageByCondition(achievementName,achievementContactPerson,jobNumber,currPage, size));
    }

    /**
     * 根据ID查询表单
     * @param id
     * @return
     * @throws BusinessException
     */
    @PostMapping("/getFormById")
    @ApiOperation("根据id获取成果征集表")
    @ApiResponses({@ApiResponse(code = 200, message = "success", response = Form.class)})
    public ReturnType getFormById(@ApiParam("成果征集表id") @RequestParam(value = "id") int id)
        throws BusinessException
    {
        return ReturnType.create(formService.getFormById(id));
    }

    /**
     * 新增表单
     * @param form
     * @param bindingResult
     * @return
     * @throws BusinessException
     */
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

    /**
     * 修改表单
     * @param form
     * @param bindingResult
     * @return
     * @throws BusinessException
     */
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

    /**
     * 删除表单
     * @param id
     * @return
     * @throws BusinessException
     */
    @PostMapping("/deleteForm")
    @ApiOperation("删除一个成果征集表")
    public ReturnType deleteForm(@ApiParam("成果征集表id") @RequestParam(value = "id") int id)
        throws BusinessException
    {
        formService.deleteForm(id);
        return ReturnType.create("删除成功");
    }
}
