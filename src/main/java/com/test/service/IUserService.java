package com.test.service;



import com.test.common.ServerReponse;
import com.test.vo.UserVo;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface IUserService {

    ServerReponse getList(int accountNo, String password);
    ServerReponse loginCheck(int accountNo, String password) throws UnsupportedEncodingException;
    ServerReponse readIC() throws UnsupportedEncodingException;
    ServerReponse init();
    ServerReponse<List<UserVo>> getUserList(String code);
    ServerReponse readICNew() throws UnsupportedEncodingException;
}
