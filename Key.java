public class Key extends Item{
    String name;
    String info;
    
    public Key(String name, String info){
        super(name);
        this.info = info;
    }

    @Override
    public void information(){
        System.out.println(this.info);
        System.out.println("Opens the door locked with ID : " + super.name);
    }
}