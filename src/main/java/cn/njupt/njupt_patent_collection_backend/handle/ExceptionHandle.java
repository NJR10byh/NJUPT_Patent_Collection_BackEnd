package cn.njupt.njupt_patent_collection_backend.handle;

import cn.njupt.njupt_patent_collection_backend.error.BusinessException;
import cn.njupt.njupt_patent_collection_backend.response.ReturnType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class ExceptionHandle
{
    @ExceptionHandler(Exception.class)
    @ResponseBody
    
    public Object handlerException(HttpServletRequest request, Exception ex)
    {
        int code = 0;
        Map<String, Object> responseData = new HashMap<>();
        if (ex instanceof BusinessException)
        {
            BusinessException businessException = (BusinessException)ex;
            code = businessException.getErrCode();
            responseData.put("errMsg", businessException.getErrMsg());
        }
        return ReturnType.create(code, "fail", responseData);
    }
    
}
