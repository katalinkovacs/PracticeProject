package camel.route.jms.routes;
import org.apache.camel.builder.RouteBuilder;


public class AmqRoute01 extends RouteBuilder{

        public void configure() throws Exception {

            from("amq:Route01.in")
                    .to("amq:Route01.out");
        }
    }



