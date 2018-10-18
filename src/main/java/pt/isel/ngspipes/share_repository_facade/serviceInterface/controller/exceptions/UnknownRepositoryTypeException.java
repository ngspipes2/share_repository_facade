package pt.isel.ngspipes.share_repository_facade.serviceInterface.controller.exceptions;

public class UnknownRepositoryTypeException extends Exception {

    public UnknownRepositoryTypeException(String message) {
        super(message);
    }

    public UnknownRepositoryTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownRepositoryTypeException(Throwable cause) {
        super(cause);
    }

}
