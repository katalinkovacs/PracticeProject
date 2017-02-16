package startapps;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import routes.RoutePerson1ToPerson2;

public class StartApp {


        public static void main(String ... args) throws Exception{

            //CREATE CAMELCONTEXT
            CamelContext context = new DefaultCamelContext();

            //ADD ROUTES TO CONTEXT
            context.addRoutes(new RoutePerson1ToPerson2());

            context.start();
            Thread.sleep(10000);
            context.stop();
        }
    }

