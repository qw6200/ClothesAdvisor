package csc214.project3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by leew15 on 4/30/2017.
 */

public class CustomPagerAdapter extends android.support.v4.view.PagerAdapter {
    private Context context;
    private LayoutInflater inflater;

    public CustomPagerAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return DailyWeather.mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (object));
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.swipe, container, false);

        TextView dayTV = (TextView)view.findViewById(R.id.swipe_day);
        TextView weatherTV = (TextView)view.findViewById(R.id.swipe_weather);
        TextView lowTV = (TextView)view.findViewById(R.id.swipe_low);
        TextView highTV = (TextView)view.findViewById(R.id.swipe_high);

        dayTV.setText(getDay().get(position));
        weatherTV.setText("Weather Condition: " + DailyWeather.mList.get(position).getCondition());
        lowTV.setText("Temperature Low: " + DailyWeather.mList.get(position).getLow() + " degrees");
        highTV.setText("Temperature high: " + DailyWeather.mList.get(position).getHigh() + " degrees");

        container.addView(view);

        return view;
    }
    public List<String> getDay(){
        List<String> dayList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day) {
            case Calendar.SUNDAY:
                dayList.add("Sunday");
                dayList.add("Monday");
                dayList.add("Tuesday");
                dayList.add("Wednesday");
                dayList.add("Thursday");
                break;
            case Calendar.MONDAY:
                dayList.add("Monday");
                dayList.add("Tuesday");
                dayList.add("Wednesday");
                dayList.add("Thursday");
                dayList.add("Friday");
                break;

            case Calendar.TUESDAY:
                dayList.add("Tuesday");
                dayList.add("Wednesday");
                dayList.add("Thursday");
                dayList.add("Friday");
                dayList.add("Saturday");

            case Calendar.WEDNESDAY:
                dayList.add("Wednesday");
                dayList.add("Thursday");
                dayList.add("Friday");
                dayList.add("Saturday");
                dayList.add("Sunday");
                break;

            case Calendar.THURSDAY:
                dayList.add("Thursday");
                dayList.add("Friday");
                dayList.add("Saturday");
                dayList.add("Sunday");
                dayList.add("Monday");
                break;

            case Calendar.FRIDAY:
                dayList.add("Friday");
                dayList.add("Saturday");
                dayList.add("Sunday");
                dayList.add("Monday");
                dayList.add("Tuesday");
                break;

            case Calendar.SATURDAY:
                dayList.add("Saturday");
                dayList.add("Sunday");
                dayList.add("Monday");
                dayList.add("Tuesday");
                dayList.add("Wednesday");
                break;
        }
        return dayList;
    }
}
