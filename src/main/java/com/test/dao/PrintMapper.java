package com.test.dao;

import com.sun.jna.platform.unix.solaris.LibKstat;
import com.test.pojo.Print;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrintMapper {
//    插入打印信息
    int insert(Print print);
//    根据人员代码，年，月查找打印信息
    Print selectByCode(@Param("code") String code, @Param("year") String year, @Param("month") String month);
//    根据人员代码查找打印信息
    List<Print> selectCode(String code);
}
