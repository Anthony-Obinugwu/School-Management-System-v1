package unpopulardev.School.Management.System.v1;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record Student(Integer id,
                      @NotEmpty String first_name,
                      @NotEmpty String last_name,
                      @Positive @NotEmpty LocalDate birthDate,
                      @NotEmpty String Class) {

    public Student {
        if (first_name.isEmpty() || last_name.isEmpty() || Class.isEmpty()) {
            throw new IllegalArgumentException("You gotta check what you're typing g fr :/");
        }
    }

    public int calculateAge() {
        return AgeCalculator.calculateAge(birthDate);
    }
}
