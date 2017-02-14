package camel.route.jms.routes;

import org.apache.camel.builder.RouteBuilder;


public class SortingRoute03 extends RouteBuilder {

    public void configure() throws Exception {


        onException(Exception.class)
                .to("amq:bad.msg")
                .end();


        from("file:CamelRoutes/src/main/resources/data/xmlMessages?noop=true")
                .id("myfirstroute")
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

/*
        // test that our route is working
        from("amq:katiMsg.out").process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                System.out.println("katiMsg.out received msg: "+ exchange.getIn().getBody() + "---------------");
            }
        });

        from("amq:zoliMsg.out").process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                System.out.println("zoliMsg.out received msg: "+ exchange.getIn().getBody() + "---------------");
            }
        });

        from("amq:otherMsg.out").process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                System.out.println("otherMsg.out received msg: "+ exchange.getIn().getBody() + "---------------");
            }
        });
*/


    }

}
