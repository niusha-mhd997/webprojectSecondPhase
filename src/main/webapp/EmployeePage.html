

if(localStorage.getItem("role")==="employee"){

}else{
    alert(localStorage.getItem("role")+" شما دسترسی لازم را ندارید! ");
    window.open("FirstPage.html", "_parent");
}


function myFunction() {


    var name = localStorage.getItem("name");
    var email = localStorage.getItem("email");
    var password = localStorage.getItem("password");
    document.getElementById("nameofuser").innerHTML = "نام: "+name;
    document.getElementById("emailofuser").innerHTML = "ایمیل: "+email;

    var token = localStorage.getItem("token");
    var toppings;
    var toppings2;

    var settings = {
        "async": true,
        "crossDomain": true,
        "url": "rest/employee/getEmployeeCasesByToken/"+token+"/"+true,
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

            toppings[f][0]=response[f].id;
            toppings[f][1]=response[f].date;
            toppings[f][2]=response[f].subject;
            toppings[f][3]="مشاهده";

        }
        if (toppings.length !== 0) {

            var table = document.getElementById("table2");
            table.deleteRow(1);
            for (var i = 0; i < toppings.length; i++) {
                //localStorage.setItem("i",i);
                var rowItem = document.createElement("tr");
                for (var j = 0; j < 4; j++) {
                    var tableItem = document.createElement("td");
                    tableItem.textContent = toppings[i][j];
                    if (j === 3) {
                        tableItem.className = "choose";
                        tableItem.id = "choose";
                    }
                    rowItem.appendChild(tableItem);
                }

                table.appendChild(rowItem);
            }

            for (var m = 0; m <= toppings.length; m++) {
                table.rows[m].cells[3].addEventListener("click", function(m) {
                    alert(m + " " + toppings[m-1][0]+ " " + toppings[m-1][1]+ " " + toppings[m-1][2]);
                   window.open("SendAnswerToUser.html?token:"+toppings[m-1][0],"_parent");
                }.bind(null, m));

            }

        }
    });





    var settings2 = {
        "async": true,
        "crossDomain": true,
        "url": "rest/employee/getEmployeeCasesByToken/"+token+"/"+false,
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

            toppings2[f][0]=response[f].id;
            toppings2[f][1]=response[f].date;
            toppings2[f][2]=response[f].subject;
            toppings2[f][3]="مشاهده";

        }
        if (toppings2.length !== 0) {

            var table2 = document.getElementById("table1");
            table2.deleteRow(1);
            for (var i = 0; i < toppings2.length; i++) {
                //localStorage.setItem("i",i);
                var rowItem = document.createElement("tr");
                for (var j = 0; j < 4; j++) {
                    var tableItem = document.createElement("td");
                    tableItem.textContent = toppings2[i][j];
                    if (j === 3) {
                        tableItem.className = "choose";
                        tableItem.id = "choose";
                    }
                    rowItem.appendChild(tableItem);
                }

                table2.appendChild(rowItem);
            }

            for (var m = 0; m <= toppings2.length; m++) {
                table2.rows[m].cells[3].addEventListener("click", function(m) {
                    alert(m + " " + toppings2[m-1][0]+ " " + toppings2[m-1][1]+ " " + toppings2[m-1][2]);
                    window.open("SendAnswerToUser.html?token:"+toppings2[m-1][0],"_parent");
                }.bind(null, m));

            }

        }
    });


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



function clearcache() {

    localStorage.setItem("name", "0");
    localStorage.setItem("email", "0");
    localStorage.setItem("password", "0");
    localStorage.setItem("token", "0");
    window.open("index.html","_parent");

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
