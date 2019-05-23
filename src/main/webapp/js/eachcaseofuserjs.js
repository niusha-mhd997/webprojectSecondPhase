function show() {


    var elem = document.getElementById("verNav");
    elem.style.display = "block";
    document.getElementById("menubar").style.display = "none";
}


function myFunction() {


    alert("سزس");



    var name = localStorage.getItem("name");
    // alert(st);


    var email = localStorage.getItem("email");

    var password = localStorage.getItem("password");

    document.getElementById("nameofuser").innerHTML = "نام: " + name;

    document.getElementById("emailofuser").innerHTML = "ایمیل: " + email;


    var token = localStorage.getItem("token");


    var st;

    var queryString = decodeURIComponent(window.location.search);
    queryString = queryString.substring(1);
    var queries = queryString.split("&");
    for (var i = 0; i < queries.length; i++) {
        st = (queries[i]);
    }


    var queryString = (window.location.href).substr((window.location.href).indexOf('?') + 1);

    // "queryString" will now contain kerdesPost=fdasdas%20ad%20asd%20ad%20asdas

    var token = (queryString.split(':'))[1];

    alert(token);


    var settings = {
        "async": true,
        "crossDomain": true,
        "url": "http://localhost:8080/contacts/rest/student/getCaseByCaseToken/" + token,
        "method": "GET",
        "headers": {
            "content-type": "application/x-www-form-urlencoded",
            "cache-control": "no-cache"
        }
    };

    $.ajax(settings).done(function (response) {
        console.log(response);

        var matn = response.description;
        var subject = response.subject;
        var date = response.date;
        var statuss = response.statuss;

        alert(matn);

    });


    $.ajax(settings).fail(function (jqXHR, textStatus) {
        alert("failed:  " + jqXHR + "  " + textStatus);
    });


}