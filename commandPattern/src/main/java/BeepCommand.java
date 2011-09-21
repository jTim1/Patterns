import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: jtim
 * Date: 8/6/11
 * TimeCommand: 7:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class BeepCommand implements IActionCommand {

    public void execute() {

        System.out.println("BEEP!");
        Toolkit.getDefaultToolkit().beep();
    }

    public String getName() {
        return "Beep";
    }
}
