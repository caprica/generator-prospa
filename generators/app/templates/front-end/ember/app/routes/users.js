import Route from '@ember/routing/route'

export default Route.extend({

    model() {
        return fetch('/api/users').then(function(response) {
            if (response.ok) {
                return response.json()
            } else {
                throw Error(response.statusText)
            }
        })        
    }

})
