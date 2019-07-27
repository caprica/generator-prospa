# generator-prospa [![NPM version][npm-image]][npm-url] [![Dependency Status][daviddm-image]][daviddm-url]
> Single Page Application creator.

## What is it?

Generate fully working Single Page Application projects using various combinations of front-end and middle-tier
technologies, using various JVM languages.

Supported languages:

 * Java
 * Kotlin
 * Scala
 * Groovy

Supported front-ends:

 * ReactJS
 * AngularJS
 * EmberJS
 * Vue.js

Supported middle-tier:

 * Javalin
 * Spring Boot
 * Spring MVC
 * Vert.x

Any combinations of these are possible.

## Features

 * Generated projects are fully ready to build and execute;
 * Fully working client-side routing;
 * Fully working server-side routing, deep-linking works, no ugly hash-routing;
 * Example JSON web-service API;
 * Existing toolchains just work for the various front-ends, including proxying of web-service API.

## Installation

First, install [Yeoman](http://yeoman.io) and generator-prospa using [npm](https://www.npmjs.com/) (we assume you have pre-installed [node.js](https://nodejs.org/)).

```bash
npm install -g yo
npm install -g generator-prospa
```

Then generate your new project:

```bash
yo prospa
```

## Project Status

This project is currently in BETA.

Things mostly work but there may be some rough edges.

Some constructs may not be 100% idiomatic for the various different JVM languages, feedback is welcome.

## License

GPL-3.0 © [Caprica Software Limited](http://capricasoftware.co.uk)

[npm-image]: https://badge.fury.io/js/generator-prospa.svg
[npm-url]: https://npmjs.org/package/generator-prospa
[travis-image]: https://travis-ci.org/caprica/generator-prospa.svg?branch=master
[travis-url]: https://travis-ci.org/caprica/generator-prospa
[daviddm-image]: https://david-dm.org/caprica/generator-prospa.svg?theme=shields.io
[daviddm-url]: https://david-dm.org/caprica/generator-prospa
