import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jtim
 * Date: 8/6/11
 * TimeCommand: 7:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class MacroActionCommand implements IActionCommand {

    private List<IActionCommand> commands;
    private String name;

    public MacroActionCommand(List<IActionCommand> commands) {
        this.commands = commands;
    }

    public List<IActionCommand> getCommands() {
        return commands;
    }

    public String getName() {
        return name;
    }

    public void execute() {
        for(IActionCommand action : commands)
        {
            action.execute();
        }
    }

    public void setName(String name) {
        this.name = name;
    }
}
