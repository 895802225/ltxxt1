package com.test.service;

import com.google.common.collect.Lists;
import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;
import com.test.common.ResponseCode;
import com.test.common.ServerReponse;
import com.test.dao.PrintMapper;
import com.test.dao.UserMapper;
import com.test.datasource.CustomerContextHolder;
import com.test.pojo.Print;
import com.test.pojo.User;
import com.test.useDll.Test;
import com.test.vo.UserVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service("iUserService")
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PrintMapper printMapper;
    private List<Print> printList(String code){
        CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_MSSQL);
        List<Print> prints=printMapper.selectCode(code);
        return prints;
    }
    private List<UserVo> getList(String code){
        CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_MYSQL);
        List<User> users=userMapper.listUser(code);
        List<Print> prints=printList(code);
        List<UserVo> userVoList=Lists.newArrayList();
        String count="0";
        for(User user:users){
            for(Print printItem:prints){
                if(StringUtils.equals(printItem.getYear(),user.getYear())&&StringUtils.equals(printItem.getMonth(),user.getMonth())){
                    count="1";
                }
            }
            UserVo userVo=assembleUserVo(user,count);
            count="0";
            userVoList.add(userVo);
        }
        return userVoList;
    }
    private UserVo assembleUserVo(User user, String count){
        UserVo userVo=new UserVo();
        userVo.setUser(user);
        userVo.setCount(count);
        return userVo;
    }

    public ServerReponse<List<UserVo>> getUserList(String code){
        List<UserVo> userVoList=getList(code);
        return ServerReponse.createBySuccess(userVoList);
    }

