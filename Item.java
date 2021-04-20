public abstract class Item{
    String name;

    public Item(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void information(){
        return;
    }

    public int getFoodValue(){
        return 0;
    }
}
