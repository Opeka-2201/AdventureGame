public class Weapon extends Item{
    String name;
    int damage;
    String info;
    
    public Weapon(String name,int damage,String info){
        super(name);
        this.damage = damage;
        this.info = info;
    }

    @Override
    public void information(){
        System.out.println(this.info);
    }
}