//执行dll里面的方法
    public static Test.Dll ns = null;
    //加载总的动态库
    static{
        ns =(Test.Dll) Native.loadLibrary("AIO_API",Test.Dll.class);
    }
    public interface Dll extends StdCallLibrary {
        //设置动态库以第三方方式运行
        int TA_Init3(String IP, short port, short SysCode, short TerminalNo, boolean[] ProxyOffline, long[] MaxJnl, String signonPWD);
        //根据账号验证查询密码
        int TA_CheckQpwd(int accountno, String qpwd);
        // 根据帐号/卡号/学工号/证件号精确查询帐户信息
        int TA_InqAcc(Test.AccountMsg.ByReference struct, short Timeout);
        // 简单读卡信息，不检验白名单。
        int TA_ReadCardSimple(Test.AccountMsg.ByReference struct);
        // 初始化读卡器
        int TA_CRInit(byte CardReaderType, int port, long Baud_Rate);
        //关闭读卡器
        boolean TA_CRClose();
    }

    /**
     * 第三方初始化
     * @return
     */
    private int getInit3(){
        boolean[] booleans={false};
        long[] longs={1000};
        return ns.TA_Init3("218.197.98.75", (short) 8500,(short) 63,(short) 1,booleans,longs,"123");
    }

    /**
     * 登录是用到的方法，登录的时候验证是否属于离退休人员
     * @param accountNo
     * @param password
     * @return
     * @throws UnsupportedEncodingException
     */
    public ServerReponse loginCheck(int accountNo, String password) throws UnsupportedEncodingException {
        int i=getInit3();
        if(i==0){
            //第三方初始化成功
            int j=ns.TA_CheckQpwd(accountNo,password);
            if(j==0){
                //账号密码正确，当账号密码正确的时候就把账号传入到查询账户信息的函数
                Test.AccountMsg.ByReference accountMsg1=new Test.AccountMsg.ByReference();
                accountMsg1.AccountNo=Test.int2byte(accountNo);
                int x=ns.TA_InqAcc(accountMsg1,(short)10);
                if(x==0){
                    //说明正确，可以获取到studentcode
                    String Studentcode1 = Test.transToString(accountMsg1.StudentCode).trim();
                    String Studentcode =Studentcode1.replaceFirst( "^0*", "");
                    CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_MYSQL);
                    List<User> users=userMapper.listUser(Studentcode);
                    if(users.size()==0){
                        return ServerReponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
                    }
                    return ServerReponse.createBySuccessMsg("登录成功");
                }else{
                    return ServerReponse.createByErrorMessage("传入参数错误");
                }
            }else{
                return ServerReponse.createByErrorMessage("账号或密码错误");
            }
        }else{
            return ServerReponse.createByErrorMessage("第三方初始化失败");
        }
    }

    /**
     * 获取list
     * @param accountNo
     * @param password
     * @return
     */
    public ServerReponse getList(int accountNo, String password)  {
        int i=getInit3();
        if(i==0){
            //第三方初始化成功
            int j=ns.TA_CheckQpwd(accountNo,password);
            if(j==0){
                //账号密码正确，当账号密码正确的时候就把账号传入到查询账户信息的函数
                Test.AccountMsg.ByReference accountMsg1=new Test.AccountMsg.ByReference();
                accountMsg1.AccountNo=Test.int2byte(accountNo);
                int x=ns.TA_InqAcc(accountMsg1,(short)10);
                if(x==0){
                    //说明正确，可以获取到studentcode，传入查询的函数就可以了
                    String Studentcode= null;
                    String Studentcode1= null;
                    try {
                        Studentcode = Test.transToString(accountMsg1.StudentCode).trim();
                        Studentcode1 =Studentcode.replaceFirst( "^0*", "");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    List<UserVo> userListVoList= getList(Studentcode1);
                    return ServerReponse.createBySuccess("查询成功",userListVoList);

                }else{
                    return ServerReponse.createByErrorMessage("传入参数错误");
                }


            }else{
                return ServerReponse.createByErrorMessage("账号或密码错误");
            }
        }else{
            return ServerReponse.createByErrorMessage("第三方初始化失败");
        }
    }

    public ServerReponse init(){
        boolean[] booleans={false};
        long[] longs={1000};
        int i=ns.TA_Init3("218.197.98.75", (short) 8500,(short) 63,(short) 1,booleans,longs,"123");
        if(i==0){
            //初始化第三方库成功
            int a = ns.TA_CRInit((byte)0,1,19200);
            if(a==0){
                //读卡器初始化成功，开始读卡
                return ServerReponse.createBySuccess(true);
            }else{
                return ServerReponse.createByErrorMessage("读卡器初始化失败");
            }
        }else{
            return ServerReponse.createByErrorMessage("网络连接失败");
        }
    }

    public ServerReponse readIC() throws UnsupportedEncodingException {
        Test.AccountMsg.ByReference accountMsg=new Test.AccountMsg.ByReference();
        int k=ns.TA_ReadCardSimple(accountMsg);
        if(k==0){
            String code=Test.transToString(accountMsg.StudentCode).trim();
            CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_MYSQL);
            List<User> users=userMapper.listUser(code);
            if(users.size()>0){
                return ServerReponse.createBySuccess("人员代码读取成功",code);
            }else{
                return ServerReponse.createByErrorMessage("非离退休人员");
            }
        }else{
            return ServerReponse.createByErrorMessage("读取信息失败");
        }
    }

    public ServerReponse readICNew() throws UnsupportedEncodingException {
        Test.AccountMsg.ByReference accountMsg=new Test.AccountMsg.ByReference();
        int k=ns.TA_ReadCardSimple(accountMsg);
        if(k==0){
            int accountNo=Test.byteArrayToInt(accountMsg.AccountNo);
            Test.AccountMsg.ByReference accountMsg1=new Test.AccountMsg.ByReference();
            accountMsg1.AccountNo=Test.int2byte(accountNo);
            int x=ns.TA_InqAcc(accountMsg1,(short)10);
            if(x==0){
                String code1 = Test.transToString(accountMsg1.StudentCode).trim();
                String code =code1.replaceFirst( "^0*", "");
                CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_MYSQL);
                List<User> users=userMapper.listUser(code);
                if(users.size()>0){
                    return ServerReponse.createBySuccess("人员代码读取成功",code);
                }else{
                    return ServerReponse.createByErrorMessage("非离退休人员");
                }
            }else{
                return ServerReponse.createByErrorMessage("传入参数错误");
            }
        }else{
            return ServerReponse.createByErrorMessage("读取信息失败");
        }
    }




}
