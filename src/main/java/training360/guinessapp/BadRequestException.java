package training360.guinessapp;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class BadRequestException extends AbstractThrowableProblem {

    public BadRequestException(String uri, String title, String message) {
        super(URI.create(uri),
                title,
                Status.BAD_REQUEST,
                message);
    }
}
