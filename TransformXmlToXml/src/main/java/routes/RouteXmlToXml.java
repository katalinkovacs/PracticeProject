package routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import processors.ProcessorXmlToXml;


public class RouteXmlToXml extends RouteBuilder  {


    ProcessorXmlToXml processor1 = new ProcessorXmlToXml();

    public void configure() throws Exception {

        JaxbDataFormat jaxbDataFormat = new JaxbDataFormat("personinfo1");


            from("file:TransformXmlToXml/src/main/resources/data/inbox?noop=true")
                    //from xml input sets the in msg body to Employee obj
                    .unmarshal(jaxbDataFormat)
                    //this is to invoke processAddress method on AddressProcessor object
                    .bean(processor1, "myprocessor")
                    .to("file:XmlProcessing/src/main/resources/data/outbox");




        }

    }



