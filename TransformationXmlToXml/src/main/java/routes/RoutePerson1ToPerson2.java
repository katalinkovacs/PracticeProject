package routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import processors.ProcessorPerson1ToPerson2;


public class RoutePerson1ToPerson2 extends RouteBuilder{


        ProcessorPerson1ToPerson2 processor = new ProcessorPerson1ToPerson2();

        public void configure() throws Exception {

            JaxbDataFormat jaxbDataFormatPerson1 = new JaxbDataFormat("personinfo1");


            JaxbDataFormat jaxbDataFormatPerson2 = new JaxbDataFormat("personinfo2");

            from("amq:data.in")
                    //unmarshalling is the process to read in xml and convert to java object using jaxb generated template
                    // classes
                    .unmarshal(jaxbDataFormatPerson1)
                    //this is to invoke processor to transform person1 to person2
                    .bean(processor, "myprocessor")
                    //marshalling is the process to convert java to xml -- the processor from previous step returns
                    // a person2 which will be used to create the output xml
                    .marshal(jaxbDataFormatPerson2)
                    .to("amq:data.out");

        }

    }

