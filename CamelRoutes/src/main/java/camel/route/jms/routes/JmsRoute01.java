package camel.route.jms.routes;
import org.apache.camel.builder.RouteBuilder;

public class JmsRoute01 extends RouteBuilder{

        public void configure() throws Exception {

            from("jms:Route01.in")
                    .to("jms:Route01.out");
        }
    }



