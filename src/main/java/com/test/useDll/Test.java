package com.test.useDll;

import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.win32.StdCallLibrary;


import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static Dll ns = null;
    //加载总的动态库
    static{
        ns =(Dll) Native.loadLibrary("AIO_API",Dll.class);
    }
    public interface Dll extends StdCallLibrary {
        //设置动态库以第三方方式运行
        int TA_Init3(String IP, short port, short SysCode, short TerminalNo, boolean[] ProxyOffline, long[] MaxJnl, String signonPWD);
        //根据账号验证查询密码
        int TA_CheckQpwd(int accountno, String qpwd);
        // 根据帐号/卡号/学工号/证件号精确查询帐户信息
        int TA_InqAcc(AccountMsg.ByReference struct, short Timeout);
        // 简单读卡信息，不检验白名单。
        int TA_ReadCardSimple(AccountMsg.ByReference struct);
        // 初始化读卡器
        int TA_CRInit(byte CardReaderType, int port, long Baud_Rate);
        //关闭读卡器
        boolean TA_CRClose();
    }
    //定义AccountMsg结构体
   public static class AccountMsg extends Structure {
       public byte[] Name = new byte[21];
       public byte[] SexNo= new byte[2];
       public byte[] DeptCode= new byte[19];
       public byte[] CardNo=new byte[4];
       public byte[] AccountNo=new byte[4];
       public byte[] StudentCode= new byte[21];
       public byte[] IDCard= new byte[21];
       public byte[] PID= new byte[3];
       public byte[] IDNo= new byte[13];
       public int Balance;
       public byte[] Password= new byte[7];
       public byte[] ExpireDate= new byte[7];
       public short SubSeq;
       public byte IsOpenInSys;
       public short TerminalNo;
       public short RetCode;
       public byte[] Flag= new byte[16];
       public byte[] CardType= new byte[4];
       public byte[] AccType= new byte[4];
       public short UsedCardNum;
       public long AccAmt;
       public int bUseInternalAuth;
       public byte[] Pad= new byte[69];
       public static class ByReference extends AccountMsg implements Structure.ByReference { }
       public static class ByValue extends AccountMsg implements Structure.ByValue{ }
       @Override
       protected List<String> getFieldOrder() {
           return Arrays.asList(new String[]{"Name", "SexNo", "DeptCode", "CardNo",
        		   "AccountNo","StudentCode","IDCard","PID","IDNo","Balance","Password",
        		   "ExpireDate","SubSeq","IsOpenInSys","TerminalNo","RetCode","Flag",
        		   "CardType","AccType","UsedCardNum","AccAmt","bUseInternalAuth","Pad"});
       }
   }

    public static String transToString(byte[] bytes) throws UnsupportedEncodingException {
       String str=new String(bytes,"gbk");
       return str;
    }
    public static byte[] int2byte(int res) {
        byte[] targets = new byte[4];

        targets[0] = (byte) (res & 0xff);// 最低位
        targets[1] = (byte) ((res >> 8) & 0xff);// 次低位
        targets[2] = (byte) ((res >> 16) & 0xff);// 次高位
        targets[3] = (byte) (res >>> 24);// 最高位,无符号右移。
        return targets;
    }
    public static int byteArrayToInt(byte[] b){
        byte[] a = new byte[4];
        int i = a.length - 1,j = b.length - 1;
        for (; i >= 0 ; i--,j--) {//从b的尾部(即int值的低位)开始copy数据
            if(j >= 0)
                a[i] = b[j];
            else
                a[i] = 0;//如果b.length不足4,则将高位补0
        }
        int v0 = (a[3] & 0xff) << 24;//&0xff将byte值无差异转成int,避免Java自动类型提升后,会保留高位的符号位
        int v1 = (a[2] & 0xff) << 16;
        int v2 = (a[1] & 0xff) << 8;
        int v3 = (a[0] & 0xff) ;
        return v0 + v1 + v2 + v3;
    }
}
