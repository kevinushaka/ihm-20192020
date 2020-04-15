package com.example.ihm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarFragment extends Fragment implements Mocks ,IFragmentsKey {

    public CalendarFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.fragment_calendar,container,false);
        CalendarView calendarView =rootView.findViewById(R.id.calendar);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                FishingHoursFragment fishingHoursFragment= new FishingHoursFragment();
                Bundle bundle=new Bundle();
                List<Event> eventsList=new ArrayList<>();
                month++;
                for(int i=0; i<EVENTS.length;i++){
                    if(year==EVENTS[i].getYearStart()&&
                            month==EVENTS[i].getMonthStart()&&
                            dayOfMonth==EVENTS[i].getDayOfMonthStart()){
                        eventsList.add(EVENTS[i]);
                    }
                }
                 Event[] eventsArray=new Event[eventsList.size()];
                for(int i =0; i<eventsArray.length;i++)
                    eventsArray[i]=eventsList.get(i);
                bundle.putParcelableArray(FISHING_HOURS_LIST,eventsArray);
                fishingHoursFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout,fishingHoursFragment).commit();
            }
        });
        return rootView;
    }

}
