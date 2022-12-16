package cn.njupt.njupt_patent_collection_backend.service;

import cn.njupt.njupt_patent_collection_backend.entity.User;
import cn.njupt.njupt_patent_collection_backend.error.BusinessException;

/**
 * @author baoyuhao
 * @version [版本号]
 * @time 2022/12/16 16:36:05
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

public interface LoginService {
    User loginByAccount(String username, String password) throws BusinessException;
}
