package org.gestion.av.metier;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.springframework.transaction.annotation.Transactional;

import tools.PSR;

@Transactional
public class AjoutConCliMetier {
	PSR r=new PSR();
	public  String ajouterConCli(String id1, String id2) {
		String a = null;
		 try {
	            // Create SOAP Connection
	            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
	            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

	            // Send SOAP Message to SOAP Server
	            String url = "http://localhost:8082/Agence_virtuelle_ws/services/AjouterConCliWS";
	            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest( id1, id2), url);

	            // Process the SOAP Response
	           a= r.printSOAPResponseString(soapResponse);

	            soapConnection.close();
	        } catch (Exception e) {
	            System.err.println("Error occurred while sending SOAP Request to Server");
	            e.printStackTrace();
	        }
		return a;
	}
	private  SOAPMessage createSOAPRequest(String id1, String id2) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://projectWS.projectWS";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("example", serverURI);

       
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("addContratClient", "example");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("id1", "example");
        soapBodyElem1.addTextNode(id1);
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("id2", "example");
        soapBodyElem2.addTextNode(id2);
        

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  + "addContratClient");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }
	
}
