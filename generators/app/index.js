'use strict';

// FIXME currently i allow to specify main class name, but i don't rename the storage file for it

const Generator  = require('yeoman-generator');
const chalk      = require('chalk');
const yosay      = require('yosay');
const mkdirp     = require('mkdirp');
const glob       = require('glob');

const spaPrompts = require('./spa-prompts');
const versions   = require('./versions');

const GENERATOR_NAME = "spa-rktacular";
const GENERATOR_URL = "https://github.com/caprica/spa-rktacular";

const FRONT_END_BUILD_DIR = {
    "react"  : "/build",
    "angular": "/dist",
    "vue"    : "/dist"
};

const FRONT_END_RESOURCE_DIR = {
    "react"  : "/app",
    "angular": "",
    "vue"    : "/app"
};

const ext = {
    "java"  : "java",
    "kotlin": "kt",
    "scala" : "scala",
    "groovy": "groovy"
}

function getMainArtifactSource(framework, language) {
    if (framework == 'javalin' || framework == 'spring-boot') {
        return `Application.${ext[language]}`;
    } else if (framework == 'vertx') {
        return `MainVerticle.${ext[language]}`;
    } else {
        return null;
    }
}

function getMainArtifactDest(name, language) {
    return `${name}.${ext[language]}`;
}

module.exports = class extends Generator {

    prompting() {

        this.log(
            yosay(`Welcome to the super-excellent ${chalk.red('generator-spa')} generator!`)
        );

        return this.prompt(spaPrompts(this.appname)).then(props => {
            this.props = props;
        });
    }

    prepare() {
        this.model = {
            description        : this.props.description,
            frontEnd           : this.props.frontEnd,
            frontEndBuildDir   : FRONT_END_BUILD_DIR[this.props.frontEnd],
            frontEndResourceDir: FRONT_END_RESOURCE_DIR[this.props.frontEnd],
            frontEndPackageTool: 'yarn',
            generatorName      : GENERATOR_NAME,
            generatorUrl       : GENERATOR_URL,
            groupId            : this.props.groupId,
            javaVersion        : this.props.javaVersion,
            language           : this.props.language,
            framework          : this.props.framework,
            mainClassName      : this.props.mainClassName,
            name               : this.props.name,
            packageName        : this.props.packageName,
            projectVersion     : this.props.projectVersion,
            serverPort         : this.props.serverPort,
            versions           : versions,
            year               : new Date().getFullYear()
        };
    }

    generateProject() {
        this.fs.copy(this.templatePath('.gitignore'), this.destinationPath('.gitignore'));

        this.fs.copyTpl(
            this.templatePath(`project/readme/README.md`),
            this.destinationPath('README.md'),
            this.model);

        this.fs.copyTpl(
            this.templatePath(`project/maven/pom.xml`),
            this.destinationPath('pom.xml'),
            this.model);
    }

    generateMiddleTier() {
        const mainSourcePath   = `src/main/${this.props.language}`;
        const mainResourcePath = `src/main/resources`;
        const testSourcePath   = `src/test/${this.props.language}`;
        const testResourcePath = `src/test/resources`;

        mkdirp.sync(this.destinationPath(mainSourcePath));
        mkdirp.sync(this.destinationPath(mainResourcePath));
        mkdirp.sync(this.destinationPath(testSourcePath));
        mkdirp.sync(this.destinationPath(testResourcePath));

        this.fs.copy(this.templatePath('.gitkeep'), this.destinationPath(`${testSourcePath}/.gitkeep`  ));
        this.fs.copy(this.templatePath('.gitkeep'), this.destinationPath(`${testResourcePath}/.gitkeep`));

        if (this.props.framework === 'spring-mvc') {
            const webappPath = `src/main/webapp`;
            mkdirp.sync(this.destinationPath(`${webappPath}/WEB-INF`));
            this.fs.copy(this.templatePath('.gitkeep'), this.destinationPath(`${webappPath}/WEB-INF/.gitkeep`));
        }

        const packagePath = this.props.packageName.replace(/\./g, '/');

        this.fs.copyTpl(
            glob.sync(this.templatePath(`middle-tier/src/main/${this.props.language}/${this.props.framework}/**/!(Application.*|MainVerticle.*)`), { dot: true }),
            this.destinationPath(`${mainSourcePath}/${packagePath}`),
            this.model);

        const mainArtifactSource = getMainArtifactSource(this.props.framework, this.props.language);
        if (mainArtifactSource) {
            const mainArtifactDest = getMainArtifactDest(this.props.mainClassName, this.props.language);
            this.fs.copyTpl(
                this.templatePath(`middle-tier/src/main/${this.props.language}/${this.props.framework}/${mainArtifactSource}`),
                this.destinationPath(`${mainSourcePath}/${packagePath}/${mainArtifactDest}`),
                this.model);
        }

        if (this.props.framework === 'spring-boot') {
            this.fs.copy(glob.sync(this.templatePath(`middle-tier/src/resources/${this.props.framework}/**/*`), { dot: true }), this.destinationPath(`${mainResourcePath}`));
        } else {
            this.fs.copy(this.templatePath('.gitkeep'), this.destinationPath(`${mainResourcePath}/.gitkeep`));
        }
    }

    generateFrontEnd() {
        const appSourcePath = 'src/main/app';

        this.fs.copyTpl(
            glob.sync(this.templatePath(`front-end/${this.props.frontEnd}/**/*`), { dot: true }),
            this.destinationPath(`${appSourcePath}`),
            this.model);
    }

    install() {
    }

};
