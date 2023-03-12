package zxc.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import zxc.pojo.User;
import zxc.pojo.query.UserQuery;

import java.util.List;

@Mapper
@Repository     //将userdao 交给spring容器管理
public interface UserDao {
//    查询所有用户
    public List<User> listUser();

//    根据id 查询用户
    public User queryUserById(Integer id);

//    跟用户名查询用户 并分页展示
    public List<User> listUserByName(UserQuery userQuery);

//    根据ID删除用户
    public int deleteUserById(Integer id);

}
