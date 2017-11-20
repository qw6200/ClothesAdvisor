package csc214.project3;

/**
 * Created by leew15 on 4/30/2017.
 */

public class Weather {
    public String condition;
    public int low;
    public int high;

    public Weather(String c, int l, int h){
        condition = c;
        low = l;
        high = h;
    }
    public String toString(){
        return "" + condition + ", " + low + ", " + high;
    }
    public String getCondition(){
        return condition;
    }
    public int getLow(){
        return low;
    }
    public int getHigh(){
        return high;
    }
}
