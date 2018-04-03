package Agents;
import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.*;

public class BookBuyerAgent extends Agent {
	 // The title of the book to buy
	 private String targetBookTitle;
	 // The list of known seller agents
	 private AID[] sellerAgents = {new AID("seller1", AID.ISLOCALNAME),
	 new AID("seller2", AID.ISLOCALNAME)};

	    protected void setup() {
	    	// Printout a welcome message
	        System.out.println("Hello! Buyer-agent " + getAID().getName() + " is ready.");

	        // Get the title of the book to buy as a start-up argument
	        Object[] args = getArguments();
	        if (args != null && args.length > 0) {
	            targetBookTitle = (String) args[0];
	            System.out.println("Trying to buy " + targetBookTitle);

	            addBehaviour(new TickerBehaviour(this, 60000) {
	                protected void onTick() {
	                    myAgent.addBehaviour(new RequestPerformer());
	                }
	            });
	        } else {
	            // Make the agent terminate
	            System.out.println("No target book title specified");
	            doDelete();
	        }
	    }

	    // Put agent clean-up operations here
	    protected void takeDown() {
	        // Printout a dismissal message
	        System.out.println("Buyer-agent " + getAID().getName() + " terminating.");
	    }
}
