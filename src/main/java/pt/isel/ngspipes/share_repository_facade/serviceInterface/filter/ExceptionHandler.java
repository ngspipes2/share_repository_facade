package pt.isel.ngspipes.share_repository_facade.serviceInterface.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pt.isel.ngspipes.share_repository_facade.serviceInterface.controller.exceptions.UnknownRepositoryTypeException;

@CrossOrigin
@ControllerAdvice
@RestController
public class ExceptionHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);



    @ResponseStatus(HttpStatus.NOT_FOUND)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = UnknownRepositoryTypeException.class)
    public String serverExceptionHandler(UnknownRepositoryTypeException e) {
        logUnknownRepositoryTypeException(e);
        return e.getMessage();
    }

    private void logUnknownRepositoryTypeException(UnknownRepositoryTypeException e) {
        String msg = "Unknown repository: " + e.getMessage();
        LOGGER.error(msg, e);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public String exceptionHandler(Exception e){
        logException(e);
        return "There was an Internal Error please try again later!";
    }

    private void logException(Exception e){
        String msg = "Error: " + e.getMessage();
        LOGGER.error(msg, e);
    }

}