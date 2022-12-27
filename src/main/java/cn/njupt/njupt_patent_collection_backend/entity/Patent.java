package cn.njupt.njupt_patent_collection_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author baoyuhao
 * @version [1.0]
 * @date 2022/12/27 22:20:00
 * @description
 */

@Data
@TableName("patent")
public class Patent {
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty("专利信息id")
    private Long patentInfoId;

    @ApiModelProperty("专利id")
    private String wid;
    @ApiModelProperty("法律状态代码")
    private String flztdm;

    @ApiModelProperty("专利授权日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date zlsqrq;

    @ApiModelProperty("专利权人")
    private String zlqr;
    @ApiModelProperty("一级学科代码")
    private String yjxkdm;

    @ApiModelProperty("二级学科代码")
    private String ejxkdm;

    @ApiModelProperty("专利代理机构")
    private String zldljg;

    @ApiModelProperty("学校排名")
    private String xxpm;
    @ApiModelProperty("成员人数")
    private Integer cyrs;

    @ApiModelProperty("成员名单")
    private String cymd;
    @ApiModelProperty("成员工号")
    private String cygh;
    @ApiModelProperty("专利代理人")
    private String zldlr;
    @ApiModelProperty("科研大类代码")
    private String kydldm;
    @ApiModelProperty("代理人电话")
    private String dlrdh;
    @ApiModelProperty("关键字")
    private String gjz;
    @ApiModelProperty("专利简介")
    private String zljj;
    @ApiModelProperty("研究类别代码")
    private String yjlbdm;
    @ApiModelProperty("成果来源代码")
    private String cglydm;
    @ApiModelProperty("批准日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date pzrq;
    @ApiModelProperty("批准形式代码")
    private String pzxsdm;
    @ApiModelProperty("公开日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date gkrq;
    @ApiModelProperty("国际专利主分类号")
    private String gjzlzflh;
    @ApiModelProperty("专利证书编号")
    private String zlzsbh;
    @ApiModelProperty("专利证书下载地址")
    private String zlzsxzdz;
    @ApiModelProperty("专利名称")
    private String zlmc;
    @ApiModelProperty("缴纳专利年费日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date jnzlnfrq;
    @ApiModelProperty("PCT或专利国家(地区)代码")
    private String pcthzlgjdqdm;
    @ApiModelProperty("授权公告号")
    private String sqggh;
    @ApiModelProperty("缴纳金额")
    private String jnje;
    @ApiModelProperty("专利终止日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date zlzzrq;
    @ApiModelProperty("所属项目编号")
    private String ssxmbh;
    @ApiModelProperty("终止原因")
    private String zzyy;
    @ApiModelProperty("申请名称")
    private String sqmc;
    @ApiModelProperty("最后更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date zhgxsj;
    @ApiModelProperty("备注")
    private String bz;
    @ApiModelProperty("专利类型代码")
    private String zllxdm;
    @ApiModelProperty("申请编号")
    private String sqbh;
    @ApiModelProperty("学科领域码")
    private String xklym;
    @ApiModelProperty("专利第一作者工号")
    private String zldyzzgh;
    @ApiModelProperty("专利第一作者姓名")
    private String zldyzzxm;
    @ApiModelProperty("归属单位")
    private String gsdw;
    @ApiModelProperty("处理日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date clrq;
    @ApiModelProperty("操作类型")
    private String czlx;
    @ApiModelProperty("归属院系（单位）代码")
    private String gsdwdm;
    @ApiModelProperty("归属基地(平台)代码")
    private String gsjdptdm;
    @ApiModelProperty("申请国别代码")
    private String sqgbdm;
    @ApiModelProperty("国家(地区)代码")
    private String gjdqdm;
    @ApiModelProperty("专利号")
    private String zlh;

    @ApiModelProperty("专利证书id")
    private Long certificateId;

    @ApiModelProperty("专利年费延期提醒日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date reminderDate;
    @ApiModelProperty("副本数")
    private Integer hasCopies;
    @ApiModelProperty("原本id")
    private Long originId;
}
