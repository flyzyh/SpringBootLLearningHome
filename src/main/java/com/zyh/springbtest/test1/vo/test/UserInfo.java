package com.zyh.springbtest.test1.vo.test;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="t_user_info")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "id", strategy = "native")
    @Column(name = "id",updatable = false, nullable = false)
    Integer id;

    @Column(name="user_name")
    String userName;
}
