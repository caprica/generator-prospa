mvn jetty:run<% if (serverPort != 8080) { %> -Djetty.port=<%= serverPort %><% } %>
