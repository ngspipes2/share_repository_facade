package pt.isel.ngspipes.share_repository_facade.serviceInterface.controller.implementation;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pt.isel.ngspipes.dsl_core.descriptors.tool.ToolsRepositoryFactory;
import pt.isel.ngspipes.share_repository_facade.serviceInterface.controller.dto.DataWrapper;
import pt.isel.ngspipes.share_repository_facade.serviceInterface.controller.exceptions.UnknownRepositoryTypeException;
import pt.isel.ngspipes.share_repository_facade.serviceInterface.controller.facade.IToolsRepositoryServerController;
import pt.isel.ngspipes.tool_descriptor.interfaces.IToolDescriptor;
import pt.isel.ngspipes.tool_repository.interfaces.IToolsRepository;

import java.util.Collection;

@RestController
@CrossOrigin
public class ToolsRepositoryServerController implements IToolsRepositoryServerController {

    @Override
    public ResponseEntity<byte[]> getLogo(@RequestBody DataWrapper<Void> data) throws Exception {
        IToolsRepository repository = ToolsRepositoryFactory.create(data.repositoryLocation, data.repositoryConfig);

        if(repository == null)
            throw new UnknownRepositoryTypeException("Unknown type of repository!" + data.repositoryLocation);

        byte[] logo = repository.getLogo();

        if(logo != null && !Base64.isBase64(logo))
            logo = Base64.encodeBase64(logo);

        return new ResponseEntity<>(logo, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> setLogo(@RequestBody DataWrapper<byte[]> data) throws Exception {
        IToolsRepository repository = ToolsRepositoryFactory.create(data.repositoryLocation, data.repositoryConfig);

        if(repository == null)
            throw new UnknownRepositoryTypeException("Unknown type of repository!" + data.repositoryLocation);

        repository.setLogo(data.data);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Collection<IToolDescriptor>> getAllTools(@RequestBody DataWrapper<Void> data) throws Exception {
        IToolsRepository repository = ToolsRepositoryFactory.create(data.repositoryLocation, data.repositoryConfig);

        if(repository == null)
            throw new UnknownRepositoryTypeException("Unknown type of repository!" + data.repositoryLocation);

        return new ResponseEntity<>(repository.getAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<IToolDescriptor> getTool(@PathVariable String toolName, @RequestBody DataWrapper<Void> data) throws Exception {
        IToolsRepository repository = ToolsRepositoryFactory.create(data.repositoryLocation, data.repositoryConfig);

        if(repository == null)
            throw new UnknownRepositoryTypeException("Unknown type of repository!" + data.repositoryLocation);

        return new ResponseEntity<>(repository.get(toolName), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> insertTool(@RequestBody DataWrapper<IToolDescriptor> data) throws Exception {
        IToolsRepository repository = ToolsRepositoryFactory.create(data.repositoryLocation, data.repositoryConfig);

        if(repository == null)
            throw new UnknownRepositoryTypeException("Unknown type of repository!" + data.repositoryLocation);

        repository.insert(data.data);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateTool(@PathVariable String toolName, @RequestBody DataWrapper<IToolDescriptor> data) throws Exception {
        IToolsRepository repository = ToolsRepositoryFactory.create(data.repositoryLocation, data.repositoryConfig);

        if(repository == null)
            throw new UnknownRepositoryTypeException("Unknown type of repository!" + data.repositoryLocation);

        repository.update(data.data);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteTool(@PathVariable String toolName, @RequestBody DataWrapper<Void> data) throws Exception {
        IToolsRepository repository = ToolsRepositoryFactory.create(data.repositoryLocation, data.repositoryConfig);

        if(repository == null)
            throw new UnknownRepositoryTypeException("Unknown type of repository!" + data.repositoryLocation);

        repository.delete(toolName);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
