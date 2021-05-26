import java.util.ArrayList;
import java.util.List;

class Time {
    int hours;
    int minutes;
    int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
};

public class SILab2 {

    public List<Integer> function(List<Time> timesList) {
        List<Integer> result = new ArrayList<>();       // node A

        for (int i = 0; i < timesList.size(); i++) {    // node B
            int hr = timesList.get(i).getHours();       // node C
            int min = timesList.get(i).getMinutes();    // node C
            int sec = timesList.get(i).getSeconds();    // node C
            if (hr < 0 || hr > 24){                     // node C
                if (hr < 0){                            // node D
                    throw new RuntimeException("The hours are smaller than the minimum"); // node E
                }
                else {
                    throw new RuntimeException("The hours are grater than the maximum"); // node F
                }
            }
            else if (hr < 24) {                         // node G
                if (min < 0 || min > 59)                // node H
                    throw new RuntimeException("The minutes are not valid!"); // node I
                else {
                    if (sec >= 0 && sec <= 59) // node J
                        result.add(hr * 3600 + min * 60 + sec); // node K
                    else
                        throw new RuntimeException("The seconds are not valid"); // node L
                }
            }
            else if (hr == 24 && min == 0 && sec == 0) { // node M
                result.add(hr * 3600 + min * 60 + sec); // node N
            }
            else {
                throw new RuntimeException("The time is greater than the maximum"); //node O
            }
        }
        return result; // node P
    }// node Q

    public static void main(String[] args) {
        SILab2 siLab2 = new SILab2();
        List<Time> timeList = new ArrayList<>();
        Time time1 = new Time(12,45,30);
        timeList.add(time1);
        List<Integer> pomTimeList = siLab2.function(timeList);
        System.out.println(pomTimeList.get(0).intValue());
    }
}