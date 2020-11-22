function messageTip(o,callback){
    var option={
        template:'',
        parentElem:'',
        class:'',
        callback:function(){
            console.log("close1")
        }

    }
    $.extend(option,o);

    var parentElem=$(option.parentElem);
    var template=option.template;

    parentElem.append(template);
    function close(){
        console.log("close")
    }
     return
    //return messageTip;
}

function getCurrentData() {
    // 获取当前日期
    var date = new Date();
    var nowMonth = date.getMonth() + 1;
    var strDate = date.getDate();
    var seperator = "-";

    // 对日期进行处理，1-9月在前面添加一个“0”
    if (nowMonth >= 1 && nowMonth <= 9) {
        nowMonth = "0" + nowMonth;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }

    var nowDate = date.getFullYear() + seperator + nowMonth + seperator + strDate;
    return nowDate
}