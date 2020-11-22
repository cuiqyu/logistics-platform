/**
 * Created by chenmingkang on 15/11/25.
 */
$(function(){
    $('#leftMenu .panel-heading').click(function(){
        $(this).next('.panel-collapse').toggle();
        $(this).find('.arrow').toggleClass('panel-hide');
    });

    $('.content').css({
        "min-height" : document.documentElement.clientHeight - $('.header').height() - 22 - $('.footer').height() - 70
    });

    try {
        var urlhash = window.location.hash;
        if (!urlhash.match("fromapp")) {
            if ((navigator.userAgent.match(/(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i))) {
                $('.content,.pc-web').removeClass('container').addClass('container-fluid');
                //手机计算font-size
                document.documentElement.style.fontSize = document.documentElement.clientWidth / 7.5+ 'px';
            }
        }else{
            $('.content,.pc-web').removeClass('container-fluid').addClass('container')
        }
    } catch (err) {
    }

    function resize(){   //右侧联系我们
        var $contact = $('#contact');
        var $setOrder=$("")
        var $contactWidth = $contact.width();
        if($('body').width() > 1400 + $contactWidth + 150){   //150是contact这个弹出层宽度
            $contact.removeClass('m-contact').css({
                'right' : '0',
                'display' : 'block',
                // 'margin-left' : $("#footerContainer").width() / 2 + $contactWidth
                'margin-right' : 5
            });
        }else{
            $contact.addClass('m-contact').css({
                'left' : 'inherit',
                'display' : 'block'
            });
        }
    };
    resize();
    $(window).on('resize',resize);
});
