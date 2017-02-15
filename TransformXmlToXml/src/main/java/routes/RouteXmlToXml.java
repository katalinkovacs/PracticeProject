package routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import javax.xml.bind.JAXBContext;


public class RouteXmlToXml extends RouteBuilder  {


    ProcessorXmltoXml processor1 = new ProcessorXmltoXml();

    public void configure() throws Exception {

        JaxbDataFormat jaxbDataFormat = new JaxbDataFormat("personinfo1");


            //from("file:XmlProcessing/src/main/resources/data/inbox?noop=true")
            from("file:TrnsformXmlToXml/src/main/resources/data/inbox?noop=true")
                    //from xml input sets the in msg body to Employee obj
                    .unmarshal(jaxbDataFormat)
                    //this is to invoke processAddress method on AddressProcessor object
                    .bean(processor1, "myProcessor")
                    .to("file:XmlProcessing/src/main/resources/data/outbox");




        }

    }




