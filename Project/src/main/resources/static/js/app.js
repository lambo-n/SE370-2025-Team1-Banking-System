function callBackgroundColorChangeEndpoint() {
    fetch('/api/user/changeColor', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to fetch the random color');
        }
        return response.text(); // Parse the response as plain text (hex color)
    })
    .then(hexColor => {

        const color = `#${hexColor}`;
        
        //apply color to website background
        document.body.style.backgroundColor = color;
        console.log(`Background color changed to: ${color}`);
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

function callLogInUserEndpoint(button) {
    console.log("login endpoint called");
    const username = "test1";
    const password = "testpass1";

    // Include username and password in the query string
    fetch(`/api/user/logInUser?username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`, {
        method: 'GET', // Ensure the method matches your controller
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to log in');
        }
        return response.json(); // Parse the response as JSON
    })
    .then(isLoggedIn => {
        if (isLoggedIn) {
            console.log("Login successful, navigating to dashboard...");
            window.location.hash = 'dashboard'; // Change the hash to dashboard
        } else {
            console.log("Login failed, staying on the current page.");
            alert("Incorrect username or password. Please try again.");
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert("An error occurred while trying to log in. Please try again later.");
    });
}

function callCreateNewUserEndpoint() {
    fetch('/api/user/createNewUser'), {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }
    }
}

function getAllConnectedBankAccountsEndpoint() {
    fetch('/api/bankAccount/getConnectedBankAccounts'), {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }
    }
}

