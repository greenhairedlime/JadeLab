package Behaviours;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
Inner class OfferRequestsServer.
This is the behaviour used by Book-seller agents to serve incoming requests
for offer from buyer agents.
If the requested book is in the local catalogue the seller agent replies
with a PROPOSE message specifying the price. Otherwise a REFUSE message is
sent back.
*/
class OfferRequestsServer extends CyclicBehaviour {
	public void action() {
		 ACLMessage msg = myAgent.receive();
		 if (msg != null) {
			// Message received. Process it
			 String title = msg.getContent();
			 ACLMessage reply = msg.createReply();
//			 Integer price = (Integer) catalogue.get(title);
			 if (price != null) {
			 // The requested book is available for sale. Reply with the price
			 reply.setPerformative(ACLMessage.PROPOSE);
			 reply.setContent(String.valueOf(price.intValue()));
			 }
		 }
		 else {
			// The requested book is NOT available for sale.
			 reply.setPerformative(ACLMessage.REFUSE);
			 reply.setContent("not-available");
			 }
			 myAgent.send(reply);
		 } 
} // End of inner class OfferRequestsServer
