function myFunction() {


    var arr1 = [
        ["1", "1397/08/03", "شکایت", "مشاهده"]
        , ["2", "1397/10/15", "درخواست", "مشاهده"]
        , ["3", "1397/12/25", "انتقاد" ,"مشاهده"]
    ];

    if (arr1.length !== 0) {

        var table = document.getElementById("table1");
        table.deleteRow(1);
        for (var i = 0; i < arr1.length; i++) {
            var rowItem = document.createElement("tr");
            for (var j = 0; j < 4; j++) {
                var tableItem = document.createElement("td");
                tableItem.textContent = arr1[i][j];
                if (j === 3) {
                    tableItem.className = "choose";
                    tableItem.onclick=f1;
                }
                rowItem.appendChild(tableItem);
            }

            table.appendChild(rowItem);
        }
    }

    var arr2=[
        ["1", "1396/12/3", "پیشنهاد",  "مشاهده"]
        , ["2", "1396/01/20", "پیشنهاد",  "مشاهده"]
        , ["3", "1396/05/03", "درخواست",  "مشاهده"]
        , ["4", "1397/02/03", "انتقاد ", "مشاهده"]

    ];
    if (arr2.length !== 0) {

        var table = document.getElementById("table2");
        table.deleteRow(1);
        for (var i = 0; i < arr2.length; i++) {
            var rowItem = document.createElement("tr");
            for (var j = 0; j < 4; j++) {
                var tableItem = document.createElement("td");
                tableItem.textContent = arr2[i][j];
                if (j === 3) {
                    tableItem.className = "choose";
                    tableItem.onclick=f1;
                }
                rowItem.appendChild(tableItem);
            }

            table.appendChild(rowItem);
        }
    }



}
function othersTable() {
    var othersList=[
        ["1", "1396/12/3", "درخواست", "رسیدگی شده","آقای امینی" ,"مشاهده"]
        , ["2", "1397/01/20", "درخواست", "رسیدگی شده", "خانم اصفهانی","مشاهده"]
        , ["3", "1396/12/3", "شکایت", "در حال رسیدگی ","آقای یزدی" ,"مشاهده"]
        , ["4", "1396/12/3", "پیشنهاد ", "رسیدگی نشده","خانم رضایی", "مشاهده"]

    ];
    if(othersList.length!==0){
        var table = document.getElementById("othersTable");
        table.deleteRow(1);
        for (var i = 0; i < othersList.length; i++) {
            var rowItem = document.createElement("tr");
            for (var j = 0; j < 6; j++) {
                var tableItem = document.createElement("td");
                tableItem.textContent = othersList[i][j];
                if (j === 5) {
                    tableItem.className = "choose";
                    tableItem.onclick=f1;
                }
                rowItem.appendChild(tableItem);
            }

            table.appendChild(rowItem);
        }
    }
}
function newPerson() {
    var newOnes=[
        ["1", "1396/12/3", "حبیب کاظمی", "مسئول کتابخانه" ,"مشاهده"]
        , ["2", "1396/01/20", "مهناز عسگری", "مسئول سایت", "مشاهده"]
        , ["3", "1396/05/03", "فریدون زندی", "مسئول بوفه" ,"مشاهده"]
        , ["4", "1397/02/03", "علی سمیعی","مسئول حراست" ,"مشاهده"]

    ];
    if (newOnes.length !== 0) {

        var table = document.getElementById("membersTable");
        table.deleteRow(1);
        for (var i = 0; i < newOnes.length; i++) {
            var rowItem = document.createElement("tr");
            for (var j = 0; j < 5; j++) {
                var tableItem = document.createElement("td");
                tableItem.textContent = newOnes[i][j];
                if (j === 4) {
                    tableItem.className = "choose";
                    tableItem.onclick=f2;
                }
                rowItem.appendChild(tableItem);
            }

            table.appendChild(rowItem);
        }
    }
}
function oldPerson() {
    var oldOnes=[
        ["1", "1395/12/3", "امید یکتا", "مسئول خدمات" ,"مشاهده"]
        , ["2", "1395/01/20", "نیما مولایی", "مسئول آموزش", "مشاهده"]
        , ["3", "1395/05/03", "فاطمه بهرامی", "معاون آموزشی" ,"مشاهده"]
        , ["4", "1396/02/13", "مهران رسولی","نگهبان" ,"مشاهده"]
        , ["5", "1396/03/23", "فائزه رجبی","معاون اجرایی" ,"مشاهده"]
        , ["6", "1396/05/19", "مریم اصفهانی","معاون اجرایی" ,"مشاهده"]
    ];
    if (oldOnes.length !== 0) {

        var table = document.getElementById("oldMembers");
        table.deleteRow(1);
        for (var i = 0; i < oldOnes.length; i++) {
            var rowItem = document.createElement("tr");
            for (var j = 0; j < 5; j++) {
                var tableItem = document.createElement("td");
                tableItem.textContent = oldOnes[i][j];
                if (j === 4) {
                    tableItem.className = "choose";
                    tableItem.onclick=f3

                }
                rowItem.appendChild(tableItem);
            }

            table.appendChild(rowItem);
        }
    }
}

function f1() {
    location.replace("SendAnswerToUser.html")
}

function f2() {
    location.replace("Accept.html")
}

function f3() {
    location.replace("DeleteUser.html")
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

function changeToOther(){
    document.getElementById("manager").style.visibility="hidden";
    document.getElementById("others").style.visibility="visible";
}
function manager() {
    document.getElementById("others").style.visibility="hidden";
    document.getElementById("manager").style.visibility="visible";

}