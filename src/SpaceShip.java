/**
 *  Created by Patrick Aung on 8/25/18
 */

public interface SpaceShip {

    boolean launch();
    boolean land();
    boolean canCarry(Item item);
    void carry(Item item);

}