/**
 * Created by IntelliJ IDEA.
 * User: jtim
 * Date: 8/6/11
 * TimeCommand: 7:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class NotepadCommand implements IActionCommand {

    public String getName() {
        return "Notepad";
    }

    public void execute() {
        System.out.println("NOTEPAD!");
    }
}

