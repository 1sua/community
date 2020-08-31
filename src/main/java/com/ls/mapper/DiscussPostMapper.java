package com.ls.mapper;

import com.ls.pojo.DiscussPost;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscussPostMapper {

    List<DiscussPost> queryDiscussPosts(int userId,int startIndex, int pageSize);

    int queryDiscussPostRows(@Param("userId") int userId);

}
