import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: jtim
 * Date: 8/6/11
 * TimeCommand: 6:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class ActionConsole {

    private static final String ACTION = "Action? ";
    private static final String MACRO_ACTION = "x. New Macro";
    private static final String MACRO_NAME = "Name of Macro?";
    private static final String MACRO_SEQUENCE = "Sequence?";
    private static final String QUIT = "q. Quit";

    private static List<IActionCommand> actionCommandList = new ArrayList<IActionCommand>();

    private static TimeCommand timeCommand = new TimeCommand();
    private static NotepadCommand notepadCommand = new NotepadCommand();
    private static BeepCommand beepCommand = new BeepCommand();

    public static void main(String args[]) {
        /*Console console = System.console();
        if (console == null)
            new RuntimeException("No console available");
        printMenu(console);*/
        actionCommandList.add(timeCommand);
        actionCommandList.add(notepadCommand);
        actionCommandList.add(beepCommand);


        printMenu();

    }

    private static void printMenu() {

        /*if(console == null) System.out.println("No console");
        console.printf(ACTION);
        console.printf(TIME_ACTION);
        console.printf(NOTEPAD_ACTION);
        console.printf(BEEP_ACTION);
        console.printf(MACRO_ACTION);*/

        String c = "";
        while (!"q".equals(c)) {
            System.out.println(ACTION);

            for (int i = 0; i < actionCommandList.size(); i++) {
                String commandName = actionCommandList.get(i).getName();
                System.out.println(i + ". " + commandName);
            }

            System.out.println(MACRO_ACTION);
            System.out.println(QUIT);

            Scanner scanner = new Scanner(System.in);
            String action = scanner.next();

            readMenu(action);

        }

    }

    private static void readMenu(String s) {

        if ("x".equals(s)) {
            readMacro();
        } else if ("q".equals(s)) {
            System.exit(0);
        } else {
            int i = Integer.parseInt(s);
            actionCommandList.get(i).execute();
        }
    }

    private static void readMacro() {

        /*BufferedReader bufferedReader=null;
        String name="";
        System.out.println(MACRO_NAME);
        bufferedReader = new BufferedReader(new InputStreamReader(System.in)) ;

        try {

            name = bufferedReader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }*/

        System.out.println(MACRO_NAME);

        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        System.out.println(MACRO_SEQUENCE);
        String sequence = scanner.next();
        String[] tokens = sequence.split(",");

        createMacroCommand(name, tokens);

        scanner.close();
    }

    private static void createMacroCommand(String name, String[] actions) {

        List<IActionCommand> commands = new ArrayList<IActionCommand>();
        for (String token : actions) {
            IActionCommand command = (IActionCommand) actionCommandList.get(Integer.parseInt(token));
            commands.add(command);
        }

        MacroActionCommand macroCommand = new MacroActionCommand(commands);
        macroCommand.setName(name);

        actionCommandList.add(macroCommand);
        printMenu();
    }

}
