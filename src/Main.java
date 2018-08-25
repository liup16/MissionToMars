/**
 *  Created Patrick Aung on 8/25/18
 */

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        File phase1 = new File("phase-1.txt");
        File phase2 = new File("phase-2.txt");

        if (phase1.exists() && phase2.exists()) {
            ArrayList<Item> cargoItems;
            ArrayList<Rocket> rocketFleet;
            long u1FleetCost = 0;
            long u2FleetCost = 0;
            System.out.println("\n\n--------------------------------\n    " +
                    "Phase 1: U1 Fleet Cargo\n--------------------------------");
            cargoItems = simulator.loadItems(phase1);
            rocketFleet = simulator.loadU1(cargoItems);
            u1FleetCost += simulator.runSimulation(rocketFleet);

            System.out.println("\n\n--------------------------------\n    " +
                    "Phase 2: U1 Fleet Cargo\n--------------------------------");
            cargoItems = simulator.loadItems(phase2);
            rocketFleet = simulator.loadU1(cargoItems);
            u1FleetCost += simulator.runSimulation(rocketFleet);

            System.out.println("\n\n--------------------------------\n    " +
                    "Phase 1: U2 Fleet Cargo\n--------------------------------");
            cargoItems = simulator.loadItems(phase1);
            rocketFleet = simulator.loadU2(cargoItems);
            u2FleetCost += simulator.runSimulation(rocketFleet);

            System.out.println("\n\n--------------------------------\n    " +
                    "Phase 2: U2 Fleet Cargo\n--------------------------------");
            cargoItems = simulator.loadItems(phase2);
            rocketFleet = simulator.loadU2(cargoItems);
            u2FleetCost += simulator.runSimulation(rocketFleet);

            System.out.println("\n\nU1 Fleet Cost: $" + u1FleetCost + "\nU2 Fleet Cost: $" + u2FleetCost);
            System.out.print("Cheaper Fleet: ");
            if (u1FleetCost > u2FleetCost) { System.out.println("U2 Rocket Fleet\n\n"); }
            else if (u1FleetCost < u2FleetCost) { System.out.println("U1 Rocket Fleet\n\n"); }
            else { System.out.println("U1 and U2 fleets have same cost\n\n"); }
        } else { System.out.println("\nFileNotFoundException: check phase-1.txt and phase-2.txt filepath in Main.java."); }
    }
}