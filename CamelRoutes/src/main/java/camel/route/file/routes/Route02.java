package camel.route.file.routes;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Katika on 13/02/2017.
 */
public class Route02 extends RouteBuilder{

        public void configure() throws Exception {

            from("file:CamelRoutes/src/main/resources/data/inbox02?noop=true")
                    .to("file:CamelRoutes/src/main/resources/data/outbox02");
        }
    }


