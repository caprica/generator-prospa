'use strict';

const versions = {

    languages: {
        kotlin    : '1.3.41',
        scala     : '2.13.0'
    },

    dependencies: {
        findbugs  : '3.0.2',
        jackson   : '2.9.9',
        javalin   : '3.1.0',
        slf4j     : '1.7.26',
        servletApi: '3.0.1',
        springBoot: '2.1.6.RELEASE',
        spring    : '5.1.8.RELEASE',
        vertx     : '3.7.1'
    },

    mavenPlugins: {
        compiler  : '3.8.0',
        exec      : '1.6.0',
        frontend  : '1.7.6',
        jetty     : '9.4.19.v20190610',
        kotlin    : '1.3.41',
        resources : '3.1.0',
        scala     : '4.1.1',
        war       : '3.2.3'
    },

    frontEnd: {
        node      : 'v10.15.0',
        yarn      : 'v1.13.0'
    }

};

module.exports = versions;
