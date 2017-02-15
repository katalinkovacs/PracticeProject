import personinfo1.Person1;
import personinfo1.Person1;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class StartApp {



    public static void main(String ... args){
        try {

            //Create a file object - pointer to the file/ path to it
            File inputXml = new File("TransformXmlToXml/" + "src/main/resources/data/inbox/personinfo1.xml");


            //generic steps
            JAXBContext jaxbContext = JAXBContext.newInstance(Person1.class);

            //Unmarshall-validate     Document --> Object     if we want to read from the file
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            //reading from file --> create employee1 object!!!!!!!!!   --> readi in input file create employee object
            Person1 person1 = (Person1) jaxbUnmarshaller.unmarshal(inputXml);


            //transformation
            //We create a empty new object
            Person2 person2 = new Person2();

            //set value from employee1
            person2.setFirstName(person1.getFirstname());
            person2.setLastName(person1.getLastname());
            person2.setDOB(person1.getDateofbirth());

            File fileOut = new File("XmlProcessing/src/main/resources/data/EmployeeInfo_out_new.xml");
            JAXBContext jaxbContextOut = JAXBContext.newInstance(Person2.class);
            Marshaller jaxbMarshaller = jaxbContextOut.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(person2, fileOut);



        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }




}
