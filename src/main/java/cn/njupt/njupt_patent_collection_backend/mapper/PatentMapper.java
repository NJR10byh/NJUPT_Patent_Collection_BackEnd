package cn.njupt.njupt_patent_collection_backend.mapper;
/**
 * @author baoyuhao
 * @version [1.0]
 * @date 2022/12/27 22:35:46
 * @description
 */

import cn.njupt.njupt_patent_collection_backend.entity.Patent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;


@Repository
public interface PatentMapper extends BaseMapper<Patent> {
}
