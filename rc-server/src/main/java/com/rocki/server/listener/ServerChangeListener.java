package com.rocki.server.listener;



import com.netflix.appinfo.InstanceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


/**
 * 监听服务状态
 */
@Component
public class ServerChangeListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerChangeListener.class);

    /*EurekaInstanceCanceledEvent 服务下线事件
        EurekaInstanceRegisteredEvent 服务注册事件
        EurekaInstanceRenewedEvent 服务续约事件
        EurekaRegistryAvailableEvent Eureka注册中心启动事件
        EurekaServerStartedEvent Eureka Server启动事件*/

    @EventListener
    public void listen(EurekaInstanceCanceledEvent canceledEvent){
        // 服务断线事件
        String appName = canceledEvent.getAppName();
        String serverId = canceledEvent.getServerId();

        LOGGER.info("the service is down [{},{}]",appName,serverId);
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent registeredEvent){
        // 服务注册事件
        InstanceInfo info = registeredEvent.getInstanceInfo();

        LOGGER.info("the service is register [{}]",info.toString());
    }

}
