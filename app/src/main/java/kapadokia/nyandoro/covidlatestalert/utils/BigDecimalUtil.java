package kapadokia.nyandoro.covidlatestalert.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BigDecimalUtil {

    public static String getValue(long value){
        DecimalFormat df = new DecimalFormat("###,###,###");
        return String.valueOf(df.format(value));
    }
    /*
        For rating bar (actual rating)
     */
    public static float getFloat(BigDecimal value){
        return value.floatValue();
    }
}
