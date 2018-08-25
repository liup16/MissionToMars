/**
 *  Created Patrick Aung on 8/25/18
 */

public class U1 extends Rocket {

    private final int ROCKET_WEIGHT = 10000;
    private final int MAX_WEIGHT = 18000;
    private final int ROCKET_COST = 100000000;

    public U1(){
        super.setRocketWeight(ROCKET_WEIGHT);
        super.setMaxWeight(MAX_WEIGHT);
        super.setCargoWeight(0);
        super.setTotalWeight(ROCKET_WEIGHT);
        super.setRocketCost(ROCKET_COST);
    }

    public boolean launch(){ return (5*(getTotalWeight()/getMaxWeight()) <= Math.random()*10); }
    public boolean land(){ return (1*(getTotalWeight()/getMaxWeight()) <= Math.random()*10); }

}