package com.hand.service;

import com.hand.model.User;
import java.util.List;

/**
 * @author WangPan
 * @title UserService
 * @description (描述此类的功能)
 * @date: 2018/4/24 13:06
 */
public interface UserService {
    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);
}
