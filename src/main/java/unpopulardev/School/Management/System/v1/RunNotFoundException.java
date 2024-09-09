package unpopulardev.School.Management.System.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RunNotFoundException extends RuntimeException {
    public RunNotFoundException(){
        super("I ain't find nun like that cuh, might wanna run it back");
    }
}
