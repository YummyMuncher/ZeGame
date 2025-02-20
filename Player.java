import java.util.Random;
import java.util.Scanner;

public class Player {
    static final private String navCol = "\u001B[33m";
    static final private String resetCol = "\u001B[37m";
    static final private String playerCol = "\u001B[34m";

    private boolean drunk = true;
    private boolean hasKey = false;
    public Scanner scan;
    Random codeGen;
    private String code; 
    private boolean mirrorBroken = false;


    public Player() {
        scan = new Scanner(System.in);
        codeGen = new Random();
        code = Integer.toString(codeGen.nextInt(10)) 
        + Integer.toString(codeGen.nextInt(10)) 
        + Integer.toString(codeGen.nextInt(10)) 
        + Integer.toString(codeGen.nextInt(10));
    }

    public String getCode(int index){
        return code.substring(index, index+1);
    }
    public void setDrunk(boolean drunk) {
        this.drunk = drunk;
    }
    
    public boolean getDrunk() {
        return drunk;
    }

    public void setKey(boolean key) {
        this.hasKey = key;
    }
    
    public boolean getKey() {
        return hasKey;
    }

    public void setMirror(boolean mirror){
        mirrorBroken = mirror;
    }
    
    public boolean getMirror(){
        return mirrorBroken;
    }

    public String getNavColor(){
        return navCol;
    }

    public String getResetColor(){
        return resetCol;
    }

    public String getPlayerColor(){
        return playerCol;
    }

    public String nav(String text) {
        return getNavColor() + "[" + text + "]" + getResetColor();
    }

    public String input() {
        return scan.next().toLowerCase().trim();
    }

    public void delayInput(){
        System.out.println(getPlayerColor());
        input();
        System.out.print(getResetColor());  
    }
}
