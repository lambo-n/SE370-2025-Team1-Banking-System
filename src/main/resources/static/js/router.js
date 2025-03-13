// Simple router for handling page navigation
class Router {
    constructor(rootElement) {
        this.rootElement = rootElement;
        this.routes = {};
        this.currentPage = null;
        
        // Handle navigation
        window.addEventListener('hashchange', () => this.handleRouteChange());
        
        // Link click handler
        document.addEventListener('click', (e) => {
            if (e.target.tagName === 'A' && e.target.dataset.page) {
                e.preventDefault();
                this.navigateTo(e.target.dataset.page);
            }
        });
    }
    
    // Add a route
    addRoute(name, renderFunction) {
        this.routes[name] = renderFunction;
        return this;
    }
    
    // Navigate to a specific page
    navigateTo(page) {
        window.location.hash = page;
    }
    
    // Handle route changes
    handleRouteChange() {
        // Get the page from the hash (remove the #)
        const page = window.location.hash.slice(1) || 'frontpage';
        
        if (this.routes[page]) {
            // Clear current content
            this.rootElement.innerHTML = '';
            
            // Render the new page
            this.routes[page]();
            this.currentPage = page;
            
            // Update active nav link
            this.updateNavigation();
        }
    }
    
    // Update the navigation to highlight the current page
    updateNavigation() {
        // Remove active class from all links
        document.querySelectorAll('nav a').forEach(link => {
            link.classList.remove('active');
        });
        
        // Add active class to current page link
        const currentLink = document.querySelector(`nav a[data-page="${this.currentPage}"]`);
        if (currentLink) {
            currentLink.classList.add('active');
        }
    }
    
    // Initialize the router
    init() {
        this.handleRouteChange();
    }
}