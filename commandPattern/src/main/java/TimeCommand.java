import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by IntelliJ IDEA.
 * User: jtim
 * Date: 8/6/11
 * TimeCommand: 6:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class TimeCommand implements IActionCommand{

    public void execute() {

        GregorianCalendar calendar = new GregorianCalendar();
        Date date = calendar.getTime();
        DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.SHORT);
        String time = dateFormat.format(date);

        System.out.println(time);
    }

    public String getName() {
        return "Time";
    }
    
}
