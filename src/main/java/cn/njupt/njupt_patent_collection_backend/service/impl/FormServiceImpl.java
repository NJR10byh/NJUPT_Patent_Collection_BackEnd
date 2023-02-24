package cn.njupt.njupt_patent_collection_backend.service.impl;

/**
 * @author baoyuhao
 * @version [1.0]
 * @date 2022/11/23 14:18:59
 * @description
 */

import cn.njupt.njupt_patent_collection_backend.entity.Form;
import cn.njupt.njupt_patent_collection_backend.error.BusinessException;
import cn.njupt.njupt_patent_collection_backend.error.EmBusinessError;
import cn.njupt.njupt_patent_collection_backend.mapper.FormMapper;
import cn.njupt.njupt_patent_collection_backend.service.FormService;
import cn.njupt.njupt_patent_collection_backend.service.model.FormSearchModel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class FormServiceImpl implements FormService {
    @Autowired
    private FormMapper formMapper;

    @Override
    public Page<Form> getFormPageByCondition(FormSearchModel searchCondition, Integer currPage, Integer size) {
        QueryWrapper<Form> wrapper = new QueryWrapper<Form>();
        // 成果名称
        if (!StringUtils.isBlank(searchCondition.getAchievementName())) {
            wrapper.like("achievement_name", searchCondition.getAchievementName().trim());
        }
        // 成果联系人
        if (!StringUtils.isBlank(searchCondition.getAchievementContactPerson())) {
            wrapper.like("achievement_contact_person", searchCondition.getAchievementContactPerson().trim());
        }
        // 工号
        if (!StringUtils.isBlank(searchCondition.getJobNumber())) {
            wrapper.like("job_number", searchCondition.getJobNumber().trim());
        }
        wrapper.orderByDesc("update_time");
        Page<Form> page = new Page<>(currPage, size);
        return formMapper.selectPage(page, wrapper);
    }

    /**
     * 根据ID查询表单
     *
     * @param id
     * @return
     * @throws BusinessException
     */
    @Override
    public Form getFormById(int id) throws BusinessException {
        Form form = formMapper.selectById(id);
        if (form == null) {
            throw new BusinessException(EmBusinessError.RECORD_NOT_EXIST, "成果征集表不存在");
        }

        return form;
    }

    /**
     * 新增表单
     *
     * @param form
     * @throws BusinessException
     */
    @Override
    public void addForm(Form form) throws BusinessException {
        try {
            formMapper.insert(form);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "成果征集表已存在");
        }
    }

    /**
     * 修改表单
     *
     * @param form
     * @throws BusinessException
     */
    @Override
    public void updateForm(Form form) throws BusinessException {
        try {
            formMapper.updateById(form);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(EmBusinessError.CANNOT_BE_MODIFIED, "修改错误");
        }
    }

    /**
     * 删除表单
     *
     * @param id
     * @throws BusinessException
     */
    @Override
    public void deleteForm(int id) throws BusinessException {
        Form form = formMapper.selectById(id);
        if (form == null) {
            throw new BusinessException(EmBusinessError.RECORD_NOT_EXIST, "成果征集表不存在");
        } else {
            formMapper.deleteById(id);
        }
    }
}
