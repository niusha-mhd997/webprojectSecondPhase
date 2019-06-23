/**
 * Created by win_8.1 on 5/21/2019.
 */
function Login() {

    localStorage.setItem("name", "0");
    localStorage.setItem("email", "0");
    localStorage.setItem("password", "0");
    localStorage.setItem("token", "0");
   // alert("clicked")

    var settings = {
        "async": true,
        "crossDomain": true,
        "url": "http://localhost:8080/contacts/rest/contact/login",
        "method": "POST",
        "headers": {
            "content-type": "application/x-www-form-urlencoded",
            "cache-control": "no-cache"
        },
        "data": {
            "email": document.getElementById("namex").value,
            "password": document.getElementById("pwd1x").value
        }
    };


    $.ajax(settings).done(function (response) {

       // alert(response.success + "  " + response.message);

        if(response.message === "کاربری با این مشخصات یافت نشد"){
            alert("کاربری با این مشخصات یافت نشد")
        }

        if(response.message === "رمز عبور اشتباه است"){
            alert("رمز عبور اشتباه است")
        }

        if(response.message === "کارمندی شما تایید نشده"){
            alert("متاسفانه هنوز کارمندی شما تایید نشده!")
        }

        if(response.message === "به عنوان دانشجو وارد شدید"){

            localStorage.setItem("token",response.data.token);
            localStorage.setItem("name",response.data.name);
            localStorage.setItem("email",response.data.email);
            localStorage.setItem("password",response.data.password);
            localStorage.setItem("role","student");
           // alert(response.data.token+ "  موفق");
            window.open("StudentPage.html","_parent");

           // alert("به عنوان دانشجو وارد شدید");

        }

        if(response.message === "به عنوان مدیر وارد شدید"){
             alert("به عنوان مدیر وارد شدید!");

            localStorage.setItem("name",response.data.name);
            localStorage.setItem("email",response.data.email);
            localStorage.setItem("password",response.data.password);
            localStorage.setItem("role","manager");

             window.open("ManagerPage.html","_parent");
        }

        if(response.message === "به عنوان کارمند وارد شدید"){
            alert( response.data.name +" به عنوان کارمند وارد شدید! " );

            localStorage.setItem("token",response.data.token);
            localStorage.setItem("name",response.data.name);
            localStorage.setItem("email",response.data.email);
            localStorage.setItem("password",response.data.password);
            localStorage.setItem("semat",response.data.semat);
            localStorage.setItem("role","employee");
            // alert(response.data.token+ "  موفق");
            window.open("EmployeePage.html","_parent");
        }

    });

    $.ajax(settings).fail(function (jqXHR, textStatus) {
        alert("error: " + jqXHR + "  " + textStatus);
    });



}
