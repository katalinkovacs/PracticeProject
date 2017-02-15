package processors;

import org.apache.camel.Exchange;
import personinfo1.Person1;

public class ProcessorXmlToXml  {


    public void myprocessor (Exchange ex) throws Exception {

        //change file name to have a different output file name
        ex.getIn().setHeader("CamelFileName", "PersonInfoOut.xml");
        //this is just for debugging
        System.out.print("got here");


        //gets the unmarshaled java object from message body
        Person1 p1 = (Person1) ex.getIn().getBody();
        System.out.print(p1.getFirstname());

        //manipulates the message body
        //emp1.setFirstname("Katica");

        //sets the manipulated object back to body
        ex.getIn().setBody(p1);

        System.out.print(p1.getFirstname());


    }

    }






