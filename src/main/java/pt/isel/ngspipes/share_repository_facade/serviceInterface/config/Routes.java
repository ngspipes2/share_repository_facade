package pt.isel.ngspipes.share_repository_facade.serviceInterface.config;

public class Routes {

    public static final String TOOLS_REPOSITORY_FACADE_URI = "/tools";

    public static final String TOOLS_FACADE_GET_LOGO_URI = TOOLS_REPOSITORY_FACADE_URI + "/getlogo";
    public static final String TOOLS_FACADE_SET_LOGO_URI = TOOLS_REPOSITORY_FACADE_URI + "/setlogo";
    public static final String TOOLS_FACADE_GET_ALL_TOOLS_URI = TOOLS_REPOSITORY_FACADE_URI + "/gettools";
    public static final String TOOLS_FACADE_GET_TOOL_URI = TOOLS_REPOSITORY_FACADE_URI + "/gettool/{toolName}";
    public static final String TOOLS_FACADE_INSERT_TOOL_URI = TOOLS_REPOSITORY_FACADE_URI + "/inserttool";
    public static final String TOOLS_FACADE_UPDATE_TOOL_URI = TOOLS_REPOSITORY_FACADE_URI + "/updatetool/{toolName}";
    public static final String TOOLS_FACADE_DELETE_TOOL_URI = TOOLS_REPOSITORY_FACADE_URI + "/deletetool/{toolName}";



    public static final String PIPELINES_REPOSITORY_FACADE_URI = "/pipelines";

    public static final String PIPELINES_FACADE_GET_LOGO_URI = PIPELINES_REPOSITORY_FACADE_URI + "/getlogo";
    public static final String PIPELINES_FACADE_SET_LOGO_URI = PIPELINES_REPOSITORY_FACADE_URI + "/setlogo";
    public static final String PIPELINES_FACADE_GET_ALL_PIPELINES_URI = PIPELINES_REPOSITORY_FACADE_URI + "/getpipelines";
    public static final String PIPELINES_FACADE_GET_PIPELINE_URI = PIPELINES_REPOSITORY_FACADE_URI + "/getpipeline/{pipelineName}";
    public static final String PIPELINES_FACADE_INSERT_PIPELINE_URI = PIPELINES_REPOSITORY_FACADE_URI + "/insertpipeline";
    public static final String PIPELINES_FACADE_UPDATE_PIPELINE_URI = PIPELINES_REPOSITORY_FACADE_URI + "/updatepipeline/{pipelineName}";
    public static final String PIPELINES_FACADE_DELETE_PIPELINE_URI = PIPELINES_REPOSITORY_FACADE_URI + "/deletepipeline/{pipelineName}";

}
