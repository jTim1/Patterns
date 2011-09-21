import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jtim
 * Date: 8/14/11
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class UndoCommand {

    private final String CANCEL_ACTION="Cancel";
    private List<ICommand> commands = new ArrayList<ICommand>();

/*    public void execute() {
        for (ICommand command : commands) {
            command.execute();
        }
    }

    public void cancel() {
        for (ICommand command : commands) {
            return command.cancel();
        }
        return null;
    }*/

    public List<ICommand> getCommands() {
        return commands;
    }

    public String getName() {
        return CANCEL_ACTION;
    }
}
