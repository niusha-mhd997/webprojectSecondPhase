

function myFunction() {


    var name = localStorage.getItem("name");
    var email = localStorage.getItem("email");
    var password = localStorage.getItem("password");
    document.getElementById("nameofuser").innerHTML = "نام: "+name;
    document.getElementById("emailofuser").innerHTML = "ایمیل: "+email;

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

    var settings = {
        "async": true,
        "crossDomain": true,
        "url": "rest/student/getCaseByCaseToken/" + token,
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
       var name = response.sender.email;
        var namex = response.sender.name;
        var statuss = response.statuss;
        var javab = response.answer;

        // alert(matn);

        var mozoo = "موضوع مورد ثبت شده: " + subject;
        document.getElementById("mozoo2").innerHTML = mozoo;

        var desc = matn;
        document.getElementById("matn").innerHTML = desc;

        var date2 = "تاریخ ثبت درخواست: " + date;
        document.getElementById("date2").innerHTML = date2;

        var name2 = "ایمیل درخواست دهنده: " + name;
        document.getElementById("name2").innerHTML = name2;

        var name2x = "نام درخواست دهنده: " + namex;
        document.getElementById("name2x").innerHTML = name2x;



        if(!statuss){

            document.getElementById("seconddiv").style.display = "block";
            document.getElementById("sendans").style.display = "block";
            document.getElementById("javab").style.display = "none";

        }else{
            document.getElementById("javab").innerHTML=javab;
        }


    });

}

function show() {
    var elem = document.getElementById("verNav");
    elem.style.display = "block";
    document.getElementById("menubar").style.display = "none";
}


function clearcache() {

    localStorage.setItem("name", "0");
    localStorage.setItem("email", "0");
    localStorage.setItem("password", "0");
    localStorage.setItem("token", "0");
    localStorage.setItem("role", "0");
    window.location.replace("index.html");

}



function sendanswer() {

    var st;

    var queryString = decodeURIComponent(window.location.search);
    queryString = queryString.substring(1);
    var queries = queryString.split("&");
    for (var i = 0; i < queries.length; i++) {
        st = (queries[i]);
    }

    var queryString = (window.location.href).substr((window.location.href).indexOf('?') + 1);
    var casetoken = (queryString.split(':'))[1];
    var emptoken = localStorage.getItem("token");


    var settings = {
        "async": true,
        "crossDomain": true,
        "url": "rest/employee/sendanswertocase/",
        "method": "POST",
        "headers": {
            "content-type": "application/x-www-form-urlencoded",
            "cache-control": "no-cache"
        },
        "data": {
            "casetoken": casetoken,
            "employeetoken": localStorage.getItem("token"),
            "javab": document.getElementById('matn_eteraz').value

        }
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
        alert("پاسخ با موفقیت ارسال شد!");
        window.location.replace("EmployeePage.html");
    });

}
