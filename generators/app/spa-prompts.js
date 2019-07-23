'use strict';

// FIXME replace inline strings with const for things like language and framework values

const spaPrompts = function(appName) {
    return [
    {
        type: 'input',
        name: 'groupId',
        message: 'What is the project Maven groupId?',
        store: true,
        default: 'com.mycompany'
    },{
        type: 'input',
        name: 'name',
        message: 'What is the project name?',
        store: true,
        default: appName.replace(/\s/g, '-')
    },{
        type: 'input',
        name: 'projectVersion',
        message: 'What is the project version?',
        store: true,
        default: '1.0.0-SNAPSHOT'
    },{
        type: 'input',
        name: 'description',
        store: true,
        message: 'Describe the project:'
    },{
        type: 'list',
        name: 'language',
        message: 'What is the programming language for the project?',
        store: true,
        choices: [{
            name: 'Java', value: 'java'
        },{
            name: 'Kotlin', value: 'kotlin'
        },{
            name: 'Scala', value: 'scala'
        },{
            name: 'Groovy', value: 'groovy'
        }],
        default: 'java'
    },{
        type: 'list',
        name: 'javaVersion',
        message: 'Which Java version to use?',
        store: true,
        choices: [{
            name: '7', value: '7',
        },{
            name: '8', value: '8',
        },{
            name: '9', value: '9',
        },{
            name: '10', value: '10',
        },{
            name: '11', value: '11',
        },{
            name: '12', value: '12',
        },{
            name: '13', value: '13'
        }],
        default: '11'
    },{
        type: 'list',
        name: 'framework',
        message: 'What is the middle-tier framework for the project?',
        store: true,
        choices: [{
            name: 'Javalin', value: 'javalin'
        },{
            name: 'Spring-Boot', value: 'spring-boot'
        },{
            name: 'Spring-MVC', value: 'spring-mvc'
        },{
            name: 'Vert.x', value: 'vertx'
        }],
        default: 'spring-boot'
    },{
        type: 'list',
        name: 'frontEnd',
        message: 'What is the front-end (user-interface) framework for the project?',
        store: true,
        choices: [{
            name: 'ReactJS', value: 'react'
        },{
            name: 'AngularJS', value: 'angular'
        },{
            name: 'Vue.js', value: 'vue'
        }],
        default: 'react'
    },{
        type: 'input',
        name: 'packageName',
        message: 'What is the top-level package name for your project?',
        store: true,
        default: function(answers) {
            return answers.groupId + '.' + answers.name.replace(/\-/g, '');
        }
    },{
        type: 'input',
        name: 'mainClassName',
        message: 'What is the name for the main class?',
        when: function(answers) {
            return answers.framework === 'javalin' || answers.framework === 'spring-boot' || answers.framework === 'vertx';
        },
        store: true,
        default: function(answers) {
            switch (answers.framework) {
                case 'javalin':
                    return 'Application'
                case 'spring-boot':
                    return 'Application'
                case 'vertx':
                    return 'MainVerticle';
                default:
                    throw new Error(`Unexpected answer: ${answers.framework}`);
            }
        }
    },{
        type: 'input',
        name: 'serverPort',
        message: 'What is the server port number?',
        store: true,
        default: 8080
    }];
}

module.exports = spaPrompts;
