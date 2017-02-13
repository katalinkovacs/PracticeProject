package camel.route.jms.routes;

import org.apache.camel.builder.RouteBuilder;
import processor.AddMessage;


public class JmsRoute02 extends RouteBuilder {

    private final AddMessage addMessage = new AddMessage();

    public void configure() throws Exception {

        from("amq:AddMsg.in")
                .convertBodyTo(String.class)
                .bean(addMessage, "processMsg")
                .to("amq:AddMsg.out");
    }

}
