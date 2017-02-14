package camel.route.jms.routes;

import org.apache.camel.builder.RouteBuilder;


public class AmqSortingRoute04 extends RouteBuilder{


    public void configure() throws Exception {


            onException(Exception.class)
                    .to("amq:badMsg")
                    .end();

            from("amq:msg.in")
                    .id("firstRoute")
                    .to("amq:msgToSort");

            // content-based router
            from("amq:msgToSort")
                    .id("mysortingroute")
                    .choice()
                    .when().xpath("//recipient = 'Kati'")
                    .to("amq:katiMsg.out")
                    .when().xpath("//recipient = 'Zoli'")
                    .to("amq:zoliMsg.out")
                    .otherwise()
                    .to("amq:otherMsg.out");


        }

}
