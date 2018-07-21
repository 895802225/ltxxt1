var timeup = 0,timeup2=0, timedown = 0, choose = 0, flag = 0;
var status="";
var status1="";
var LODOP;
var md_overlayMain=document.getElementById("md-overlayMain");


function split_array(arr,len){
    var a_len=arr.length;
    var result=[];
    for(var i=0;i<a_len;i+=len){
        result.push(arr.slice(i,i+len));
    }
    return result;
 }

var inshow;
var inwritedata;
 function view(data){
     // 详情点击这里函数
     function show2(i) {

         xiangxihtml=   '<p class="specificTitle"><span>'+data[i].user.year+'</span>年'+
             '<span >'+data[i].user.month+'</span>月工资明细 </p>'+
             '<img id="close" src="image/close.png" style="display: inline-block;float:right;margin-right:5px; margin-top:5px" />'+
             '<table class="table table-striped table-bordered table-hover" id="more">'+
             '<tbody>' +
             '<tr><td>姓名</td> <td>'+data[i].user.username+ '</td></tr>' +
             '<tr><td>人员代码</td> <td>'+data[i].user.code+ '</td></tr>' +
             '<tr><td>离退休费</td><td>'+Number(data[i].user.money)+ '</td></tr>' +
             '<tr><td>生活补贴</td><td>'+Number(data[i].user.lifesub)+ '</td></tr>' +
             '<tr><td>保留补贴</td><td>'+Number(data[i].user.retirementsub)+ '</td></tr>' +
             '<tr><td>住房补贴</td><td>'+Number(data[i].user.housesub)+ '</td></tr>' +
             '<tr><td>劳模津贴</td><td>'+Number(data[i].user.laboursub)+ '</td></tr>' +
             '<tr><td>教护龄贴</td><td>'+Number(data[i].user.rescuesub)+ '</td></tr>' +
             '<tr><td>政府特贴</td><td>'+Number(data[i].user.goversub)+ '</td></tr>' +
             '<tr><td>物业补贴</td><td>'+Number(data[i].user.propertysub)+ '</td></tr>' +
             '<tr><td>护理费</td><td>'+Number(data[i].user.nursemoney)+ '</td></tr>' +
             '<tr><td>女工补贴</td><td>'+Number(data[i].user.worksub)+ '</td></tr>' +
             '<tr><td>补发</td><td>'+Number(data[i].user.reissue)+ '</td></tr>' +
             '<tr><td>预补扣</td><td>'+Number(data[i].user.relief)+ '</td></tr>' +
             '<tr><td>社保预调16</td><td>'+Number(data[i].user.insurance16)+ '</td></tr>' +
             '<tr><td>社保预调17</td><td>'+Number(data[i].user.insurance17)+ '</td></tr>' +
             '<tr><td>应发合计</td><td>'+Number(data[i].user.sum)+ '</td></tr>' +
             '<tr class="red"><td>水费</td><td>-'+Number(data[i].user.watercost)+ '</td></tr>' +
             '<tr class="red"><td>电费</td><td>-'+Number(data[i].user.electriccost)+ '</td></tr>' +
             '<tr class="red"><td>房租</td><td>-'+Number(data[i].user.rent)+ '</td></tr>' +
             '<tr class="red"><td>其他扣款</td><td>-'+Number(data[i].user.otherrent)+ '</td></tr>' +
             '<tr><td>实发合计</td><td>'+Number(data[i].user.realsum)+ '</td></tr>' +
             '</tbody>'+
             '</table>'
         $("#specificMsg").html(xiangxihtml);
         specificMsg.style.display="block";
         md_overlayMain.style.display="block";
         var close =document.getElementById("close");
         // 详情隐藏函数
         close.onclick=function(){
                     specificMsg.style.display="none";
                     md_overlayMain.style.display="none";
                 }
     }
     // 写入数据库函数
     function writedata() {
         $.each(data, function (i, user){
             if(print_btn[i].style.backgroundColor=="rgb(67, 205, 128)"){
                 print_btn[i].style.backgroundColor="gray";
                 timeup+=1;
                 timeup2=timeup;
                 var s=data[i].user.month;
                 s=s.replace(/\b(0+)/gi,"");
                 data[i].count="1";
                 $.ajax({
                     url: "print/insert.do",
                     type: "POST",
                     async: false,
                     data: {code:data[i].user.code,year:data[i].user.year,month:s,count:"1"},
                     success: function (res) {

                     }
                 })
             }
         })
     }
     // 打印拼接函数
     function printDetail1() {
         var timenow=getNowDate();
         xiangxihtml1='<p>'+timenow+'</p>';
         $.each(data, function (i, user){
             if(print_btn[i].style.backgroundColor=="rgb(67, 205, 128)"){
                 //拼接打印
                 var md_overlayMain=document.getElementById("md-overlayMain");
                 xiangxihtml1+=
                     '<table class="table table-striped table-bordered table-hover" id="more">'+
                     '<thead>'+data[i].user.year+'年'+ +data[i].user.month+'月工资明细 </thead>'+
                     '<tbody>' +
                     '<tr><td>姓名</td> <td>'+data[i].user.username+ '</td></tr>' +
                     '<tr><td>人员代码</td> <td>'+data[i].user.code+ '</td></tr>' +
                     '<tr><td>离退休费</td><td>'+Number(data[i].user.money)+ '</td></tr>' +
                     '<tr><td>生活补贴</td><td>'+Number(data[i].user.lifesub)+ '</td></tr>' +
                     '<tr><td>保留补贴</td><td>'+Number(data[i].user.retirementsub)+ '</td></tr>' +
                     '<tr><td>住房补贴</td><td>'+Number(data[i].user.housesub)+ '</td></tr>' +
                     '<tr><td>劳模津贴</td><td>'+Number(data[i].user.laboursub)+ '</td></tr>' +
                     '<tr><td>教护龄贴</td><td>'+Number(data[i].user.rescuesub)+ '</td></tr>' +
                     '<tr><td>政府特贴</td><td>'+Number(data[i].user.goversub)+ '</td></tr>' +
                     '<tr><td>物业补贴</td><td>'+Number(data[i].user.propertysub)+ '</td></tr>' +
                     '<tr><td>护理费</td><td>'+Number(data[i].user.nursemoney)+ '</td></tr>' +
                     '<tr><td>女工补贴</td><td>'+Number(data[i].user.worksub)+ '</td></tr>' +
                     '<tr><td>补发</td><td>'+Number(data[i].user.reissue)+ '</td></tr>' +
                     '<tr><td>预补扣</td><td>'+Number(data[i].user.relief)+ '</td></tr>' +
                     '<tr><td>社保预调16</td><td>'+Number(data[i].user.insurance16)+ '</td></tr>' +
                     '<tr><td>社保预调17</td><td>'+Number(data[i].user.insurance17)+ '</td></tr>' +
                     '<tr><td>应发合计</td><td>'+Number(data[i].user.sum)+ '</td></tr>' +
                     '<tr><td>水费</td><td>'+Number(data[i].user.watercost)+ '</td></tr>' +
                     '<tr><td>电费</td><td>'+Number(data[i].user.electriccost)+ '</td></tr>' +
                     '<tr><td>房租</td><td>'+Number(data[i].user.rent)+ '</td></tr>' +
                     '<tr><td>其他扣款</td><td>'+Number(data[i].user.otherrent)+ '</td></tr>' +
                     '<tr><td>实发合计</td><td>'+Number(data[i].user.realsum)+ '</td></tr>' +
                     '</tbody>'
             }
     })
         $("#specificMsg").html(xiangxihtml1);
     }


     inshow=show2;
     inwritedata=writedata;
     printDetail=printDetail1;
     var mediahtml="",nextdiahtml="";
     // 加载分页数据
     $.each(data, function (i, user){
        mediahtml += "<tr>" +
            "<td>" + data[i].user.year + "</td>" +
            "<td>" + data[i].user.month + "</td>" +
            "<td>" + data[i].user.username + "</td>" +
            "<td>" + data[i].user.sum + "</td>" +
            "<td>" + data[i].user.realsum + "</td>" +
            "<td onclick='inshow("+i+")'>详情点击这里</td>" ;
        if(data[i].count=="0") {
            nextdiahtml = "<td><div class='print_btn'></div></td>" +
                "</tr>";
        }else{
            nextdiahtml = "<td><div class='print_btn' style='background-color: gray'></div></td>" +
                "</tr>";
        }
        mediahtml+=nextdiahtml;
     }
     )
    $('#moneylist').html(mediahtml);
     //打印button函数
     var allChoose = document.getElementById("allChoose");
     var print = document.getElementById("print");
     var print_btn = document.getElementsByClassName("print_btn");
     timeup=0;
     timeup2=0;
     allChoose.innerHTML="全选";
     for (var i = 0; i < print_btn.length; i++) {
         print_btn[i].flag=0;
         print_btn[i].onclick = function () {
             var _this=this;
             if (_this.style.backgroundColor=="gray"){
                 _this.flag=1;
                 alert("此条已被打印","1000");
             }else {
                 //绿色变空
                 if(_this.style.backgroundColor=="rgb(67, 205, 128)") {
                     _this.flag = 0;
                     _this.style.background = null;
                     // 空变绿
                 } else{
                       _this.style.background="#43CD80";
                     }
                 }
             }
             }

     allChoose.onclick = function () {
         if (choose == 0) {
             for (var i = 0; i < print_btn.length; i++) {
                 if (print_btn[i].style.backgroundColor != "gray"){
                     print_btn[i].style.background = "#43CD80";
                     print_btn[i].flag = 1;
                 }
                 timeup = print_btn.length;
                 choose = 1;

             }
         } else if (choose == 1) {
             for (var i = 0; i < print_btn.length; i++) {
                 if (print_btn[i].style.backgroundColor != "gray") {
                     print_btn[i].style.background = null;
                     print_btn[i].flag = 0;
                 }
                 timeup = timeup2;
                 choose = 0;
             }
         }
     }
 }
  /* ajax 请求更新数据 */
 function sendAjax(page,size)  {
     var url = '';
     var result = split_array(list1,8);
     view(result[page - 1]);
 }
   // 判断是否打印成功
 function printarea(){
    // LODOP.SET_PRINT_MODE("CONTROL_PRINTER","PURGE")
     $("#beep-two")[0].play();
     CreateOneFormPage();
     // LODOP.PREVIEW();
     // console.log(222);
     LODOP.SET_PRINT_MODE("CATCH_PRINT_STATUS",true);
     if (LODOP.CVERSION) {
         LODOP.On_Return=function(TaskID,Value){
             status=Value;
             console.log(status);
             var statustime=0;
             var printtime=setInterval(function(){
                 getStatusValue('PRINT_STATUS_EXIST',status,document.getElementById('T1'));
                 statustime=statustime+1;
                 console.log(statustime);
                 setTimeout(function(){
                     status1=document.getElementById('T1').value;
                     console.log(status1+"主函数");
                     if(status1==0){
                         inwritedata();
                         alert("打印成功","1000");
                         // zjw=true;
                         // timeUserFun(0.5);
                         md_overlayMain.style.display="none";
                         window.clearInterval(printtime);
                     }else if(statustime>=7) {
                         statustime=0;
                         LODOP.SET_PRINT_MODE("CONTROL_PRINTER:T90","PURGE");
                         md_overlayMain.style.display="none";
                         alert("缺纸或故障,请联系工作人员","5000");
                         window.clearInterval(printtime);
                     }
                 },1000)
             },2000);

         }
         LODOP.SET_PRINT_PAGESIZE(3,800,300,1);//这里3表示纵向打印且纸高“按内容的高度”；800表示纸宽80mm；45表示页底空白4.5mm
         // LODOP.PREVIEW();
         LODOP.PRINT();
         return;
     }
     else{
         status=LODOP.PRINT();
     }
 }
 // 判断成功的子函数
function CreateOneFormPage(){
    LODOP=getLodop();
    //LODOP.SET_PRINT_MODE("CONTROL_PRINTER","PURGE");
    // LODOP.ADD_PRINT_TEXT(50,231,260,39,"打印页面部分内容");
    var strBodyStyle="<style>"+document.getElementById("style1").innerHTML+"</style>";
    var strFormHtml=strBodyStyle+"<body>"+document.getElementById("specificMsg").innerHTML+"</body>";
    LODOP.ADD_PRINT_HTM(10,60,"100%","100%",strFormHtml);
}


// function statusOK(){
// 	document.getElementById('T2').value=getStatusValue('PRINT_STATUS_OK',document.getElementById('T1').value,document.getElementById('T2'));

// }
function getStatusValue(ValueType,ValueIndex,oResultOB){
    LODOP=getLodop();
    if (LODOP.CVERSION)
        LODOP.On_Return=function(TaskID,Value){
            oResultOB.value=Value;
            // oResultOB=value;
            // status1=oResultOB;
            console.log(oResultOB.value+"子函数");
        };
    var strResult=LODOP.GET_VALUE(ValueType,ValueIndex);
    if (!LODOP.CVERSION)
        return strResult;
    else
        return "";
};

