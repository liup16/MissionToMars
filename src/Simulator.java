/**
 *  Created Patrick Aung on 8/25/18
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulator{

    public ArrayList<Item> loadItems(File file){
        ArrayList<Item> items = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String[] itemString = scanner.nextLine().split("=");
                Item item = new Item(itemString[0],Integer.valueOf(itemString[1]));
                items.add(item);
            }
            return items;
        }
        catch (FileNotFoundException e) { System.out.println("File Not Found"); }
        return items;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> u1Items){
        ArrayList<Rocket> u1Fleet = new ArrayList<>();
        U1 u1Rocket = new U1();
        for (Item item: u1Items){
            if (u1Rocket.canCarry(item)){
                System.out.println(item.getName() + " : " + item.getWeight());
                u1Rocket.carry(item);
            } else {
              u1Fleet.add(u1Rocket);
              u1Rocket = new U1();
              u1Rocket.carry(item);
              System.out.println("- - - - - - - - - - - - - - - -\n" + item.getName() + " : " + item.getWeight());
            }
        }
        u1Fleet.add(u1Rocket);
        return u1Fleet;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> u2Items){
        ArrayList<Rocket> u2Fleet = new ArrayList<>();
        U1 u2Rocket = new U1();
        for (Item item: u2Items){
            if (u2Rocket.canCarry(item)){
                System.out.println(item.getName() + " : " + item.getWeight());
                u2Rocket.carry(item);
            } else {
                u2Fleet.add(u2Rocket);
                u2Rocket = new U1();
                u2Rocket.carry(item);
                System.out.println("- - - - - - - - - - - - - - - -\n" + item.getName() + " : " + item.getWeight());
            }
        }
        u2Fleet.add(u2Rocket);
        return u2Fleet;
    }

    public long runSimulation(ArrayList<Rocket> rocketFleet){
        System.out.println("\n----------------------------------------------\n" +
                "           Launch & Land Simulation\n----------------------------------------------");
        int launchCount = 0;
        long fleetCost = 0;
        for (Rocket rocket: rocketFleet){
            rocket.launch();
            rocket.land();
            System.out.print("Initial Launching...  ");
            while (!(rocket.launch() && rocket.land())){
                rocket.launch();
                rocket.land();
                System.out.println(" |    Outcome: Failed\n");
                fleetCost += rocket.getRocketCost();
                System.out.print("Relaunching...        ");
                launchCount ++;
            }
            System.out.println(" |    Outcome: Success\n");
            fleetCost += rocket.getRocketCost();
            launchCount ++;
        }
        System.out.println("----------------------------------------------\n           Total Rockets Used: " + launchCount);
        return fleetCost;
    }
}