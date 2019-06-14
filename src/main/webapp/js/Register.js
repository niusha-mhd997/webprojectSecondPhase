/**
 * Created by win_8.1 on 5/21/2019.
 */
function Register() {

    //  console.log("amad");

    if(document.getElementById("mySelect").value==="student"){

        if (document.getElementById("pwd1").value === document.getElementById("pwd2").value) {

            if (document.getElementById("pwd1").value.length >= 6) {

                localStorage.setItem("name", "0");
                localStorage.setItem("email", "0");
                localStorage.setItem("password", "0");
                localStorage.setItem("token", "0");


                var settings = {
                    "async": true,
                    "crossDomain": true,
                    "url": "rest/student/studentregister",
                    "method": "POST",
                    "headers": {
                        "content-type": "application/x-www-form-urlencoded",
                        "cache-control": "no-cache"
                    },
                    "data": {
                        "email": document.getElementById("email").value,
                        "name": document.getElementById("name").value,
                        "password": document.getElementById("pwd1").value
                    }
                };

                $.ajax(settings).done(function (response) {

                    if (response.success == true) {


                        localStorage.setItem("token", response.data.token);
                        localStorage.setItem("name", response.data.name);
                        localStorage.setItem("email", response.data.email);
                        localStorage.setItem("password", response.data.password);
                        localStorage.setItem("role", "student");
                        //alert(response.data.token+ "  موفق");
                        window.open("StudentPage.html", "_parent")

                    } else {
                        alert(response.message)
                    }
                });

            }
            else {
                alert("طول رمز عبور باید حداقل 6 باشد")
            }

        } else {
            alert("رمز عبور و تکرار با هم یکسان نیستند")
        }


    }

    else if(document.getElementById("mySelect").value==="employee") {

        //alert("کارمند");

        if (document.getElementById("pwd1").value === document.getElementById("pwd2").value) {

            if (document.getElementById("pwd1").value.length >= 6) {

                localStorage.setItem("name", "0");
                localStorage.setItem("email", "0");
                localStorage.setItem("password", "0");
                localStorage.setItem("token", "0");


                var settings = {
                    "async": true,
                    "crossDomain": true,
                    "url": "rest/employee/employeeregister",
                    "method": "POST",
                    "headers": {
                        "content-type": "application/x-www-form-urlencoded",
                        "cache-control": "no-cache"
                    },
                    "data": {
                        "email": document.getElementById("email").value,
                        "name": document.getElementById("name").value,
                        "semat": "مسوول",
                        "password": document.getElementById("pwd1").value
                    }
                };

                $.ajax(settings).done(function (response) {

                    if (response.success == true) {


                        localStorage.setItem("token", response.data.token);
                        localStorage.setItem("name", response.data.name);
                        localStorage.setItem("email", response.data.email);
                        localStorage.setItem("password", response.data.password);



                        localStorage.setItem("role", "employee");
                        window.open("EmployeePage.html", "_parent")


                    } else {
                        alert(response.message)
                    }
                });

            }
            else {
                alert("طول رمز عبور باید حداقل 6 باشد")
            }

        } else {
            alert("رمز عبور و تکرار با هم یکسان نیستند")
        }

    }



}
