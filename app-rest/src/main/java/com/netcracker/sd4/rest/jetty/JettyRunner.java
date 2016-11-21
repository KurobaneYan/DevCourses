package com.netcracker.sd4.rest.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JettyRunner {
    private static final int PORT = 8000;

    private static final Logger LOGGER = LoggerFactory.getLogger(JettyRunner.class);

    public static void main(String[] args) throws Exception {
        new JettyRunner().startJetty(PORT);
    }

    private void startJetty(int port) throws Exception {
        LOGGER.info("Starting server at port {}", port);
        Server server = new Server(port);
        WebAppContext webApp = new WebAppContext();
        webApp.setContextPath("/");
        webApp.setWar("C:\\IdeaProjects\\DevCourses\\app-rest\\target\\app-rest.war");
        server.setHandler(webApp);
        server.start();
        LOGGER.info("Server started at port {}", port);
        server.join();
    }
}
