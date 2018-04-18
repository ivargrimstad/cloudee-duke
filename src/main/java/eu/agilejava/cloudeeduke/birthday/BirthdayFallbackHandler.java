package eu.agilejava.cloudeeduke.birthday;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

import javax.enterprise.context.Dependent;

@Dependent
public class BirthdayFallbackHandler implements FallbackHandler<Integer> {


    @Override
    public Integer handle(ExecutionContext executionContext) {
        return -1;
    }
}
