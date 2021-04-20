import java.util.Vector;

public class Room{
    int i,j;
    int[] neighborsDoors; // in order north, east, south, west / 0 = wall , 1 = door, 2 = locked door;
    Door[] doors; //  in order north, east, south, west , null if no door
    Vector<Item> items = new Vector<Item>();
    Ennemy ennemy;

    public Room(int i, int j, int[] neighborsDoors, Vector<Item> items){
        this.i = i;
        this.j = j;
        this.neighborsDoors = neighborsDoors;
        this.items = items;
        this.ennemy = new Ennemy("not");
        this.doors = new Door[4];
    }

    public void printRoom(){
        System.out.println("\n----------------------------------------------------------\n");
        if(this.ennemy.getName().equals("not"))
            System.out.println("There is "+ ConsoleColors.GREEN+"no ennemy "+ ConsoleColors.RESET+"in the room");
        else{
            System.out.println("You encounter an ennemy named " + ConsoleColors.RED + this.ennemy.getName() + ConsoleColors.RESET);
            this.ennemy.presentation();
            System.out.println("\nTo start fight use command Fight <name>");
        }

        System.out.println("\nThere are doors to : ");
        if(this.neighborsDoors[0] == 1)
            System.out.println(" - North (opened)");
        else if(this.neighborsDoors[0] == 2)
            System.out.println(" - North (locked, Key : "+ this.doors[0].getKey()+")");
        if(this.neighborsDoors[1] == 1)
            System.out.println(" - East (opened)");
        else if(this.neighborsDoors[1] == 2)
            System.out.println(" - East (locked, Key : "+ this.doors[1].getKey()+")");
        if(this.neighborsDoors[2] == 1)
            System.out.println(" - South (opened)");
        else if(this.neighborsDoors[2] == 2)
            System.out.println(" - South (locked, Key : "+ this.doors[0].getKey()+")");
        if(this.neighborsDoors[3] == 1)
            System.out.println(" - West (opened)");
        else if(this.neighborsDoors[3] == 2)
            System.out.println(" - West (locked, Key : "+ this.doors[0].getKey()+")");
        
        if(this.items.size()==0)
            System.out.println("\nThere is nothing on the ground.");
        else{
            System.out.println("\nYou can find on the ground :");
            for (int i = 0 ; i<this.items.size();i++)
                System.out.println( "- " + this.items.get(i).getName());
        }

    }
    public void setEnemyRoom(Ennemy ennemy){
        this.ennemy = ennemy;
    }

    public Ennemy getEnnemyRoom(){
        return this.ennemy;
    }

    public int[] getNeighbors(){
        return this.neighborsDoors;
    }

    public int getI(){
        return this.i;
    }

    public int getJ(){
        return this.j;
    }

    public Item getRoomItems(String name){
        for(Item i : this.items){
            String itemID = i.getName();
            if(itemID.equals(name))
                return i;
        }
        return null;
    }

    public void pickupItem(Item itemToTake){
        this.items.remove(itemToTake);
    }

    public void addItem(Item toAdd){
        this.items.add(toAdd);
    }
    public Door getDoor(int neighbor){
        return this.doors[neighbor];
    }
    
    public void unlockDoor(int orientation){
        this.neighborsDoors[orientation]=1;
        this.doors[orientation].openDoor();

    }

    public void setLockedDoor(String key, String orientation){
        int intOrientation = -1;
        if (orientation.equals("North"))
            intOrientation = 0;
        else if (orientation.equals("East"))
            intOrientation = 1;
        else if (orientation.equals("South"))
            intOrientation = 2;
        else if (orientation.equals("West"))
            intOrientation = 3;
        this.doors[intOrientation] = new Door(true, key);
        this.neighborsDoors[intOrientation] = 2;
    }
    public int getDoorState(int orientation){
        return this.neighborsDoors[orientation];
    }
}
