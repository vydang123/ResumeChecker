// nav menu style
var nav = $("#navbarSupportedContent");
var btn = $(".custom_menu-btn");
btn.click
btn.click(function (e) {

    e.preventDefault();
    nav.toggleClass("lg_nav-toggle");
    document.querySelector(".custom_menu-btn").classList.toggle("menu_btn-style")
});


function getCurrentYear() {
    var d = new Date();
    var currentYear = d.getFullYear()

    $("#displayDate").html(currentYear);
}

getCurrentYear();

// Password Validation
$(document).ready(function () {
    $("#password").on("input", function () {
        var password = $(this).val();
        $("#length span").html(password.length >= 8 ? "✔" : "X").css("color", password.length >= 8 ? "green" : "red");
        $("#uppercase span").html(/[A-Z]/.test(password) ? "✔" : "X").css("color", /[A-Z]/.test(password) ? "green" : "red");
        $("#lowercase span").html(/[a-z]/.test(password) ? "✔" : "X").css("color", /[a-z]/.test(password) ? "green" : "red");
        $("#number span").html(/[0-9]/.test(password) ? "✔" : "X").css("color", /[0-9]/.test(password) ? "green" : "red");
        $("#special span").html(/[!@#$%^&*(),.?\":{}|<>]/.test(password) ? "✔" : "X").css("color", /[!@#$%^&*(),.?\":{}|<>]/.test(password) ? "green" : "red");
    });

    // Form Validation
    $("form").on("submit", function (e) {
        var firstname = $("#firstname").val().trim();
        var lastname = $("#lastname").val().trim();
        var username = $("#username").val().trim();
        var password = $("#password").val().trim();
        var dob = $("#dob").val().trim();

        if (!firstname || !lastname || !username || !password || !dob) {
            e.preventDefault();
            if (!$("#error-message").length) {
                $("form").prepend('<div id="error-message" style="color: red; margin-bottom: 10px;">You have to fill all the required fields.</div>');
            }
        } else {
            $("#error-message").remove(); // Remove error if form is correctly filled
        }
    });
	

	
});



