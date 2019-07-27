For AngularJS, create a `proxy.conf.json` in the same directory as the `package.json` file:

```
{
  "/api": {
    "target": "http://localhost:<%= serverPort %>",
    "secure": false
  }
}
```

The proxy configuration has already been applied for this project.
