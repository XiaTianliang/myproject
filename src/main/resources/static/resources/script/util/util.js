function popupOpen(target, openCallBack, closeCallBack) {
    $.magnificPopup.open({
        removalDelay: 100,
        closeOnBgClick: false,
        enableEscapeKey: false,
        items: {
            src: target,
            type: 'inline'
        },
        callbacks: {
            open: openCallBack,
            close: closeCallBack
        }
    });
}

function popupClose(){
    //close current popup
    $.magnificPopup.close();
}

function translate(message){
    console.log(message);
    message=message.replace(/\</g,'&lt;');
    message=message.replace(/\>/g,'&gt;');
    message=message.replace(/\"/g,'&quot;');
    console.log(message);
    return message;
}

Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1,                 //月份
        "d+": this.getDate(),                    //日
        "h+": this.getHours(),                   //小时
        "m+": this.getMinutes(),                 //分
        "s+": this.getSeconds(),                 //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds()             //毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

function swalSuccess(message){
    swal({
        type: 'success',
        title: translate(message),
        timer: 1000
    }).done();
}

function swalFailure(response){
    swal({
        type: 'error',
        title: 'Error',
        text: translate(response.data.message)
    });
}
