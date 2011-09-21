/**
 * Created by IntelliJ IDEA.
 * User: jtim
 * Date: 8/14/11
 * Time: 1:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringReceiver {

    private StringBuilder stringBuilder = new StringBuilder("hello");

    public void addText(String text) {
        stringBuilder.append(text);
    }

    public void revertText() {
        stringBuilder.reverse();
    }

    public String getText() {
        return stringBuilder.toString();
    }

    public void removeText(String text) {
        stringBuilder.setLength(stringBuilder.length() - text.length());
    }

    //without cancel
    public void reset(){
        stringBuilder = null;
        stringBuilder = new StringBuilder("hello");
    }
}
