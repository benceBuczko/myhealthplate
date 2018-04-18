$(document).ready(function () {
    var loginWarning = $("#loginWarning");
    register();
    if(loginWarning.text() !== ""){
        $('.dropdown-toggle').dropdown("toggle");
    }
    //login();
});

function register(){
    $('#registerButton').on('click', function (event) {
        var warning = $("#registerWarning");
        warning.text("");
        $("#registerForm").find($("input")).each(function () {
            $(this).css("background-color", "white");
            if ($(this).val() === "") {
                warning.text("Fill out all the fields please!");
                $(this).css("background-color", "red");
                $("#registerModal").scrollTop(0);
            }
        });
        if(warning.text() !== ""){
            return;
        }
        if($("#inputPassword1").val() !== $("#inputPassword2").val()){
            warning.text("Passwords do not match!");
            $("#inputPassword1").css("background-color", "red");
            $("#inputPassword2").css("background-color", "red");
            $("#registerModal").scrollTop(0);
            return;
        }
        if(warning.text() !== ""){
            return;
        }
        var userEmail = $("#inputEmail").val();
        var json = {"userEmail": userEmail};
        $.ajax({
            method: 'POST',
            url: '/registercheck',
            data: JSON.stringify(json),
            contentType: 'application/json;charset=UTF-8',
            success: function (result) {
                console.log('ajax post successful');
                if (result === "false"){
                    warning.text("This email address is already registered!");
                    $("#registerModal").scrollTop(0);
                }
                else {
                    $("#registerForm").submit();
                }
            },
            error: function () {
                console.log('ajax post failed');
            }

        });
    })
}

function login(){
    $('#signInButton').on('click', function (event) {
        var form = $("#loginForm");
        var json = {"email": form.find($("input[type=email]")).val(),"password": form.find($("input[type=password]")).val()};
        var warning = $("#loginWarning");
        warning.text("");
        $.ajax({
            method: 'POST',
            url: '/login',
            data: JSON.stringify(json),
            contentType: 'application/json;charset=UTF-8',
            success: function (result) {
                console.log('ajax post successful');
                if (result === "false"){
                    warning.text("Email address or password not correct!");
                }
                else {
                    form.submit();
                }
            },
            error: function () {
                console.log('ajax post failed');
            }
        });
    });

}