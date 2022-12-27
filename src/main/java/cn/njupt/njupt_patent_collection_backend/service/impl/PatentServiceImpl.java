package cn.njupt.njupt_patent_collection_backend.service.impl;

import cn.njupt.njupt_patent_collection_backend.controller.VO.SearchPatentVO;
import cn.njupt.njupt_patent_collection_backend.entity.Patent;
import cn.njupt.njupt_patent_collection_backend.entity.User;
import cn.njupt.njupt_patent_collection_backend.mapper.PatentMapper;
import cn.njupt.njupt_patent_collection_backend.service.PatentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author baoyuhao
 * @version [1.0]
 * @date 2022/12/27 22:34:29
 * @description
 */
@Service
public class PatentServiceImpl implements PatentService {

    @Autowired
    private PatentMapper patentMapper;

    @Override
    public Page<Patent> getPatentPageByCondition(HttpServletRequest request, SearchPatentVO searchVO) {
        QueryWrapper<Patent> wrapper = new QueryWrapper<Patent>().isNull("origin_id").orderByDesc("ZLSQRQ");
        User user = (User) request.getSession().getAttribute("logined_userInfo");

        if (searchVO.getSearchCondition().getAuthorized() != null) {
            if (searchVO.getSearchCondition().getAuthorized()) {
                // 授权
                wrapper.isNotNull("ZLSQRQ");
            } else {
                // 没授权
                wrapper.isNull("ZLSQRQ");
            }
        }
        // 专利发明人工号
        if (!StringUtils.isBlank(user.getJobNumber())) {
            wrapper.like("cygh", user.getJobNumber().trim());
        }
        // 专利发明人
        if (!StringUtils.isBlank(user.getName())) {
            wrapper.like("cymd", user.getName().trim());
        }
        Page<Patent> page = new Page<>(searchVO.getCurrPage(), searchVO.getSize());
        return patentMapper.selectPage(page, wrapper);
    }
}
