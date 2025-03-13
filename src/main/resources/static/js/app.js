// Initialize the application
document.addEventListener('DOMContentLoaded', () => {
    // Get templates
    const templates = {
        frontpage: document.getElementById('frontpage-template').innerHTML,
        dashboard: document.getElementById('dashboard-template').innerHTML,
        accounts: document.getElementById('accounts-template').innerHTML,
        transactions: document.getElementById('transactions-template').innerHTML,
        profile: document.getElementById('profile-template').innerHTML
    };
    
    // Create router instance
    const appElement = document.getElementById('app');
    const router = new Router(appElement);
    
    // Define routes
    router.addRoute('frontpage', () => {
        appElement.innerHTML = templates.frontpage;
        // Additional logic for frontpage
    });

    router.addRoute('dashboard', () => {
        appElement.innerHTML = templates.dashboard;
        // Additional logic for dashboard
    });
    
    router.addRoute('accounts', () => {
        appElement.innerHTML = templates.accounts;
        // Fetch accounts from API
        fetchAccounts();
    });
    
    router.addRoute('transactions', () => {
        appElement.innerHTML = templates.transactions;
        // Fetch transactions from API
        fetchTransactions();
    });
    
    router.addRoute('profile', () => {
        appElement.innerHTML = templates.profile;
        // Load profile data
        loadProfileData();
    });
    
    // Initialize the router
    router.init();
    
    // API functions
    function fetchAccounts() {
        fetch('/api/accounts')
            .then(response => response.json())
            .then(accounts => {
                const accountsList = document.getElementById('accounts-list');
                accountsList.innerHTML = '';
                
                accounts.forEach(account => {
                    const accountElement = document.createElement('div');
                    accountElement.className = 'account-item';
                    accountElement.innerHTML = `
                        <h3>${account.name}</h3>
                        <p>Balance: $${account.balance.toFixed(2)}</p>
                        <button data-account-id="${account.id}" class="view-details-btn">View Details</button>
                    `;
                    accountsList.appendChild(accountElement);
                });
                
                // Add event listeners for account details
                document.querySelectorAll('.view-details-btn').forEach(btn => {
                    btn.addEventListener('click', (e) => {
                        const accountId = e.target.dataset.accountId;
                        showAccountDetails(accountId);
                    });
                });
            })
            .catch(error => console.error('Error fetching accounts:', error));
    }
    
    // More functions for other API calls
    function fetchTransactions() {
        // Similar to fetchAccounts
    }
    
    function loadProfileData() {
        // Fetch and display profile data
    }
    
    function showAccountDetails(accountId) {
        // Show details for a specific account
    }
});