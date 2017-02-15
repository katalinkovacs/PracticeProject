package startingapp;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import routes.MyRoute;

/**
 * Created by Zoli on 15/02/2017.
 */
public class StartApp {


    public static void main(String ... args) throws Exception{


        //CREATE CAMELCONTEXT
        CamelContext context = new DefaultCamelContext();




        //ADD ROUTES TO CONTEXT
        context.addRoutes(new MyRoute());



        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}
