package pt.isel.ngspipes.share_repository_facade.serviceInterface.controller.facade;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.isel.ngspipes.share_repository_facade.serviceInterface.config.Routes;
import pt.isel.ngspipes.share_repository_facade.serviceInterface.controller.dto.DataWrapper;
import pt.isel.ngspipes.tool_descriptor.interfaces.IToolDescriptor;

import java.util.Collection;

@CrossOrigin
@RestController
public interface IToolsRepositoryServerController {

    @RequestMapping(value = Routes.TOOLS_FACADE_GET_LOGO_URI, method = RequestMethod.POST)
    ResponseEntity<byte[]> getLogo(@RequestBody DataWrapper<Void> data) throws Exception;

    @RequestMapping(value = Routes.TOOLS_FACADE_SET_LOGO_URI, method = RequestMethod.POST)
    ResponseEntity<Void> setLogo(@RequestBody DataWrapper<byte[]> data) throws Exception;

    @RequestMapping(value = Routes.TOOLS_FACADE_GET_ALL_TOOLS_URI, method = RequestMethod.POST)
    ResponseEntity<Collection<IToolDescriptor>> getAllTools(@RequestBody DataWrapper<Void> data) throws Exception;

    @RequestMapping(value = Routes.TOOLS_FACADE_GET_TOOL_URI, method = RequestMethod.POST)
    ResponseEntity<IToolDescriptor> getTool(@PathVariable String toolName, @RequestBody DataWrapper<Void> data) throws Exception;

    @RequestMapping(value = Routes.TOOLS_FACADE_INSERT_TOOL_URI, method = RequestMethod.POST)
    ResponseEntity<Void> insertTool(@RequestBody DataWrapper<IToolDescriptor> data) throws Exception;

    @RequestMapping(value = Routes.TOOLS_FACADE_UPDATE_TOOL_URI, method = RequestMethod.POST)
    ResponseEntity<Void> updateTool(@PathVariable String toolName, @RequestBody DataWrapper<IToolDescriptor> data) throws Exception;

    @RequestMapping(value = Routes.TOOLS_FACADE_DELETE_TOOL_URI, method = RequestMethod.POST)
    ResponseEntity<Void> deleteTool(@PathVariable String toolName, @RequestBody DataWrapper<Void> data) throws Exception;

}
