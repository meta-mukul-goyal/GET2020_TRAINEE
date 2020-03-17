var vehicleType, index;
var charge, currencyType, USD_RATE = 71,
    YEN_RATE = 0.65;
var price = [
    [5, 100, 500],
    [10, 200, 1000],
    [20, 500, 3500]
];
var count = 0;
var globalFlag = 0;
var vehicleString = ['Bicycle', 'Motorcycle', 'Fourwheelers'];
// var userPassword;
var selectedTypeRate;
// validation for employee registration
function checkValidation(tagId) {
    var flag = 1;
    var number = "0123456789";
    var alphabet = "abcdefghijklmnopqrstuvwxyz";
    var alphabet1 = alphabet.toUpperCase();
    console.log(alphabet1);
    var name = document.getElementById('name').value;
    var userPassword;
    var email = document.getElementById("email").value;
    var contact = document.getElementById("contact").value;
    var password = document.getElementById("password").value;
    console.log(password);
    var rePassword = document.getElementById("confirmpassword").value;
    if (tagId == "name") {
        if (name.length < 2) {
            alert("Name length must greater than 2 ");
            return false;
        } else {
            for (var i = 0; i < name.length; i++) {
                var check = number.indexOf(name[i]);
                if (check >= 0) {
                    alert("Name doesn't contain numeric value");
                    return false;
                }
            }
        }
    } else if (tagId == "email") {
        if (email.length >= 0) {
            var at_the_rate = email.indexOf('@');
            var dot = email.indexOf('.com');
            if (at_the_rate < 0) {
                alert("email is not contain @");
                return false;
            }
            if (dot != email.length - 4) {
                alert("email is not contain .com");
                return false;
            }
        }
    } else if (tagId == "Contact") {
        if (contact.length <= 8 || contact.length > 10) {
            alert("contact is not valid");
            return false;
        } else {
            for (var i = 0; i < contact.length; i++) {
                var check = alphabet.indexOf(contact[i]);
                if (check >= 0) {
                    alert("Name doesn't contain alphabet");
                    return false;
                }
            }
        }
    } else if (tagId == "password") {
        userPassword = document.getElementById("password").value;
        if (userPassword.length < 8) {
            document.getElementById("password").style.border = "2px solid red";
            return false;
        } else {
            var upperCheck = -1,
                lowerCheck = -1,
                numberCheck = -1;
            for (var i = 0; i < password.length; i++) {
                if (upperCheck < 0)
                    upperCheck = alphabet1.indexOf(password[i]);
                if (lowerCheck < 0)
                    lowerCheck = alphabet.indexOf(password[i]);
                if (numberCheck < 0)
                    numberCheck = number.indexOf(password[i]);
            }
            if (upperCheck < 0 || lowerCheck < 0 || numberCheck < 0) {
                document.getElementById("password").style.border = "2px solid red";
                return false;
            } else if (userPassword.length > 8 && userPassword.length < 11) {
                document.getElementById("password").style.border = "2px solid orange";
                return false;
            } else if (userPassword.length > 10) {
                document.getElementById("password").style.border = "2px solid green";
                return true;
            }
        }
    } else if (tagId == "confirmpassword") {
        if (rePassword != userPassword) {
            flag = 0;
            alert("your confirm password doesn't match with password");
            return false;
        } else if (flag = 1) {
            alert("Your ID is registered");
        }
    }
    return true;
}
//Plan selection form
function getPass() {
    document.getElementsByTagName("div")[0].style.display = "none";
    if (document.getElementById("daily").checked) {
        var payableAmount = price[index][0] * selectedTypeRate;
    } else if (document.getElementById("monthly").checked) {
        var payableAmount = price[index][1] / selectedTypeRate;
    } else if (document.getElementById("yearly").checked) {
        var payableAmount = price[index][2] / selectedTypeRate;
    }
    document.getElementById("planid").innerHTML = "<h1>You Have To Pay: " + payableAmount.toFixed(2) + " " + currencyType + "</h1>";
}
//Handles currency for plan
function changeCurrency() {
    if (vehicleType == "Bicycle")
        index = 0;
    else if (vehicleType == "Motorcycle")
        index = 1;
    else if (vehicleType == "Fourwheelers")
        index = 2;
    currencyType = document.getElementById("selectcurrency").value;
    if (currencyType == "INR") {
        document.getElementById("dailyPriceRate").innerHTML = price[index][0] + " INR";
        document.getElementById("monthlyPriceRate").innerHTML = price[index][1] + " INR";
        document.getElementById("yearlyPriceRate").innerHTML = price[index][2] + " INR";
        selectedTypeRate = 1;
    } else if (currencyType == "USD") {
        document.getElementById("dailyPriceRate").innerHTML = (price[index][0] / USD_RATE).toFixed(2) + " USD";
        document.getElementById("monthlyPriceRate").innerHTML = (price[index][1] / USD_RATE).toFixed(2) + " USD";
        document.getElementById("yearlyPriceRate").innerHTML = (price[index][2] / USD_RATE).toFixed(2) + " USD";
        selectedTypeRate = USD_RATE;
    } else if (currencyType == "YEN") {
        document.getElementById("dailyPriceRate").innerHTML = (price[index][0] / YEN_RATE).toFixed(2) + " YEN";
        document.getElementById("monthlyPriceRate").innerHTML = (price[index][1] / YEN_RATE).toFixed(2) + " YEN";
        document.getElementById("yearlyPriceRate").innerHTML = (price[index][2] / YEN_RATE).toFixed(2) + " YEN";
        selectedTypeRate = YEN_RATE;
    }
}
// js_enter_trigger_handler at input fields
function enterTrigger(val, event) {
    if (event.key === 'Enter') {
        console.log(val.value + " it worked! " + event.target.id);
        if (checkValidation(event.target.id) != true) {
            count--;
        }
        showInputFields();
    }
}
// To display employee registration form
function showregisterform() {
    document.getElementById("onclickregisterform").style.display = "none";
    document.getElementById("registerformid").style.display = "block";
    showInputFields();
}
// To display vehicle registration form
function showvehicleform() {
    document.getElementById("registerformid").style.display = "none";
    document.getElementById("vehicleformid").style.display = "block";
    showInputFields();
}
// To display plan selection form
function planform() {
    document.getElementById("vehicleformid").style.display = "none";
    document.getElementById("planid").style.display = "block";
    vehicleType = document.getElementById("selectVehicleType").value;
    changeCurrency();
}
// Function to display input fields
function showInputFields() {
    var empName = document.getElementById("name").value;
    console.log(innerHtmlVar);
    if (count != 0) {
        var innerHtmlVar = document.getElementsByTagName("label")[count].childNodes;
        console.log(innerHtmlVar);
        var x = innerHtmlVar[1].attributes[1].value;
        document.getElementsByTagName("label")[count - 1].style.display = "none";
        document.getElementsByTagName("div")[0].innerHTML = "<h2>Hi " + empName + " ! Can I know your " + x + "</h2>";
    }
    document.getElementsByTagName("label")[count++].style.display = "block";
}