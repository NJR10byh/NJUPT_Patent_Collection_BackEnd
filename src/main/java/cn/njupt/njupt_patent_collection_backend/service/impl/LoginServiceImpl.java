package cn.njupt.njupt_patent_collection_backend.service.impl;

/**
 * @author baoyuhao
 * @version [版本号]
 * @time 2022/12/16 16:47:00
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

import cn.njupt.njupt_patent_collection_backend.entity.Role;
import cn.njupt.njupt_patent_collection_backend.entity.User;
import cn.njupt.njupt_patent_collection_backend.entity.UserAccount;
import cn.njupt.njupt_patent_collection_backend.error.BusinessException;
import cn.njupt.njupt_patent_collection_backend.error.EmBusinessError;
import cn.njupt.njupt_patent_collection_backend.mapper.LoginMapper;
import cn.njupt.njupt_patent_collection_backend.mapper.RoleMapper;
import cn.njupt.njupt_patent_collection_backend.mapper.UserMapper;
import cn.njupt.njupt_patent_collection_backend.service.LoginService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    public User getUserInfo(User userinfo) {
        int roleId = Integer.parseInt(userinfo.getRole());
        Role role = roleMapper.selectById(roleId);
        User user = new User();
        user.setId(userinfo.getId());
        user.setUsername(userinfo.getUsername());
        user.setJobNumber(userinfo.getJobNumber());
        user.setName(userinfo.getName());
        user.setPhone(userinfo.getPhone());
        user.setEmail(userinfo.getEmail());
        user.setRole(role.getRoleName());
        return user;
    }

    @Override
    public User loginByAccount(String username, String password) throws BusinessException {
        QueryWrapper<UserAccount> loginWrapper = new QueryWrapper<UserAccount>().eq("username", username);
        UserAccount userAccount = loginMapper.selectOne(loginWrapper);
        if (userAccount == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "用户名或密码错误，登录失败");
        }
        if (userAccount.getPassword().equals(password)) {
            QueryWrapper<User> userWrapper = new QueryWrapper<User>().eq("username", username);
            User user = userMapper.selectOne(userWrapper);
            return this.getUserInfo(user);
        } else {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "用户名或密码错误，登录失败");
        }
    }
}
