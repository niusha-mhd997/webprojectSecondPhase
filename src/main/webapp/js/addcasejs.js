function myFunction() {


    var name = localStorage.getItem("name");
    var email = localStorage.getItem("email");
    var password = localStorage.getItem("password");
    document.getElementById("nameofuser").innerHTML = "نام: " + name;
    document.getElementById("emailofuser").innerHTML = "ایمیل: " + email;
    var token = localStorage.getItem("token");

    var toppings = ["آقای امینی مسوول آزمایشگاه", "آقای یزدی مسوول سایت", "خانم رضایی مسوول آموزش",
        "خانم اصفهانی مسوول کلاس ها"];

    var ul = document.getElementById("asami");

    for (var i = 0; i < toppings.length; i++) {
        var topping2 = toppings[i];

        var topping = "  " + toppings[i];
        var listItem = document.createElement("li");
        listItem.tabindex = "1";

        var divItem = document.createElement("div");
        divItem.className = "cases-item-li";
        divItem.ID = "listdiv";

        var imgItem = document.createElement("img");
        imgItem.className = "imgc";
        imgItem.style = "background: #00cc00";
        imgItem.src = "img/avatar.png";


        var spanItem = document.createElement("span");
        spanItem.style = "color: #0b2e13";
        spanItem.innerHTML = topping;

        //xhx beshavad haman email
        //spanItem.xhx = i;


        divItem.appendChild(imgItem);
        divItem.appendChild(spanItem);

        listItem.appendChild(divItem);

        ul.appendChild(listItem);

    }


    document.getElementById('asami').addEventListener('click', function (e) {
        var selected;

        if (e.target.tagName === 'DIV') {
            selected = document.querySelector('div.selected');
            if (selected) selected.className = 'cases-item-li';
            e.target.className = 'selected';
            masool_name = e.target.getElementsByTagName("span")[0].innerHTML;
            // masool_name = e.target.getElementsByTagName("span")[0].xhx;
        }
    });


}


function myNewFunction(sel) {
    mozoo = sel.options[sel.selectedIndex].text;
}


var mozoo = "شکایت";
var matn;
var file;
var masool_name;
var receiver_name;


function send() {

    if (masool_name == undefined) {

        alert("کاربر مسوول رسیدگی را انتخاب کنید");

    }

    else {

        //matn = document.getElementById('matn_eteraz').value;

        //alert(masool_name);

        var e = document.getElementById("noe");
        var type = e.options[e.selectedIndex].value;

        var settings = {
            "async": true,
            "crossDomain": true,
            "url": "http://localhost:8080/contacts/rest/student/addcase",
            "method": "POST",
            "headers": {
                "content-type": "application/x-www-form-urlencoded",
                "cache-control": "no-cache"
            },
            "data": {
                "subject": type,
                "description": document.getElementById('matn_eteraz').value,
                "receiver": "admin@gamil.com",
                "senderemail": localStorage.getItem("email"),
                "senderpassword": localStorage.getItem("password")
            }
        };

        $.ajax(settings).done(function (response) {
            console.log(response);
            alert("درخواست شما با موفقیت ثبت شد");
            window.open("http://localhost:8080/contacts/StudentPage.html", "_parent");
        });


    }


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
    window.open("http://localhost:8080/contacts/index.html", "_parent");

}
