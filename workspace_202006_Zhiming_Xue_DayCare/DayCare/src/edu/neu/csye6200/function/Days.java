package edu.neu.csye6200.function;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.neu.csye6200.model.Datainit;

public class Days {
	public static int count(String date) {
		
		
		Date dnow = new Date();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd");
//        System.out.println(dt.format(dnow));
        String start = date;
        String end = dt.format(dnow);
        DateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
        Date start_time = null;
        Date end_time = null;
        try {
            start_time = fmt.parse(start);
            end_time = fmt.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        System.out.println(start_time);

        int days = 0;
        long time1 = start_time.getTime();
        long time2 = end_time.getTime();

        long diff;
        diff = time2 - time1;
        days = (int) (diff / (24 * 60 * 60 * 1000));
        return days;
		
		
	}
}
