
if(localStorage.getItem("role")==="manager"){

}else{
    alert(localStorage.getItem("role")+" شما دسترسی لازم را ندارید! ");
    window.open("FirstPage.html", "_parent");
}


function myFunction() {


    document.getElementById("nameofuser").innerHTML = "پنل مدیریت سایت";
    document.getElementById("emailofuser").innerHTML = "manager@gmail.com";


    var toppings;
    var toppings2;

    var settings = {
        "async": true,
        "crossDomain": true,
        "url": "rest/manager/getnotacceptedemps",
        "method": "GET",
        "headers": {
            "content-type": "application/x-www-form-urlencoded",
            "cache-control": "no-cache"
        }
    };

    $.ajax(settings).done(function (response) {


        console.log(response);
        var t = response.length;
        toppings=createArray(t, 5);
        for (var f= 0;f<response.length;f++){

            toppings[f][0]=response[f].name;
            toppings[f][1]=response[f].email;
            toppings[f][2]=response[f].semat;
            toppings[f][3]="تایید";

        }


        if (toppings.length !== 0) {

            var table = document.getElementById("table1");
            table.deleteRow(1);
            for (var i = 0; i < toppings.length; i++) {
                var rowItem = document.createElement("tr");
                for (var j = 0; j < 4; j++) {
                    var tableItem = document.createElement("td");
                    tableItem.textContent = toppings[i][j];
                    if (j === 3) {
                        tableItem.className = "choose";
                        tableItem.onclick=f1;
                    }
                    rowItem.appendChild(tableItem);
                }

                table.appendChild(rowItem);
            }
        }


    });









    var settings2 = {
        "async": true,
        "crossDomain": true,
        "url": "rest/manager/getnacceptedemps",
        "method": "GET",
        "headers": {
            "content-type": "application/x-www-form-urlencoded",
            "cache-control": "no-cache"
        }
    };

    $.ajax(settings2).done(function (response) {

        console.log(response);
        var t = response.length;
        toppings2=createArray(t, 5);
        for (var f= 0;f<response.length;f++){

            toppings2[f][0]=response[f].name;
            toppings2[f][1]=response[f].email;
            toppings2[f][2]=response[f].semat;

        }

        if (toppings2.length !== 0) {

            var table = document.getElementById("table2");
            table.deleteRow(1);
            for (var i = 0; i < toppings2.length; i++) {
                var rowItem = document.createElement("tr");
                for (var j = 0; j < 3; j++) {
                    var tableItem = document.createElement("td");
                    tableItem.textContent = toppings2[i][j];

                    rowItem.appendChild(tableItem);
                }

                table.appendChild(rowItem);
            }
        }



    });





}




function f1() {
    location.replace("SendAnswerToUser.html")
}


function date() {
    n = new Date();
    y = n.getFullYear();
    m = n.getMonth() + 1;
    d = n.getDate();
    h = n.getHours();
    min = n.getMinutes();
    document.getElementById("date-time").innerHTML = m + "/" + d + "/" + y + "&nbsp &nbsp &nbsp" + h + " : " + min;
}

function show() {
    var elem = document.getElementById("verNav");
    elem.style.display = "block";
    document.getElementById("menubar").style.display = "none";
}

function manager() {
    document.getElementById("others").style.visibility="hidden";
    document.getElementById("manager").style.visibility="visible";

}


function createArray(length) {
    var arr = new Array(length || 0),
        i = length;

    if (arguments.length > 1) {
        var args = Array.prototype.slice.call(arguments, 1);
        while(i--) arr[length-1 - i] = createArray.apply(this, args);
    }

    return arr;
}
