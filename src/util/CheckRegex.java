package util;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckRegex {
    private static final Pattern emailPattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");

    private static final Pattern birthDayPattern = Pattern.compile("((18|19|20)[0-9]{2}[\\-.](0[13578]|1[02])[\\-.](0[1-9]|[12][0-9]|3[01]))|(18|19|20)[0-9]{2}[\\-.](0[469]|11)[\\-.](0[1-9]|[12][0-9]|30)|(18|19|20)[0-9]{2}[\\-.](02)[\\-.](0[1-9]|1[0-9]|2[0-8])|(((18|19|20)(04|08|[2468][048]|[13579][26]))|2000)[\\-.](02)[\\-.]29");

    public boolean checkEmail(String email){
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }

    public boolean checkBirthDay(String birthDay){
        int temp = Integer.parseInt(birthDay.substring(0, 4));
        Date d = new Date();
        int year = d.getYear();
        Matcher matcher = birthDayPattern.matcher(birthDay);
        return temp >= 1900 && temp < year + 1900 && matcher.matches();
    }
}
