public class Food extends Item{
    String name;
    int regen;
    String info;

    public Food(String name, int regen, String info){
        super(name);
        this.regen = regen;
        this.info = info;
    }

    @Override
    public void information(){
        System.out.println(this.info);
        System.out.println("HP regeneration : " + Integer.toString(this.regen));
    }

    @Override
    public int getFoodValue(){
        return this.regen;
    }
}
