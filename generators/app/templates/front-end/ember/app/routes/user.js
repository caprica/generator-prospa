import Route from '@ember/routing/route'

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
