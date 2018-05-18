package com.hand.secondary;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author WangPan
 * @title MessageRepository
 * @description (描述此类的功能)
 * @date: 2018/5/18 11:57
 */
public interface MessageRepository extends JpaRepository<Message, Long> {

}
