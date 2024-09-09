package unpopulardev.School.Management.System.v1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class AgeCalculator {
    public static int calculateAge(LocalDate birthdate){
        LocalDate currentDate = LocalDate.now();
        if (birthdate != null) {
            return Period.between(birthdate, currentDate).getYears();
        } else {
            throw new IllegalArgumentException("I think you might wanna cross-check your birthday bro");
        }
    }
}
