package com.ls.controller;

import com.ls.pojo.DiscussPost;
import com.ls.pojo.Page;
import com.ls.pojo.User;
import com.ls.service.DiscussPostService;
import com.ls.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private DiscussPostService discussPostService;

    @RequestMapping({"/","/index.html"})
    public String toIndex(Model model, Page page) {
        //方法调用前，SpringMVC会自动实例化Model和Page，并将Page注入Model
        //所以，在thymeleaf中可以直接访问Page1对象中的数据
        //设置总记录数
        page.setTotalCount(discussPostService.queryDiscussPostRows(0));
        //设置路径，便于复用
        page.setPath("/");

        //页面需要显示用户名，可以用连表查询或者用下面方法
        List<DiscussPost> discussPosts = discussPostService.queryDiscussPosts(0, page.getStartIndex(), page.getPageSize());
        List<Map<String,Object>> discussPostUsers = new ArrayList<>();
        if (discussPosts != null){
            for (DiscussPost discussPost : discussPosts) {
                Map<String,Object> map = new HashMap<>();
                map.put("post",discussPost);
                User user = userService.queryUserById(discussPost.getUserId());
                map.put("user",user);
                discussPostUsers.add(map);
            }
        }
        model.addAttribute("discussPostUsers",discussPostUsers);
        model.addAttribute("page",page);
        return "index";
    }

}
