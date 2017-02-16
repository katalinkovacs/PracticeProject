package processor;

import org.apache.camel.Exchange;
import personinfo1.Person1;
import personinfo2.Person2;

public class ProcessorPerson1toPerson2 {


    public void myprocessor (Exchange ex) throws Exception {

        //change file name to have a different output file name
        ex.getIn().setHeader("CamelFileName", "PersonInfo2Out.xml");



        //gets the unmarshaled java object from message body
        // this is standard camel how to get the body
        Person1 p1 = (Person1) ex.getIn().getBody();

        //get date from p1 object
        String firstName = p1.getFirstname();
        String lastName = p1.getLastname();
        String dob = p1.getDateofbirth();


        //Create a new empty Person2 object
        Person2 p2 = new Person2();

        // add the retrieved data from p1 to p2
        p2.setFirstName(firstName);
        p2.setLastName(lastName);
        p2.setDOB(dob);

        // set the body with new p2 object
        ex.getIn().setBody(p2);


    }

    }






