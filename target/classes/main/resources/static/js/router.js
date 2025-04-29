//load a template dynamically
function loadTemplate(templateName) {
    const app = document.getElementById('app');
    fetch(`/templates/${templateName}.html`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`Failed to load template: ${templateName}`);
            }
            return response.text();
        })
        .then(html => {
            app.innerHTML = html;

            //call preloadUserData() when the dashboard template is loaded
            if (templateName === 'accounts') {
                getAllConnectedBankAccountsEndpoint();
            }
        })
        .catch(error => {
            console.error(error);
            app.innerHTML = `<p>Error loading page: ${templateName}</p>`;
        });
}

//handles navigation and update the URL hash
document.addEventListener('click', (event) => {
    const target = event.target;
    if (target.tagName === 'A' && target.dataset.page) {
        event.preventDefault();
        const page = target.dataset.page;

        // Update the URL hash
        window.location.hash = page;
    }
});

//handles hash changes to load the correct template
window.addEventListener('hashchange', () => {
    const page = window.location.hash.slice(1) || 'frontpage'; // Default to 'frontpage'
    loadTemplate(page);
});

//load the default page based on the current hash
const initialPage = window.location.hash.slice(1) || 'frontpage';
loadTemplate(initialPage);