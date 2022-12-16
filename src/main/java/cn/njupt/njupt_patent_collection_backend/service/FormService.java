package cn.njupt.njupt_patent_collection_backend.service;

import cn.njupt.njupt_patent_collection_backend.entity.Form;
import cn.njupt.njupt_patent_collection_backend.error.BusinessException;
import cn.njupt.njupt_patent_collection_backend.service.model.FormSearchModel;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author baoyuhao
 * @version [1.0]
 * @date 2022/11/23 14:15:04
 * @description
 */

public interface FormService {
    Page<Form> getFormPageByCondition(FormSearchModel searchCondition, Integer currPage, Integer size);


    Form getFormById(int id)
            throws BusinessException;

    void addForm(Form form)
            throws BusinessException;

    void updateForm(Form form)
            throws BusinessException;

    void deleteForm(int id)
            throws BusinessException;
}
