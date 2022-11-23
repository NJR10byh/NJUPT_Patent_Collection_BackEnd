package cn.njupt.njupt_patent_collection_backend.service.impl;

// import cn.njupt.njupt_patent_collection_backend.constant.FormConstant;

import cn.njupt.njupt_patent_collection_backend.entity.Form;
import cn.njupt.njupt_patent_collection_backend.error.BusinessException;
import cn.njupt.njupt_patent_collection_backend.error.EmBusinessError;
import cn.njupt.njupt_patent_collection_backend.mapper.FormMapper;
import cn.njupt.njupt_patent_collection_backend.service.FormService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 * @author baoyuhao
 * @date 2022/11/23 14:18:59
 * @description
 * @version [1.0]
 */
@Service
public class FormServiceImpl implements FormService
{
    @Autowired
    private FormMapper formMapper;
    
    @Override
    public Page<Form> getFormPage(Integer currPage, Integer size)
    {
        Page<Form> page = new Page<>(currPage, size);
        QueryWrapper<Form> wrapper = new QueryWrapper<Form>().orderByDesc("update_time");
        formMapper.selectPage(page, wrapper);
        return page;
    }
    
    @Override
    public Form getFormById(int id)
        throws BusinessException
    {
        Form form = formMapper.selectById(id);
        if (form == null)
        {
            throw new BusinessException(EmBusinessError.RECORD_NOT_EXIST, "成果征集表不存在");
        }
        
        return form;
    }
    
    @Override
    public void addForm(Form form)
        throws BusinessException
    {
        try
        {
            formMapper.insert(form);
        }
        catch (DuplicateKeyException e)
        {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "成果征集表已存在");
        }
    }
    
    @Override
    public Form updateForm(Form form)
        throws BusinessException
    {
        formMapper.updateById(form);
        return this.getFormById(form.getId());
    }
    
    @Override
    public void deleteForm(int id)
    {
        formMapper.deleteById(id);
    }
}
