package camel.route.file.routes;

import org.apache.camel.builder.RouteBuilder;


public class Route01 extends RouteBuilder {

    public void configure() throws Exception {

        from("file:CamelRoutes/src/main/resources/data/inbox01?noop=true")
                .to("file:CamelRoutes/src/main/resources/data/outbox01");
    }
}

