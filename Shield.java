public class Shield extends Item{
    String name;
    int protectionTurns;
    String info;
    
    public Shield(String name, int protectionTurns, String info){
        super(name);
        this.protectionTurns = protectionTurns;
        this.info = info;
    }

    @Override
    public void information(){
        System.out.println(this.info);
    }
}
