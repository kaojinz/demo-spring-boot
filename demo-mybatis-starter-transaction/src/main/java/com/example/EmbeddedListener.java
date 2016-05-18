package com.example;

import org.apache.catalina.startup.Tomcat;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmbeddedListener implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {

    final Logger logger = LogManager.getLogger(getClass());

    @Override
    public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
        int port = event.getEmbeddedServletContainer().getPort();
        logger.info("http://localhost:" + port);

        Tomcat tomcat = ((TomcatEmbeddedServletContainer) ((EmbeddedServletContainerInitializedEvent) event).getSource()).getTomcat();
    }
}
