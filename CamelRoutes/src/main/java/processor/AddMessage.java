package processor;

import org.apache.camel.Exchange;


// Add "Szevasz" to the message.

public class AddMessage {

    public void processMsg(Exchange ex){

        StringBuffer newMsg = new StringBuffer();
        newMsg.append("Szevasz  ");
        newMsg.append(ex.getIn().getBody().toString());
        ex.getIn().setBody(newMsg.toString());
    }


}
