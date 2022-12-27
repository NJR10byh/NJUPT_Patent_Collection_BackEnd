package cn.njupt.njupt_patent_collection_backend.service;

import cn.njupt.njupt_patent_collection_backend.controller.VO.SearchPatentVO;
import cn.njupt.njupt_patent_collection_backend.entity.Patent;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.servlet.http.HttpServletRequest;

/**
 * @author baoyuhao
 * @version [1.0]
 * @date 2022/12/27 22:32:35
 * @description
 */


public interface PatentService {
    Page<Patent> getPatentPageByCondition(HttpServletRequest request, SearchPatentVO searchVO);
}
