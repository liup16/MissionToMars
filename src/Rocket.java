/**
 *  Created Patrick Aung on 8/25/18
 */

public class Rocket implements SpaceShip {

    private int rocketWeight;
    private int cargoWeight;
    private double totalWeight = this.rocketWeight + this. cargoWeight;
    private int maxWeight;
    private int rocketCost;

    public int getCargoWeight(){ return this.cargoWeight; }
    public double getTotalWeight() { return this.totalWeight; }
    public int getMaxWeight() { return this. maxWeight; }
    public int getRocketCost(){ return this.rocketCost; }

    public void setRocketWeight(int rocketWeight){ this.rocketWeight = rocketWeight; }
    public void setCargoWeight(int cargoWeight){ this.cargoWeight = cargoWeight; }
    public void setTotalWeight(int totalWeight){ this.totalWeight = totalWeight; }
    public void setMaxWeight(int maxWeight){ this.maxWeight = maxWeight; }
    public void setRocketCost(int rocketCost){ this.rocketCost = rocketCost; }

    public boolean launch(){ return true; }
    public boolean land(){
        return true;
    }
    public boolean canCarry(Item item){ return (this.totalWeight + item.getWeight() <= this.maxWeight); }
    public void carry(Item item){ this.totalWeight += item.getWeight(); }

}