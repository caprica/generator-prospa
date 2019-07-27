module.exports = {
  devServer: {
    proxy: 'http://localhost:<%= serverPort %>'
  }
}