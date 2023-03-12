package zxc.service;
import com.github.pagehelper.PageInfo;
import zxc.pojo.User;
import zxc.pojo.query.UserQuery;

import java.awt.print.Pageable;
import java.util.List;

public interface UserService {
    //    查询所有用户
    public List<User> listUser();

    //    跟用户名查询用户 并分页展示
    public PageInfo<User> listUserByName(UserQuery userQuery);

    //    根据ID删除用户
    public boolean deleteUserById(Integer id);

    //    根据id 查询用户
    public User queryUserById(Integer id);

}
