window.onload = function () {
    var xhr = createCORSRequest('GET', "http://dailydota2.com/match-api");

    if (!xhr) {
        throw new Error('CORS not supported');
    }


    //var ddData = JSON.parse(xhr);

    console.log(xhr);

    document.getElementById("team1").innerHTML = xhr.team1;
    document.getElementById("team2").innerHTML = xhr.team2;
    //document.team1.write(ddData.team1);
    //document.team2.write(ddData.team2);

    function createCORSRequest(method, url) {
        var xhr = new XMLHttpRequest();
        if ("withCredentials" in xhr) {

            // Check if the XMLHttpRequest object has a "withCredentials" property.
            // "withCredentials" only exists on XMLHTTPRequest2 objects.
            xhr.open(method, url, true);

        } else if (typeof XDomainRequest != "undefined") {

            // Otherwise, check if XDomainRequest.
            // XDomainRequest only exists in IE, and is IE's way of making CORS requests.
            xhr = new XDomainRequest();
            xhr.open(method, url);

        } else {

            // Otherwise, CORS is not supported by the browser.
            xhr = null;

        }
        return xhr;
    }

}