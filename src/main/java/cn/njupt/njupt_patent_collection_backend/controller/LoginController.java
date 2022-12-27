package cn.njupt.njupt_patent_collection_backend.controller;

import cn.njupt.njupt_patent_collection_backend.controller.VO.LoginVO;
import cn.njupt.njupt_patent_collection_backend.entity.User;
import cn.njupt.njupt_patent_collection_backend.error.BusinessException;
import cn.njupt.njupt_patent_collection_backend.error.EmBusinessError;
import cn.njupt.njupt_patent_collection_backend.response.ReturnType;
import cn.njupt.njupt_patent_collection_backend.service.LoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author baoyuhao
 * @version [版本号]
 * @time 2022/12/16 16:25:29
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/loginByAccount")
    @ApiOperation("通过账号密码登录")
    public ReturnType loginByAccount(@Valid @RequestBody LoginVO loginVO, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) throws BusinessException {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        HttpSession session = request.getSession();
        User user = loginService.loginByAccount(loginVO.getUsername(), loginVO.getPassword());
        session.setAttribute("logined_userInfo", user);
        return ReturnType.create(user);
    }
}
