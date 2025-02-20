public class Kitchen {

    public static void run(Player p) {
        while(true){
            System.out.println("What up you in da chicken");
            System.out.println("Around you there is a fridge, a bathroom, and a table");
            System.out.println(p.nav("fridge") + "\tGo to fride ");
            System.out.println(p.nav("table") + "\t\tGo to table ");
            System.out.println(p.nav("bathroom") + "\tGo to bathroom ");
            System.out.println(p.nav("back") + "\t\tLeave the room ");
            //extra nonsense for color
            System.out.println(p.getPlayerColor());
            String word = p.input();
            System.out.print(p.getResetColor());   
            
            switch (word) {
                case "fridge" -> fridge(p);
                case "table" -> table(p);
                case "bathroom" -> Bathroom.run(p);
                case "back" -> {return;}
                default -> System.out.println("Try again");
            }
            
        }

    }

    public static void fridge(Player p){
        System.out.println("you open the fridge. inside of it is moldy sandwiches, spoiling milk with a missing persons");
        System.out.println("on it, the face was blacked out but you know it was a girl, maybe 5 or 6. you dont know why but you're");
        System.out.println("disheartened and enraged.\n" + p.nav("back")); 
        
        p.delayInput();
    }

    public static void table(Player p){
        System.out.println("you look at the table, there are pictures of a family scattered on it.");
        System.out.println("all of the photos have the face of a women cut out of it. there is a large diamond with a " + p.getCode(3) + " in the center");
        System.out.println("carved into the table. you back away without taking any photos. whats next? " + p.getNavColor() +"[back]" + p.getResetColor());
        
        p.delayInput();
    }
    
}

class Bathroom{

    public static void run(Player p){
        while (true){
            System.out.println("you enter the bathroom. it is a mess.");
            System.out.println("trash is scattered on the floor, blood and vomit line the bottom of the tub. ");
            System.out.println(p.nav("back") + "\tGo back to the kitchen" );
            System.out.println(p.nav("cabinet") + "\tlook in the medicine cabinet");
            System.out.println(p.nav("mirror") + "\tlook in the mirror ");
        
            System.out.println(p.getPlayerColor());
            String word = p.input();
            System.out.print(p.getResetColor());   
        
            switch (word) {
                case "back" -> {return;}
                case "cabinet" -> cabinet(p);
                case "mirror" -> mirror(p);
                default -> System.out.println("Try again");
            }
        }
    }
    public static void cabinet(Player p){
        System.out.println("you open the cabinet etched on the side pannel is a spade with the number " + p.getCode(1) + " in it");
        System.out.println(p.nav("back") + "\t\tleave"); 
        System.out.println(p.nav("mirror") + "\tlooking the mirror");
        while (true) {
            switch (p.input()) {
                case "back" -> {return;}
                case "mirror" -> mirror(p);
                
            }
        }
    }
    
    public static void mirror(Player p){
        if(p.getMirror()){
            System.out.println("the mirror is broken, you can no longer look at yourself,.\n " + p.nav("back"));
        } else {
            System.out.println("you see yourself in the mirror. you see what you've become. youre digusted by your dirty clothes and wish to change them.");
            if(p.getDrunk()){
                System.out.println("you look back at yourself and punch the mirror, shattering it. your bedroom is upstairs");
                p.setMirror(true);
                p.setDrunk(false);
            }
            System.out.println(p.nav("back"));
        }
        
        p.delayInput();
    }
}