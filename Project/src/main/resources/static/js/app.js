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
    fetch('/api/user/createNewUser'), {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }
    }
}

function getAllConnectedBankAccountsEndpoint() {
    // Show loading state
    const accountStack = document.getElementById('connected-account-stack');
    accountStack.innerHTML = '<div class="loading-state"><p>Loading your accounts...</p></div>';
    
    const targetConnectedUserID = "cUtest1"; // Set the targetConnectedUserID dynamically if needed
    
    //calls the function in BankAccountController using the /api/bankAccount/getConnectedBankAccounts mapped endpoint
    //?targetConnectedUserID passes the hard coded userID into the bank account controller function
    fetch(`/api/bankAccount/getConnectedBankAccounts?targetConnectedUserID=${encodeURIComponent(targetConnectedUserID)}`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
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
        // Display empty state if no accounts
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
        
        // Format the account details with square card layout
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
