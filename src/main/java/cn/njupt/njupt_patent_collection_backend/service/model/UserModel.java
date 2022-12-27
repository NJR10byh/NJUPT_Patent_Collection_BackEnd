package cn.njupt.njupt_patent_collection_backend.service.model;
/**
 * @author baoyuhao
 * @version [1.0]
 * @date 2022/12/27 23:47:22
 * @description
 */

import lombok.Data;

@Data
public class UserModel {
    private int id;

    private String username;
    private String jobNumber;

    private String name;

    private String phone;

    private String email;
    private String role;
}
