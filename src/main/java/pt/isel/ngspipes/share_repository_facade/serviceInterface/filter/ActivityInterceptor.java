package pt.isel.ngspipes.share_repository_facade.serviceInterface.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.handler.MappedInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@Component
public class ActivityInterceptor extends HandlerInterceptorAdapter {

    private static final String UNAUTHENTICATED_USER_NAME = "UnauthenticatedUser";
    private static final String REQUEST_MSG = "REQUEST -> %s %s";
    private static final String RESPONSE_MSG = "RESPONSE -> %s %s %s";



    private final Logger LOGGER = LoggerFactory.getLogger(ActivityInterceptor.class);



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logRequestReceived(request);
        return true;
    }

    private void logRequestReceived(HttpServletRequest request) {
        String url = request.getRequestURI();
        String method = request.getMethod();

        LOGGER.info(String.format(REQUEST_MSG, method, url));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logRequestAnswered(request, response);
    }

    private void logRequestAnswered(HttpServletRequest request, HttpServletResponse response) {
        String method = request.getMethod();
        String uri = request.getRequestURI();
        int status = response.getStatus();

        LOGGER.info(String.format(RESPONSE_MSG, method, uri, status));
    }

    @Bean
    private MappedInterceptor getActivityInterceptor() {
        return new MappedInterceptor(null, this);
    }

}