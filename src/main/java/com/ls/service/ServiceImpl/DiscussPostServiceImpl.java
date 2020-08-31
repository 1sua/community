package com.ls.service.ServiceImpl;

import com.ls.mapper.DiscussPostMapper;
import com.ls.pojo.DiscussPost;
import com.ls.service.DiscussPostService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostServiceImpl implements DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> queryDiscussPosts(int userId, int startIndex, int pageSize){
        return discussPostMapper.queryDiscussPosts(userId,startIndex,pageSize);
    }

    public int queryDiscussPostRows(int userId){
        return discussPostMapper.queryDiscussPostRows(userId);
    }

}
