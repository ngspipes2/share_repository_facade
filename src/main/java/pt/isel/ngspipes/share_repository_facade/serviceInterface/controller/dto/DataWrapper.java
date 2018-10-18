package pt.isel.ngspipes.share_repository_facade.serviceInterface.controller.dto;

import java.util.Map;

public class DataWrapper<T> {

    public String repositoryLocation;
    public Map<String, Object> repositoryConfig;
    public T data;

}
