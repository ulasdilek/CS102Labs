package lab05;

public class Portal {
    
    private int[] entry;
    private int[] exit ;

    public Portal(int[] entry, int[] exit) {
        this.entry = entry;
        this.exit  = exit ;
    }

    public int[] getEntry() {
        return entry;
    }

    public int[] getExit() {
        return exit;
    }

}
