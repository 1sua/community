package com.ls.service;

import com.ls.pojo.DiscussPost;

import java.util.List;

public interface DiscussPostService {

    List<DiscussPost> queryDiscussPosts(int userId, int startIndex, int pageSize);

    int queryDiscussPostRows(int userId);

}
