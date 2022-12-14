package cn.njupt.njupt_patent_collection_backend.service;

import cn.njupt.njupt_patent_collection_backend.entity.Form;
import cn.njupt.njupt_patent_collection_backend.error.BusinessException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author baoyuhao
 * @date 2022/11/23 14:15:04
 * @description
 * @version [1.0]
 */
public interface FormService
{
    
    Page<Form> getFormPage(Integer currPage, Integer size);

    Page<Form> getFormPageByCondition(String achievementName,String achievementContactPerson,String jobNumber,Integer currPage, Integer size);

    
    Form getFormById(int id)
        throws BusinessException;
    
    void addForm(Form form)
        throws BusinessException;
    
    void updateForm(Form form)
        throws BusinessException;
    
    void deleteForm(int id)
        throws BusinessException;
}
