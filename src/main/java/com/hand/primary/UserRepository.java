package com.hand.primary;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author WangPan
 * @title UserRepository
 * @description (描述此类的功能)
 * @date: 2018/5/18 11:56
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
