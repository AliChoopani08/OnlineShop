package example;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Logger;

public class InputAndOutput {
    private final Scanner scanner;
    public final PrintStream printStream;

    public final Logger logger=Logger.getLogger(InputAndOutput.class.getName());

    public InputAndOutput(Scanner scanner, PrintStream printStream) {
        this.scanner = scanner;
        this.printStream = printStream;
    }
    public InputAndOutput(){
        this(new Scanner(System.in),System.out);
    }

    public String nextLine(){
        return scanner.nextLine();
    }
    public int nextInt(){
        return scanner.nextInt();
    }
    public void println(String msg){
        printStream.println(msg);
    }

}
