var vehicleType, index;
var charge, currencyType, USD_RATE:number = 71,
    YEN_RATE:number = 0.65;
var price:number[][] = [
    [5, 100, 500],
    [10, 200, 1000],
    [20, 500, 3500]
];
var count:number = 0;
var globalFlag:number = 0;
var vehicleString:string[] = ['Bicycle', 'Motorcycle', 'Fourwheelers'];
// var userPassword;
var selectedTypeRate:number;

// validation for employee registration
function checkValidation(tagId:any):boolean{
    var flag:number = 1;
    var number:string = "0123456789";
    var alphabet:string = "abcdefghijklmnopqrstuvwxyz"
    var alphabet1:string = alphabet.toUpperCase();
    console.log(alphabet1);
    var name:string = (<HTMLInputElement>document.getElementById('name')).value;
    var userPassword:string;
    var email:string = (<HTMLInputElement>document.getElementById("email")).value;
    var contact:string = (<HTMLInputElement>document.getElementById("contact")).value;
    var password:string = (<HTMLInputElement>document.getElementById("password")).value;
    console.log(password);
    var rePassword:string = (<HTMLInputElement>document.getElementById("confirmpassword")).value;
    if (tagId == "name") {
        if (name.length < 2) {
            alert("Name length must greater than 2 ");
            return false;
        } else {
            for (var i:number = 0; i < name.length; i++) {
                var check:number = number.indexOf(name[i]);
                if (check >= 0) {
                    alert("Name doesn't contain numeric value");
                    return false;
                }
            }
        }
    } else if (tagId == "email") {
        if (email.length >= 0) {
            var at_the_rate:number = email.indexOf('@');
            var dot:number = email.indexOf('.com');
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
            for (var i:number = 0; i < contact.length; i++) {
                var check:number = alphabet.indexOf(contact[i]);
                if (check >= 0) {
                    alert("Name doesn't contain alphabet");
                    return false;
                }
            }
        }
    } else if (tagId == "password") {
        userPassword= (<HTMLInputElement>document.getElementById("password")).value;
        if (userPassword.length < 8) {
            document.getElementById("password").style.border = "2px solid red";
            return false;
        } else {
            var upperCheck:number = -1,
                lowerCheck:number = -1,
                numberCheck:number = -1;
            for (var i:number = 0; i < password.length; i++) {
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
function getPass() : void{
    document.getElementsByTagName("div")[0].style.display = "none";
    if ((<HTMLInputElement>document.getElementById("daily")).checked) {
        var payableAmount:number = price[index][0] * selectedTypeRate;
    } else if ((<HTMLInputElement>document.getElementById("monthly")).checked) {
        var payableAmount:number = price[index][1] / selectedTypeRate;
    } else if ((<HTMLInputElement>document.getElementById("yearly")).checked) {
        var payableAmount:number = price[index][2] / selectedTypeRate;
    }
    document.getElementById("planid").innerHTML = "<h1>You Have To Pay: " + payableAmount.toFixed(2) + " " + currencyType + "</h1>";
}

//Handles currency for plan
function changeCurrency(): void {

    if (vehicleType == "Bicycle")
        index = 0;
    else if (vehicleType == "Motorcycle")
        index = 1;
    else if (vehicleType == "Fourwheelers")
        index = 2;
    currencyType = (<HTMLSelectElement>document.getElementById("selectcurrency")).value;

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
function enterTrigger(val, event:any): void {
    if (event.key === 'Enter') {
        console.log(val.value + " it worked! " + event.target.id);
        if (checkValidation(event.target.id) != true) {
            count--;
        }
        showInputFields();
    }
}

// To display employee registration form
function showregisterform(): void {
    document.getElementById("onclickregisterform").style.display = "none";
    document.getElementById("registerformid").style.display = "block";
    showInputFields();
}

// To display vehicle registration form
function showvehicleform(): void {
    document.getElementById("registerformid").style.display = "none";
    document.getElementById("vehicleformid").style.display = "block";
    showInputFields();
}

// To display plan selection form
function planform(): void {
    document.getElementById("vehicleformid").style.display = "none";
    document.getElementById("planid").style.display = "block";
    vehicleType = (<HTMLSelectElement>document.getElementById("selectVehicleType")).value;
    changeCurrency();
}

// Function to display input fields
function showInputFields(): void {
    var empName:string = (<HTMLInputElement>document.getElementById("name")).value;
    console.log(innerHtmlVar);
    if (count != 0) {
        var innerHtmlVar = document.getElementsByTagName("label")[count].childNodes;
        console.log(innerHtmlVar);
        var x:string = (<HTMLInputElement>innerHtmlVar[1]).attributes[1].value;
        document.getElementsByTagName("label")[count - 1].style.display = "none";
        document.getElementsByTagName("div")[0].innerHTML = "<h2>Hi " + empName + " ! Can I know your " + x + "</h2>";
    }
    document.getElementsByTagName("label")[count++].style.display = "block";
}