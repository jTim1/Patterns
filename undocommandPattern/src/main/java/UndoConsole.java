import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: jtim
 * Date: 8/13/11
 * Time: 7:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class UndoConsole {

    public static String HELLO = "Hello";
    public static String ACTION = "Action?";
    public static String EXIT_ACTION = "Exit";
    private static final String ADD_LINE_ACTION = "Add Line";
    private static final String ADD_TEXT_ACTION = "Add Text";
    private static final String REVERSE_TEXT_ACTION = "Reverse Text";
    private static final String CANCEL_ACTION = "Cancel";

    private static String [] commandsName = new String [] {ADD_TEXT_ACTION, REVERSE_TEXT_ACTION, ADD_LINE_ACTION, CANCEL_ACTION, EXIT_ACTION};
    private static List<ICommand> commands = new ArrayList<ICommand>();
    private static StringReceiver receiver = new StringReceiver();

    public static void main(String[] args) {

        readMenu();
    }

    private static void readMenu() {

        String c = "";
        while (!"E".equals(c)) {
            System.out.println(receiver.getText());

            printActions();

            System.out.println(ACTION);
            Scanner scanner = new Scanner(System.in);
            String action = scanner.next();

            executeActions(action);
        }

    }

    private static void printActions() {

        for (int i = 0; i < commandsName.length; i++) {

            System.out.println(i + ". " + commandsName[i]);
        }
    }

    private static void executeActions(String action) {

        int i = Integer.parseInt(action);

        switch (i) {
            case 0 :
                addText();
                 break;
            case 1 :
                reverseText();
                 break;
            case 2 :
                addLine();
                 break;
            case 3 :
                undo();
                break;
            case 4 :
                System.exit(0);
                break;
        }
    }

    private static void undo() {
        /*int size = commands.size();
        if (size != 0) {
            ICommand lastCommand = commands.get(size -1);
            lastCommand.cancel();
            commands.remove(size - 1);
        }*/
        receiver.reset();

        commands.remove(commands.size() - 1);
        for (ICommand command : commands) {
            command.execute();
        }
    }

    private static void addLine() {
        AddLineCommand addLineCommand = new AddLineCommand(receiver);
        commands.add(addLineCommand);
        addLineCommand.execute();
    }

    private static void reverseText() {
        ReverseTextCommand reverseTextCommand = new ReverseTextCommand(receiver);
        commands.add(reverseTextCommand);
        reverseTextCommand.execute();
    }

    private static void addText() {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        AddTextCommand addTextCommand = new AddTextCommand(receiver,text);
        commands.add(addTextCommand);
        addTextCommand.execute();
    }
}
