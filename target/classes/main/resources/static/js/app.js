// Initialize the application
document.addEventListener('DOMContentLoaded', () => {
    //templates
    const templates = {
        frontpage: document.getElementById('frontpage-template').innerHTML,
        login: document.getElementById('login-template').innerHTML,
        signup: document.getElementById('signup-template').innerHTML,
        dashboard: document.getElementById('dashboard-template').innerHTML,
        accounts: document.getElementById('accounts-template').innerHTML,
        transactions: document.getElementById('transactions-template').innerHTML,
        profile: document.getElementById('profile-template').innerHTML
    };
    
    //create router instance
    const appElement = document.getElementById('app');
    const router = new Router(appElement);
    
    //define routes
    router.addRoute('frontpage', () => {
        appElement.innerHTML = templates.frontpage;
    });

    router.addRoute('login', () => {
        appElement.innerHTML = templates.login;
    });

    router.addRoute('signup', () => {
        appElement.innerHTML = templates.signup;
    });

    router.addRoute('dashboard', () => {
        appElement.innerHTML = templates.dashboard;
    });
    
    router.addRoute('accounts', () => {
        appElement.innerHTML = templates.accounts;
    });
    
    router.addRoute('transactions', () => {
        appElement.innerHTML = templates.transactions;
    });
    
    router.addRoute('profile', () => {
        appElement.innerHTML = templates.profile;
    });
    
    //initialize the router
    router.init();

    

});

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

function callCreateNewUserEndpoint() {
    fetch('/api/user/createNewUser'), {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }
    }
}

function callLogInUserEndpoint(button) {
    console.log("login endpoint called")
    const link = button.nextElementSibling;
    link.href = `#${link.dataset.page}`;
    console.log(link.href);
}