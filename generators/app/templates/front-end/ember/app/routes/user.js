import Route from '@ember/routing/route'

// If the API server is not available, we are not getting a rejected promise, is this because we're doing it via proxy?

export default Route.extend({

    model(params) {
        return fetch(`/api/users/${params.user_id}`).then(function(response) {
            if (response.ok) {
                return response.json()
            } else {
                throw Error(response.statusText)
            }
        })        
    }

})
