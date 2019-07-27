For ReacJS, configure the proxy in the `package.json`:

```
{
  "name": "app",
  "version": "0.1.0",
  ... other properties snipped ...
  "proxy": "http://localhost:<%= serverPort %>"
}
```

The proxy configuration has already been applied for this project.
