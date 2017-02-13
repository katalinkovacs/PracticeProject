package camel.route.file;
import camel.route.file.routes.Route01;
import camel.route.file.routes.Route02;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;


public class StartApp {

    public static void main(String ... args) throws Exception{

        //CREATE CAMELCONTEXT
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new Route01());
        context.addRoutes(new Route02());

        context.start();
        Thread.sleep(1000000000);
        //context.stop();
    }

}
