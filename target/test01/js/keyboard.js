var CapsLockValue=0;
var curEditName;
var check;
//document.write (' <DIV align=center id=\"softkeyboard\" name=\"softkeyboard\" style=\"position:absolute; left:300px; top:320px; width:517px; z-index:180;display:none\">');
document.write (' <div class=\"softkeyboard\" id=\"softkeyboard\" name=\"softkeyboard\" style=\"display:; \">');
//document.write (' ------数字----');
document.write (' <div class=\"c_panel shuzi\" id=\"shuzi\">');
document.write ('<table  align=\"center\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">');
document.write (' <tr> ');
document.write (' <div><input class="i_button i_button_btn"  onclick=\"changePanl(\'zimu\')\" type=button value=切换字母></div>');
document.write (' </tr>');
document.write (' <tr> ');
document.write (' <td><input class="i_button i_button_num circleBtn" type=button value=\"7\"></td>');
document.write (' <td><input class="i_button i_button_num circleBtn" type=button value=\"8\"></td>');
document.write (' <td><input class="i_button i_button_num circleBtn" type=button value=\"9\"></td>');
document.write (' <td><input class="i_button i_button_num circleBtn" type=button value=\"0\"></td>');
// document.write (' <td><input class="i_button i_button_btn i_button_sz" onclick=\"changePanl(\'zimu\');\" type=button value=符号 ></td>');
document.write (' </tr>');

document.write (' <tr> ');
document.write (' <td><input class="i_button i_button_num circleBtn" type=button value=\"4\"></td>');
document.write (' <td><input class="i_button i_button_num circleBtn" type=button value=\"5\"></td>');
document.write (' <td><input class="i_button i_button_num circleBtn" type=button value=\"6\"></td>');
document.write (' <td><input id="clearAll1" class="i_button i_button_num" type=button  value=清空 ></td>');
// document.write (' <td><input class="i_button i_button_btn i_button_sz" onclick=\"changePanl(\'zimu\');\" type=button value=字母></td>');
document.write (' </tr>');

document.write (' <tr> ');
document.write (' <td><input class="i_button i_button_num circleBtn" type=button value=\"1\"></td>');
document.write (' <td><input class="i_button i_button_num circleBtn" type=button  value=\"2\"></td>');
document.write (' <td><input class="i_button i_button_num circleBtn" type=button value=\"3\"></td>');
document.write (' <td><input id="del1" class="i_button i_button_num " type=button value=\"删除\" onclick=\"backspace();\"></td>');
document.write (' </tr>');
document.write (' </table>');
document.write ('</div>');
//document.write ('--------------------------------------------');


//document.write (' ------字母----');
document.write (' <div class=\"c_panel zimu\" id=\"zimu\"  style=\"display:none;\">');
document.write (' <table  style=\"border-collapse:separate; border-spacing:0 34px;\" align=\"center\" width=\"98%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">');

document.write (' <div><input class="i_button i_button_btn" onclick=\"changePanl(\'shuzi\')\" value=\"切换数字\"></div>');
document.write (' <tr> ');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"q\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"w\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"e\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"r\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"t\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"y\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"u\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"i\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"o\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"p\"></td>');
document.write (' <td><input class="i_button i_button_zz" type=button onClick=\"setCapsLock(this);\" value=\"大写\"></td>');
document.write (' </tr>');
document.write (' <tr> ');
// document.write (' <td><input class="i_button i_button_fh" type=button onClick=\"addValue(\'|\');\" value=\" | \"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"a\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"s\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"d\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"f\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"g\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"h\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"j\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"k\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"l\"></td>');
document.write (' <td><input class="i_button i_button_fh circleBtn" type=button value=\";\"></td>');
// document.write (' <td><input class="i_button i_button_fh" type=button onclick=\"addValue(\':\');\" value=\" : \"></td>');
// document.write (' <td><input class="i_button i_button_fh" type=button onClick=\"addValue(\'}\');\" value=\" } \"></td>');

document.write (' <td><input id="clearAll2" class="i_button i_button_zz" type=button value=清空 ></td>');


document.write (' </tr>');

document.write (' <tr> ');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"z\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"x\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn"  type=button value=\"c\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"v\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"b\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"n\"></td>');
document.write (' <td><input class="i_button i_button_zm circleBtn" type=button value=\"m\"></td>');
document.write (' <td><input class="i_button i_button_fh circleBtn" type=button value=\"<\"></td>');
document.write (' <td><input class="i_button i_button_fh circleBtn" type=button value=\">\"></td>');
document.write (' <td><input class="i_button i_button_fh circleBtn" type=button value=\"/\"></td>');
// document.write (' <td><input class="i_button i_button_fh" type=button onClick=\"addValue(\'?\');\" value=\" ? \"></td>');
document.write (' <td colspan=2><input id="del2" class="i_button i_button_zz" type=button value=\"删除\"></td>');
document.write (' </tr>');

document.write (' </table>');
document.write (' </div>');
//document.write ('--------------------------------------------');
document.write ('</div>');

//给输入的密码框添加新值
// function addValue(newValue)
// {
//     CapsLockValue==0?$(".input_cur").val($(".shuru").val()+ newValue):$(".input_cur").val($(".shuru").val()+ newValue.toUpperCase())
// }
// //清空
// function clearValue()
// {
//     $(".input_cur").val("");
// }
//实现BackSpace键的功能
// function backspace()
// {
//     var longnum=$(".input_cur").val().length;
//     var num ;
//     num=$(".input_cur").val().substr(0,longnum-1);
//     $(".input_cur").val(num);
// }
//显示数字
function changePanl(oj){
    $("#"+oj).siblings("div").hide();
    $("#"+oj).show();
}
//设置是否大写的值
function setCapsLock(o)
{
    if (CapsLockValue==0){
        CapsLockValue=1;
        $(o).val("小写");
        $.each($(".i_button_zm"),function(b, c) {
            $(c).val($(c).val().toUpperCase());
        });
    }else{
        CapsLockValue=0;
        $(o).val("大写");
        $.each($(".i_button_zm"),function(b, c) {
            $(c).val($(c).val().toLowerCase());
        });
    }
}

window.onload=function(){
//	changePanl("zimu");
}

