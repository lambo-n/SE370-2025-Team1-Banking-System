// Simple router for handling page navigation
class Router {
    constructor(rootElement) {
        this.rootElement = rootElement;
        this.routes = {};
        this.currentPage = null;
        
        //handle navigation
        window.addEventListener('hashchange', () => this.handleRouteChange());
        
        //link click handler
        document.addEventListener('click', (e) => {
            if (e.target.tagName === 'A' && e.target.dataset.page) {
                e.preventDefault();
                this.navigateTo(e.target.dataset.page);
            }
        });
    }
    
    //add a route
    addRoute(name, renderFunction) {
        this.routes[name] = renderFunction;
        return this;
    }
    
    //navigate to specific page
    navigateTo(page) {
        window.location.hash = page;
    }
    
    //handles route changes
    handleRouteChange() {
        //get the page from the hash
        const page = window.location.hash.slice(1) || 'frontpage';
        
        if (this.routes[page]) {
            //clear current content
            this.rootElement.innerHTML = '';
            
            //render the new page
            this.routes[page]();
            this.currentPage = page;
            
            this.updateNavigation();
        }
    }
    
    //update the navigation to highlight current page
    updateNavigation() {
        document.querySelectorAll('nav a').forEach(link => {
            link.classList.remove('active');
        });
        
        const currentLink = document.querySelector(`nav a[data-page="${this.currentPage}"]`);
        if (currentLink) {
            currentLink.classList.add('active');
        }
    }
    
    //initialize the router
    init() {
        this.handleRouteChange();
    }
}