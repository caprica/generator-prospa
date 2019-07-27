import EmberRouter from '@ember/routing/router'
import config from './config/environment'

const Router = EmberRouter.extend({
    location: config.locationType,
    rootURL: config.rootURL
})

Router.map(function() {
    this.route('home-redirect', { path: 'index.html'})  // Redirect "index.html" to home, this will also change the address bar to "/"
    this.route('home', { path: '/'})                    // Redirect the root route to home
    this.route('users')
    this.route('user',  { path: 'users/:user_id' })
    this.route('not-found', { path: '/*path' })         // Catch-all for not-found
})

export default Router
