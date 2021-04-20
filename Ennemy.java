import java.util.Vector;

public class Ennemy{
    String name;
    int HP, power;
    Vector<Item> loot;
    String presentation;

    public Ennemy(String name){
        this.name = name;
    }

    public Ennemy(String name,int HP, int power, Vector<Item> loot, String presentation){
        this.name = name;
        this.HP = HP;
        this.power = power;
        this.loot = loot;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void presentation(){
        System.out.println(this.presentation);
    }
}
