package cn.njupt.njupt_patent_collection_backend.entity;

import cn.njupt.njupt_patent_collection_backend.config.TypeHandleConfig;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author baoyuhao
 * @version [1.0]
 * @date 2022/11/23 14:03:13
 * @description
 */

@Data
@TableName(value = "form", autoResultMap = true)
public class Form {
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty("征集表id")
    private int id;

    @ApiModelProperty("相关专利List")
    @TableField(value = "patent_list", typeHandler = TypeHandleConfig.class)
    private List<String> patentList;

    @ApiModelProperty("成果名称")
    private String achievementName;

    @ApiModelProperty("成果联系人")
    private String achievementContactPerson;

    @ApiModelProperty("职称")
    private String jobTitle;

    @ApiModelProperty("电话")
    private String achievementContactPhone;

    @ApiModelProperty("Email")
    private String achievementContactEmail;

    @ApiModelProperty("所在学院")
    private String department;

    @ApiModelProperty("工号")
    private String jobNumber;

    @ApiModelProperty("技术成熟度")
    private String technicalMaturity;

    @ApiModelProperty("技术分类")
    private String technicalClassification;

    @ApiModelProperty("成果介绍")
    private String achievementIntroduce;

    @ApiModelProperty("关键技术")
    private String keyTechnologies;

    @ApiModelProperty("应用领域和市场")
    private String fieldMarket;

    @ApiModelProperty("成果估值金额")
    private int achievementPrice;

    @ApiModelProperty("转化方式")
    private String transformWay;

    @ApiModelProperty("征集表创建人")
    @TableField(fill = FieldFill.INSERT)
    private String createUser;

    @ApiModelProperty("征集表创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("征集表更新人")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateUser;

    @ApiModelProperty("征集表更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
