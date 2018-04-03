package Agents;

import jade.core.Agent;
import jade.core.behaviours.*;

public class MyAgent extends Agent {
    protected void setup() {
        System.out.println("Adding waker behaviour");
        addBehaviour(new WakerBehaviour(this, 10000) {
            protected void handleElapsedTimeout() {}
        });

        addBehaviour(new TickerBehaviour(this, 10000) {
            @Override
            protected void onTick() {
            }
        });
    }
}
