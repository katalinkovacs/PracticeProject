package camel.route.jms;

import camel.route.jms.routes.JmsRoute01;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;


public class StartAppJms {

    public static void main(String ... args) throws Exception{


        //CREATE CAMELCONTEXT
        CamelContext context = new DefaultCamelContext();

        //ADD ROUTE TO CONTEXT
        context.addRoutes(new JmsRoute01());

        // connect to embedded ActiveMQ JMS broker
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");

        context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));




        context.start();
        Thread.sleep(1000000000);
        //context.stop();
    }

}
