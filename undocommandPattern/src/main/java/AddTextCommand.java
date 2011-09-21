/**
 * Created by IntelliJ IDEA.
 * User: jtim
 * Date: 8/13/11
 * Time: 7:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddTextCommand implements ICommand {

    private final StringReceiver receiver;
    private final String text;

    public AddTextCommand(StringReceiver receiver, String text) {
        this.receiver = receiver;
        this.text = text;
    }

    public void execute() {
        receiver.addText(text);
    }

    public void cancel() {
        receiver.removeText(text);
    }
}
