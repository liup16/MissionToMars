/**
 *  Author: Patrick Aung
 *  Date: 8/25/18
 */

public class Item {

    private String name;
    private int weight;

    public Item(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName(){ return this.name; }
    public int getWeight(){ return this.weight; }

}