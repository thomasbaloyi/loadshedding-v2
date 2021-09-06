import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Provides an interactive way of accessing the loadshedding schedule.
 *
 * Loadshedding is the systematic shutdown of power to households
 * and organisations by Eskom. It occurs at different stages, times,
 * and days for different areas.
 * 
 * The user will key in the stage, time, and day; the program
 * will then output a list of areas affected given the input. If one or more of
 * the three parameters are not entered, the program will print out the entire
 * schedule. 
 * 
 * @author Thomas Baloyi
 * @version 1
 * 12.03.2020
 */
public class LSAVLApp {

    /** File containing loadshedding schedule. */
    private static File schedule;
    
    /** File containig the number of find operations */
    private static File operations;
    
    /** Contains the number of comparison operations when @tree find method is invoked. */
    private static File findOperations;
    
    /** Contains the number of comparison operations when @tree insert method is invoked. */
    private static File insertOperations;
    
    /** AVL Tree of all data items collected from 'schedule' file. */
    private static AVLTree tree;
    
    /** Used to write @findOperations. */
    private static FileWriter findWriter;
    
    /** Used to write @insertOperations. */
    private static FileWriter insertWriter;
    
    public static void main(String[] args) throws Exception {
        tree = new AVLTree();
        schedule = new File("../data/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        Scanner fileScan = new Scanner(schedule);
        
        // Add all data items into AVL tree
        while(fileScan.hasNextLine()) {
            tree.insert(fileScan.nextLine());
        }
        
        if (args.length==0) {
            printAllAreas();
        }
        else if (args.length==3) {
            printAreas(args[0], args[1], args[2]);
        }
        else if (args.length==1) {
            printAreas(args[0]);
        }
	
        // writeToFile();
        System.out.println("Operations: " + tree.getFindOpCount());
    }
    
    /**
     * Search for and print out list of areas affected by loadshedding given parameters.
     *
     * @param stage Loadshedding occurs from stages ranging from one to eight.
     * @param day a particular day during which loadshedding may occur.
     * @param startTime the time when loadshedding is expected to begin.
     */
     public static void printAreas(String stage, String day, String startTime) {
         String param = stage + "_" + day + "_" + startTime;
         tree.printNodeData(param);
     }
    
    /** Prints out all areas affected by loadshedding. */ 
    public static void printAllAreas() {
        tree.printInOrder();
    }
    
    /** Prints out areas affected by loadshedding that match with this key. */
    public static void printAreas(String key) {
        tree.printNodeData(key);
    }
    
    /** Writes the number of operations performed in a file. */
    private static void writeToFile() throws Exception {
        findOperations = new File("../Test_Output/Part4/FindOperations.txt");
        findOperations.createNewFile();
        findWriter = new FileWriter(findOperations, true);
        findWriter.write("" + tree.getFindOpCount() + "\n");
        findWriter.close();
        
        insertOperations = new File("../Test_Output/Part4/InsertOperations.txt");
        insertOperations.createNewFile();
        insertWriter = new FileWriter(insertOperations, true);
        insertWriter.write("" + tree.getInsertOpCount() + "\n");
        insertWriter.close(); 
    }
}
