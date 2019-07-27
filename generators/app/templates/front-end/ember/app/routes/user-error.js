import Route from '@ember/routing/route'

import EmberObject from '@ember/object'

export default Route.extend({

    setupController(controller/*, model, transition*/) {
        var params = this.paramsFor('user')
        controller.set('model', EmberObject.create({
            username: params.user_id
        }))
    }

})
