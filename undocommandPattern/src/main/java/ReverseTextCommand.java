/**
 * Created by IntelliJ IDEA.
 * User: jtim
 * Date: 8/13/11
 * Time: 8:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseTextCommand implements ICommand {

    private StringReceiver receiver;

    public ReverseTextCommand(StringReceiver receiver) {
        this.receiver = receiver;
    }

    /*private String reverse(String text) {

        String result = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            result += text.charAt(i);
        }
        return result;
    }*/

    public void execute() {
        receiver.revertText();
    }

    public void cancel() {
        receiver.revertText();
    }
}
