//finish living room
//do the upstairs

public class Game {
    
    public static void main(String[] args) {
        Player p = new Player();
        System.out.println(p.getResetColor());
        start(p);
    }

    
    public static void start(Player p){
        System.out.println("You wake up in the middle of an unknown house you don't know how you got there, but you know you need to escape. In front of you there is a door out of the house, a kitchen to your right and a livingroom to your right. What do you do?");
        while (true) { 
            System.out.println(p.nav("door") + "\t\thead to door");
            System.out.println(p.nav("kitchen") + "\thead to kitchen ");
            System.out.println(p.nav("livingroom") + "\thead to livingroom ");
            if(p.getMirror()){
                System.out.println(p.nav("upstairs") + "\thead upstairs");
            }
            
            System.out.println(p.getPlayerColor());
            String word = p.input();
            System.out.print(p.getResetColor());

            switch (word) {
                case "door" -> door(p);
                case "kitchen" -> Kitchen.run(p);
                case "livingroom" -> LivingRoom.run(p);
                default -> {
                    if (word.equals("upstairs") && !!p.getDrunk()){
                        upstairs(p);
                    } else {
                        System.out.println("Try again");
                    }
                    
                }
            }
        }
    }

    public static void door(Player p) {
        System.out.println("u at da door");
        if(p.getKey()){
            System.out.println("you have unlocked the door, you may now exit the house");
            System.out.println( p.nav("exit")+ "\twould you like to exit? ");
            System.out.println(p.nav("back") + "\texplore the house more");
        } else {
            System.out.println("Hey king, door locked");
        }
    }

    public static void upstairs(Player p){
        System.out.println("you go upstairs its much cleaner than downstairs.");
        System.out.println("there are 3 rooms up here.");

        //the usual stuff
        while (true) {
            System.out.println(p.nav("bedroom") + " \ta couples room");
            System.out.println(p.nav("boysroom") + "\ta young boys room");
            System.out.println(p.nav("girlsroom") + " \tand a... another room, we dont need to go in there.");
            System.out.println(p.nav("back") + "\tgo downstairs");

            System.out.println(p.getPlayerColor());
            String word = p.input();
            System.out.print(p.getResetColor());

            switch (word) {
                case "bedroom" -> BedRoom.run(p); //DO THIS
                case "boysroom" -> BoysRoom.run(p); //DO THIS
                case "girlsroom" -> GirlsRoom.run(p); //DO THIS
                case "back" -> {return;}
                default -> System.out.println("Try again"); 
            }
        }
        

    }
}

