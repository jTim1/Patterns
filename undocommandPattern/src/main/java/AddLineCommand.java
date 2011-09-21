/**
 * Created by IntelliJ IDEA.
 * User: jtim
 * Date: 8/14/11
 * Time: 1:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddLineCommand implements ICommand{

    private StringReceiver receiver;

    public AddLineCommand(StringReceiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        receiver.addText("\n");
    }

    public void cancel() {
        receiver.removeText("\n");
    }
}
