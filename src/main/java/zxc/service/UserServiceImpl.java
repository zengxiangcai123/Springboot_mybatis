package zxc.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxc.dao.UserDao;
import zxc.pojo.User;
import zxc.pojo.query.UserQuery;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

//  查询所有数据
    @Override
    public List<User> listUser() {
        return userDao.listUser();
    }

// 分页调用 PageInfo 实现分页查询数量
    @Override
    public PageInfo<User> listUserByName(UserQuery userQuery) {
        PageHelper.startPage(userQuery.getPageNum(),userQuery.getPageSize());
        return new PageInfo<User>(userDao.listUserByName(userQuery));
    }

//    删除
    @Override
    public boolean deleteUserById(Integer id) {
        int i = userDao.deleteUserById(id);
        if (i > 0){
            return true;
        }else {
            return false;
        }
    }

//    根据id用户查询
    @Override
    public User queryUserById(Integer id) {
        return userDao.queryUserById(id);
    }
}
