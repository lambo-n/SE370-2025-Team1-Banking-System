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
    // Show loading state
    const accountStack = document.getElementById('connected-account-stack');
    accountStack.innerHTML = '<div class="loading-state"><p>Loading your accounts...</p></div>';
    
    const targetConnectedUserID = "cUtest1"; // Set the targetConnectedUserID dynamically if needed
    
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
      
      

      bankAccounts.forEach(bankAccount => {4
        console.log("Bank Account:", bankAccount.bankAccountName)

        const li = document.createElement('li');
        li.className = 'account-item';
        
        // Format the account details with square card layout
        li.innerHTML = `
          <div class="account-details">
            <div class="bank-account-name">Bank Account: ${bankAccount.bankAccountName}</div>
            <div class="bank-account-connected-user">User: ${bankAccount.connectedUserID}</div>
          </div>
          <div class="account-balance-container">
            <div class="account-balance">$${bankAccount.balance.toFixed(2)}</div>
          </div>
        `;
        
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
    getAllConnectedBankAccountsEndpoint();
  });



