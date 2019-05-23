function myFunction() {

    var toppings = [
        ["1", "1396/12/3", "شکایت", "مشاهده"]
        , ["2", "1397/10/3", "انتقاد", "مشاهده"]
        , ["3", "1397/12/25", "درخواست" ,"مشاهده"]
    ];

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
                    tableItem.onclick=f1
                }
                rowItem.appendChild(tableItem);
            }

            table.appendChild(rowItem);
        }
    }
    var arr2=[];
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
                    tableItem.onclick=f2
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
    location.replace()
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