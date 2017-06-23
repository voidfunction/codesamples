


$(function () {
    if (document.getElementById('FirebugLite')) {
        E = document['createElement' + 'NS'] && document.documentElement.namespaceURI;
        E = E ? document['createElement' + 'NS'](E, 'script') : document['createElement']('script');
        E['setAttribute']('id', 'FirebugLite');
        E['setAttribute']('src', 'https://getfirebug.com/' + 'firebug-lite.js' + '#startOpened');
        E['setAttribute']('FirebugLite', '4');
        (document['getElementsByTagName']('head')[0] || document['getElementsByTagName']('body')[0]).appendChild(E);
        E = new Image;
        E['setAttribute']('src', 'https://getfirebug.com/' + '#startOpened');
    }

    $('#mybutton').click(function () {
        $('#myp').text(key);
        $('#myp2').text(util.getString());
    })

    $('#mybt2').dblclick(function () {
        // util.openDefaultBrowser('https://www.baidu.com/');
        var xmlHttp = new XMLHttpRequest();
        xmlHttp.timeout = 60 * 100;
        xmlHttp.open('GET', "http://localhost:1234/applications", true);
        // xmlHttp.setRequestHeader("Access-Control-Request-Headers", "*");
        xmlHttp.setRequestHeader('http-type', 'spark');
        xmlHttp.setRequestHeader('cluster-name', 'cluster');
        xmlHttp.send(null);
    });
})
