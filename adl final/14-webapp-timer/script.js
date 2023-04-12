var startTime;

function showHelloPage() {
	var name = document.getElementById("name").value;
	if (name === "") {
		alert("Please enter your name.");
	} else {
		startTime = new Date();
		document.body.innerHTML = "<h1>Hello, " + name + "!</h1><input type='button' value='Logout' onclick='showLogoutPage()'>";
		document.body.style.backgroundColor = "#e6e6e6";
	}
}

function showLogoutPage() {
	var duration = Math.round((new Date() - startTime) / 1000); // in seconds
	document.body.innerHTML = "<h1>Thank you for using our service, " + name + "!</h1><p>You have used our service for " + duration + " seconds.</p>";
	document.body.style.backgroundColor = "white";
}

function startTime() {
	var today = new Date();
	var hours = today.getHours();
	var minutes = today.getMinutes();
	var seconds = today.getSeconds();
	hours = checkTime(hours);
	minutes = checkTime(minutes);
	seconds = checkTime(seconds);
	document.getElementById('start-time').innerHTML = "Start Time: " + hours + ":" + minutes + ":" + seconds;
	setTimeout(startTime, 1000);
}

function checkTime(i) {
	if (i < 10) {
		i = "0" + i;
	}
	return i;
}
