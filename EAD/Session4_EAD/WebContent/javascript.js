var index;
var charge, currencyType, USD_RATE = 71,
    YEN_RATE = 0.65;
var price = [
    [5, 100, 500],
    [10, 200, 1000],
    [20, 500, 3500]
];
var vehicleString = ['Bicycle', 'Motorcycle', 'Fourwheelers'];

function changeCurrency(vehicleType) {

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

function getPass() {
    if (document.getElementById("daily").checked) {
        var payableAmount = price[index][0] * selectedTypeRate;
        var plan="daily";
    } else if (document.getElementById("monthly").checked) {
        var payableAmount = price[index][1] / selectedTypeRate;
        var plan="monthly";
    } else if (document.getElementById("yearly").checked) {
        var payableAmount = price[index][2] / selectedTypeRate;
        var plan="yearly";
    }
    alert(payableAmount.toFixed(2));
    document.getElementById("price").value = payableAmount.toFixed(2);

}

function openCity(evt, cityName) {
	  var i, tabcontent, tablinks;
	  tabcontent = document.getElementsByClassName("tabcontent");
	  for (i = 0; i < tabcontent.length; i++) {
	    tabcontent[i].style.display = "none";
	  }
	  tablinks = document.getElementsByClassName("tablinks");
	  for (i = 0; i < tablinks.length; i++) {
	    tablinks[i].className = tablinks[i].className.replace(" active", "");
	  }
	  document.getElementById(cityName).style.display = "block";
	  evt.currentTarget.className += " active";
	}

	// Get the element with id="defaultOpen" and click on it
	document.getElementById("defaultOpen").click();
	