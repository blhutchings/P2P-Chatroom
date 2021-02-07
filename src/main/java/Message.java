import java.util.Date;

public class Message {

    private final String DELIMITER = "~";

    private final Date date;
    private final int id;
    private final String message;

    public Message (Date date,int id,String message) {
        this.date = date;
        this.id = id;
        this.message = message;
    }

    public String toString() {
        return date.toString()+DELIMITER+id+message;
    }
}
