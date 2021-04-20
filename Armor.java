public class Armor extends Item{
    String name;
    double protection;
    String info;

    public Armor(String name, double protection, String info){
        super(name);
        this.protection= protection;
        this.info = info;
    }

    @Override
    public void information(){
        System.out.println(this.info);
        int protect = (int)(100*this.protection);
        System.out.println("Protection percentage : " + Integer.toString(protect) + "%");
    }
}