package WarehouseSystemManager.interceptor;

import WarehouseSystemManager.model.RobotRequest;
import WarehouseSystemManager.service.RobotRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Date;

@Component
public class RemoteInterceptor implements HandlerInterceptor {

    @Autowired
    private RobotRequestService robotRequestService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        String robotId = request.getParameter("robotId");
        System.out.println(response.getStatus());
        if(robotId != null){
            RobotRequest robotRequest = new RobotRequest();
            Date date = new Date();
            robotRequest.setTime(new Timestamp(date.getTime()));
            robotRequest.setDataSize(request.getRequestURI().length() * 2);
            robotRequest.setHost(request.getRemoteHost());
            robotRequest.setRobotId(Integer.parseInt(robotId));
            String acceptStatus = response.getStatus() == 200 ? "accept" : "reject";
            robotRequest.setAcceptState(acceptStatus);
            int i = robotRequestService.addRobotRequest(robotRequest);
            if(i == 0){
                response.setStatus(406);
            }
        }
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String robotId = request.getParameter("robotId");
        System.out.println(response.getStatus());
        if(robotId != null){
            RobotRequest robotRequest = new RobotRequest();
            Date date = new Date();
            robotRequest.setTime(new Timestamp(date.getTime()));
            robotRequest.setDataSize(request.getRequestURI().length() * 2);
            robotRequest.setHost(request.getRemoteHost());
            robotRequest.setRobotId(Integer.parseInt(robotId));
            String acceptStatus = response.getStatus() == 200 ? "accept" : "reject";
            robotRequest.setAcceptState(acceptStatus);
            int i = robotRequestService.addRobotRequest(robotRequest);
            if(i == 0){
                response.setStatus(406);
            }
        }
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
