public class LivingRoom {
    public static void run(Player p){
        while(true){
            System.out.println("You enter the living room. ");
            System.out.println(p.nav("coffeetable") + "\ttheres a few items on the coffee table ");
            System.out.println(p.nav("portrait") + "\tthere is a portrait of some horses");
            System.out.println(p.nav("tv") + "\t\tthe TV is on ");
            System.out.println(p.nav("back") + "\t\tgo back");
            
            //extra nonsense for color
            System.out.println(p.getPlayerColor());
            String word = p.input();
            System.out.print(p.getResetColor());   
            
            switch (word) {
                case "coffeetable" -> coffeeTable(p);
                case "portrait" -> portrait(p);
                case "watch" -> tv(p);
                case "back" -> {return;}
                default -> System.out.println("Try again");
            }
        }
    }

    public static void coffeeTable(Player p){
        System.out.println("a few cups of half drinken coffee have been left here.");
        System.out.println("a club has been carved into the table, there is a " + p.getCode(2) + " in the middle of it.");
        if(p.getDrunk())
            System.out.println("there are 3 needles on the table... they havent been used yet... " + p.nav("forget"));
        System.out.println(p.nav("back"));
        
        System.out.println(p.getPlayerColor());
        String word = p.input();
        System.out.print(p.getResetColor());
        if(word.equals("forget")&&p.getDrunk()) forget(p);

    }

    public static void forget(Player p){
        System.out.println("you look at the needles for a long time. the craving is trying to consume you." + p.nav("use"));
        use(p);
        System.out.println("you should leave them where they are. " + p.nav("use"));
        use(p);
        System.out.println("theres enough for a final high. " + p.nav("use"));
        use(p);
        System.out.println("you gasp, coming out of the almost hypnotic trance you were in. you need to look in the mirror for a long time.");
        p.setDrunk(true);
        System.out.println(p.nav("back"));
        System.exit(0);
        p.delayInput();
    }

    public static void use(Player p) {
        while(true){
            System.out.println(p.getPlayerColor());
            String word = p.input();
            System.out.print(p.getResetColor());  

            if(word.equals("use")) 
                return;
            else
                System.out.println ("Theres no other option. \nits too late.");
                
        }
    }

    public static void portrait(Player p){

    }

    public static void tv(Player p){
        
    }
}
