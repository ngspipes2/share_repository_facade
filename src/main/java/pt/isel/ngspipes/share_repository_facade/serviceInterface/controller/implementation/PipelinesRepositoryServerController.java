package pt.isel.ngspipes.share_repository_facade.serviceInterface.controller.implementation;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pt.isel.ngspipes.dsl_core.descriptors.pipeline.PipelinesRepositoryFactory;
import pt.isel.ngspipes.pipeline_descriptor.IPipelineDescriptor;
import pt.isel.ngspipes.pipeline_repository.IPipelinesRepository;
import pt.isel.ngspipes.share_repository_facade.serviceInterface.controller.dto.DataWrapper;
import pt.isel.ngspipes.share_repository_facade.serviceInterface.controller.exceptions.UnknownRepositoryTypeException;
import pt.isel.ngspipes.share_repository_facade.serviceInterface.controller.facade.IPipelinesRepositoryServerController;

import java.util.Collection;

@RestController
public class PipelinesRepositoryServerController implements IPipelinesRepositoryServerController {

    @Override
    public ResponseEntity<byte[]> getLogo(@RequestBody DataWrapper<Void> data) throws Exception {
        IPipelinesRepository repository = PipelinesRepositoryFactory.create(data.repositoryLocation, data.repositoryConfig);

        if(repository == null)
            throw new UnknownRepositoryTypeException("Unknown type of repository!" + data.repositoryLocation);

        byte[] logo = repository.getLogo();

        if(logo != null && !Base64.isBase64(logo))
            logo = Base64.encodeBase64(logo);

        return new ResponseEntity<>(logo, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> setLogo(@RequestBody DataWrapper<byte[]> data) throws Exception {
        IPipelinesRepository repository = PipelinesRepositoryFactory.create(data.repositoryLocation, data.repositoryConfig);

        if(repository == null)
            throw new UnknownRepositoryTypeException("Unknown type of repository!" + data.repositoryLocation);

        repository.setLogo(data.data);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Collection<IPipelineDescriptor>> getAllPipelines(@RequestBody DataWrapper<Void> data) throws Exception {
        IPipelinesRepository repository = PipelinesRepositoryFactory.create(data.repositoryLocation, data.repositoryConfig);

        if(repository == null)
            throw new UnknownRepositoryTypeException("Unknown type of repository!" + data.repositoryLocation);

        Collection<IPipelineDescriptor> pipelines = repository.getAll();

        return new ResponseEntity<>(pipelines, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<IPipelineDescriptor> getPipeline(@PathVariable String pipelineName, @RequestBody DataWrapper<Void> data) throws Exception {
        IPipelinesRepository repository = PipelinesRepositoryFactory.create(data.repositoryLocation, data.repositoryConfig);

        if(repository == null)
            throw new UnknownRepositoryTypeException("Unknown type of repository!" + data.repositoryLocation);

        IPipelineDescriptor pipeline = repository.get(pipelineName);

        return new ResponseEntity<>(pipeline, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> insertPipeline(@RequestBody DataWrapper<IPipelineDescriptor> data) throws Exception {
        IPipelinesRepository repository = PipelinesRepositoryFactory.create(data.repositoryLocation, data.repositoryConfig);

        if(repository == null)
            throw new UnknownRepositoryTypeException("Unknown type of repository!" + data.repositoryLocation);

        repository.insert(data.data);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updatePipeline(@PathVariable String pipelineName, @RequestBody DataWrapper<IPipelineDescriptor> data) throws Exception {
        IPipelinesRepository repository = PipelinesRepositoryFactory.create(data.repositoryLocation, data.repositoryConfig);

        if(repository == null)
            throw new UnknownRepositoryTypeException("Unknown type of repository!" + data.repositoryLocation);

        repository.update(data.data);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deletePipeline(@PathVariable String pipelineName, @RequestBody DataWrapper<Void> data) throws Exception {
        IPipelinesRepository repository = PipelinesRepositoryFactory.create(data.repositoryLocation, data.repositoryConfig);

        if(repository == null)
            throw new UnknownRepositoryTypeException("Unknown type of repository!" + data.repositoryLocation);

        repository.delete(pipelineName);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
