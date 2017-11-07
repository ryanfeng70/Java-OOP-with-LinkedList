import java.util.Comparator;

public class CompareTo implements Comparator<ScheduleInfo> {
    
    @Override
    public int compare(ScheduleInfo o1, ScheduleInfo o2) {
        return o1.getMonth_as_Int() - o2.getMonth_as_Int();
        //Sorts Linked List items by ascending month
    }
    
}
