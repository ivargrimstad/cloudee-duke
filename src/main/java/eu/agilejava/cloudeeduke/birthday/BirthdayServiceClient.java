package eu.agilejava.cloudeeduke.birthday;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.enterprise.context.ApplicationScoped;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.temporal.ChronoUnit;

@CircuitBreaker(delay = 10, delayUnit = ChronoUnit.SECONDS, requestVolumeThreshold = 3, failureRatio = 1.0)
@Timeout(value = 3, unit = ChronoUnit.SECONDS)
@ApplicationScoped
public class BirthdayServiceClient {

    @Fallback(BirthdayFallbackHandler.class)
    public Integer getDaysToBirthday(String date) {

        try {
            return Integer.parseInt(RestClientBuilder.newBuilder()
                    .baseUrl(new URL("https://birthdayduke-ivar.eucom-north-1.oraclecloud.com"))
                    .build(BirthdayService.class)
                    .daysToBirthday(date));
        } catch (MalformedURLException e) {
            return -999;
        }

    }
}

