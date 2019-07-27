For Vue.js, create a `vue.config.js` in the same directory as the `package.json` file:

```
module.exports = {
  devServer: {
    proxy: 'http://localhost:8080'
  }
}
```

The proxy configuration has already been applied for this project.
