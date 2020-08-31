package com.ls.mapper;

import com.ls.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User queryUserById(int id);

}
