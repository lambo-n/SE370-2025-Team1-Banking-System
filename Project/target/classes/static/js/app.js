function checkSessionStatus() {
    fetch('/api/user/sessionStatus', {
        method: 'GET',
        credentials: 'include' // Include cookies in the request
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Session validation failed');
        }
        return response.json();
    })
    .then(data => {
        if (data.isLoggedIn) {
            alert('User is logged in as: ' + data.username);
        } else {
            console.log('User is not logged in');
            window.location.hash = 'login'; // Redirect to login page
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

function callLogInUserEndpoint(button) {
    console.log("login endpoint called");
    const username = document.getElementById('login-username').value;
    const password = document.getElementById('login-password').value;

    // Validate inputs
    if (!username || !password) {
        alert("Please enter both username and password");
        return;
    }

    // Include username and password in the query string
    fetch(`/api/user/logInUser?username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to log in');
        }
        return response.json();
    })
    .then(isLoggedIn => {
        if (isLoggedIn) {
            console.log("Login successful, navigating to dashboard...");
            window.location.hash = 'dashboard';
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

function callLogOutUserEndpoint() {
    console.log("Logout endpoint called");

    fetch('/api/user/logOutUser', {
        method: 'GET',
        credentials: 'include' // Include cookies in the request
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to log out');
        }
        console.log("Logout successful, redirecting to login page...");
        window.location.hash = 'login'; // Redirect to the login page
    })
    .catch(error => {
        console.error('Error:', error);
        alert("An error occurred while trying to log out. Please try again later.");
    });
}

function callCreateNewUserEndpoint() {
    // Get all form values
    const username = document.getElementById('signup-username').value;
    const password = document.getElementById('signup-password').value;
    const firstName = document.getElementById('signup-firstname').value;
    const lastName = document.getElementById('signup-lastname').value;
    const email = document.getElementById('signup-email').value;
    const phoneNum = document.getElementById('signup-phone-number').value;
    const socialSecurityNum = document.getElementById('signup-ssn').value;
    const street = document.getElementById('signup-street').value;
    const city = document.getElementById('signup-city').value;
    const state = document.getElementById('signup-state').value;
    const zip = document.getElementById('signup-zip').value;

    // Create query string with all parameters
    const params = new URLSearchParams({
        username,
        password,
        firstName,
        lastName,
        email,
        phoneNum: parseInt(phoneNum.replace(/\D/g, '')), // Remove non-digits and parse as integer
        socialSecurityNum: parseInt(socialSecurityNum.replace(/\D/g, '')), // Remove non-digits and parse as integer
        street,
        city,
        state,
        zip
    });

    fetch(`/api/user/createNewUser?${params.toString()}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to create user');
        }
        console.log('User created successfully');
        window.location.hash = 'login'; // Redirect to login page
    })
    .catch(error => {
        console.error('Error:', error);
        alert('An error occurred while creating the user. Please try again.');
    });
}

function getAllConnectedBankAccountsEndpoint() {
    // Show loading state
    const accountStack = document.getElementById('connected-account-stack');
    accountStack.innerHTML = '<div class="loading-state"><p>Loading your accounts...</p></div>';
    
    // First fetch: Get user session data
    fetch('/api/user/sessionStatus', {
        method: 'GET',
        credentials: 'include'
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to get session status');
        }
        return response.json();
    })
    .then(sessionData => {
        if (!sessionData.isLoggedIn) {
            throw new Error('User not logged in');
        }
        
        // Second fetch: Get connected bank accounts using the username
        return fetch(`/api/bankAccount/getConnectedBankAccounts?targetConnectedUserID=cU${sessionData.username}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to fetch connected bank accounts');
        }
        return response.json();
    })
    .then(bankAccounts => {
        // Clear the loading state
        accountStack.innerHTML = '';
        
        if (bankAccounts.length === 0) {
            accountStack.innerHTML = `
                <div class="empty-state">
                    <p>No connected bank accounts found.</p>
                    <button class="btn" onclick="getAllConnectedBankAccountsEndpoint()">Try Again</button>
                </div>
            `;
            return;
        }
        
        // Create a new list with enhanced styling
        const ul = document.createElement('ul');
        ul.className = 'account-list';
        
        bankAccounts.forEach(bankAccount => {
            const li = document.createElement('li');
            li.className = 'account-content';
            li.innerHTML = generateBankAccountHTML(bankAccount);
            ul.appendChild(li);
        });
        
        accountStack.appendChild(ul);
    })
    .catch(error => {
        console.error('Error:', error);
        accountStack.innerHTML = `
            <div class="empty-state">
                <p>An error occurred while fetching your accounts.</p>
                <button class="btn" onclick="getAllConnectedBankAccountsEndpoint()">Try Again</button>
            </div>
        `;
    });
}
  
// Initialize when the page loads
document.addEventListener('DOMContentLoaded', function() {

});

function generateBankAccountHTML(bankAccount) {
    return `
        <div class="account-content">
            <div class="account-details">
                <div class="bank-account-name">Bank Account: ${bankAccount.bankAccountName}</div>
                <div class="bank-account-balance">Current Balance: $${bankAccount.balance.toFixed(2)}</div>
            </div>
            <div class="bank-account-actions">
                <button class="action-btn" onclick="redirectTransactionForm('${bankAccount.bankAccountID}')">Make a Transaction</button>
                <button class="action-btn" onclick="redirectWithdrawForm('${bankAccount.bankAccountID}')">Withdraw</button>
            </div>
        </div>
    `;
}

function redirectTransactionForm(bankAccountID) {
    // Redirect to the transaction form page with the bank account ID as a query parameter
    window.location.hash = `transactionForm.html?bankAccountID=${encodeURIComponent(bankAccountID)}`;
}

function redirectWithdrawForm(bankAccountID) {
    // Redirect to the withdraw form page with the bank account ID as a query parameter
    window.location.hash = `withdrawForm.html?bankAccountID=${encodeURIComponent(bankAccountID)}`;
}
