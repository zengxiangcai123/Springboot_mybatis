package zxc.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import zxc.pojo.User;
import zxc.pojo.query.UserQuery;
import zxc.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

   @GetMapping("/")
    public String index(Model model, UserQuery userQuery){
       PageInfo<User> userPageInfo = userService.listUserByName(userQuery);
       model.addAttribute("page",userPageInfo);
       return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes attributes){
        boolean b = userService.deleteUserById(id);
        if(b){
            attributes.addFlashAttribute("message","删除成功");
            return "redirect:/";
        }else {
            attributes.addFlashAttribute("message","删除用户失败");
            return "redirect:/";
        }
    }

    @GetMapping("/edit/{id}")
    public String toEdit(@PathVariable  Integer id, Model model){
       model.addAttribute("user",userService.queryUserById(id));
       return "editUser";
    }
}
