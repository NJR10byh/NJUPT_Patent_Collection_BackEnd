package cn.njupt.njupt_patent_collection_backend.error;

public interface CommonError
{
    int getErrCode();
    
    String getErrMsg();
    
    CommonError setErrMsg(String errMsg);
}
