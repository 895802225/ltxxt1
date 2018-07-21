package com.test.service;

import com.test.common.ServerReponse;
import com.test.dao.PrintMapper;
import com.test.datasource.CustomerContextHolder;
import com.test.pojo.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iPrintService")
public class PrintServiceImpl implements IPrintService {
    @Autowired
    private PrintMapper printMapper;
    @Override
    public ServerReponse insert(Print print) {
        CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_MSSQL);
        Print print1=printMapper.selectByCode(print.getCode(),print.getYear(),print.getMonth());
        if(print1==null){
            int countRow=printMapper.insert(print);
            if(countRow==0){
                return ServerReponse.createByErrorMessage("插入数据失败");
            }
            return ServerReponse.createBySuccessMsg("插入数据成功");
        }else {
            return ServerReponse.createByErrorMessage("该条记录已经存在");
        }

    }
}
