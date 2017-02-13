package camel.route.jms;

import camel.route.jms.routes.JmsRoute01;
import camel.route.jms.routes.JmsRoute02;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;


public class StartAppJms {

    public static void main(String ... args) throws Exception{


        //CREATE CAMELCONTEXT
        CamelContext context = new DefaultCamelContext();

        // connect to embedded ActiveMQ JMS broker
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");

        context.addComponent("amq", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));


        //ADD ROUTE TO CONTEXT
        context.addRoutes(new JmsRoute01());
        context.addRoutes(new JmsRoute02());


        context.start();
        Thread.sleep(1000000000);
        //context.stop();
    }

}
