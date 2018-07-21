
function alert(e,alerttime){
    $("body").append("<div id='msg' style='z-index: 300'><span>"+e+"</span></div>");
    clearmsg(alerttime);
}
function clearmsg(alerttime){
    var t = setTimeout(function(){
        $("#msg").remove();
    },alerttime)
};