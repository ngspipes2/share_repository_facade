package pt.isel.ngspipes.share_repository_facade.serviceInterface.controller.facade;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.isel.ngspipes.pipeline_descriptor.IPipelineDescriptor;
import pt.isel.ngspipes.share_repository_facade.serviceInterface.config.Routes;
import pt.isel.ngspipes.share_repository_facade.serviceInterface.controller.dto.DataWrapper;

import java.util.Collection;

@CrossOrigin
@RestController
public interface IPipelinesRepositoryServerController {

    @RequestMapping(value = Routes.PIPELINES_FACADE_GET_LOGO_URI, method = RequestMethod.POST)
    ResponseEntity<byte[]> getLogo(@RequestBody DataWrapper<Void> data) throws Exception;

    @RequestMapping(value = Routes.PIPELINES_FACADE_SET_LOGO_URI, method = RequestMethod.POST)
    ResponseEntity<Void> setLogo(@RequestBody DataWrapper<byte[]> data) throws Exception;

    @RequestMapping(value = Routes.PIPELINES_FACADE_GET_ALL_PIPELINES_URI, method = RequestMethod.POST)
    ResponseEntity<Collection<IPipelineDescriptor>> getAllPipelines(@RequestBody DataWrapper<Void> data) throws Exception;

    @RequestMapping(value = Routes.PIPELINES_FACADE_GET_PIPELINE_URI, method = RequestMethod.POST)
    ResponseEntity<IPipelineDescriptor> getPipeline(@PathVariable String pipelineName, @RequestBody DataWrapper<Void> data) throws Exception;

    @RequestMapping(value = Routes.PIPELINES_FACADE_INSERT_PIPELINE_URI, method = RequestMethod.POST)
    ResponseEntity<Void> insertPipeline(@RequestBody DataWrapper<IPipelineDescriptor> data) throws Exception;

    @RequestMapping(value = Routes.PIPELINES_FACADE_UPDATE_PIPELINE_URI, method = RequestMethod.POST)
    ResponseEntity<Void> updatePipeline(@PathVariable String pipelineName, @RequestBody DataWrapper<IPipelineDescriptor> data) throws Exception;

    @RequestMapping(value = Routes.PIPELINES_FACADE_DELETE_PIPELINE_URI, method = RequestMethod.POST)
    ResponseEntity<Void> deletePipeline(@PathVariable String pipelineName, @RequestBody DataWrapper<Void> data) throws Exception;

}
