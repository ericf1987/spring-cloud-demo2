package ribbon.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by fengye on 2020/5/27.
 */
@Configuration
@Slf4j
public class MySelfRule extends AbstractLoadBalancerRule {

    /**
     * 每台设备需要被访问的次数
     */
    private int total;

    /**
     * 当前是第几台服务器被使用
     */
    private int currentIndex;

    /**
     * 定义需要重复访问的次数
     */
    private int count;

    public MySelfRule(int count) {
        this.count = count;
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while (server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List upList = lb.getReachableServers();
                List allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }


                if (this.total < this.count) {
                    server = (Server) upList.get(this.currentIndex);
                    total++;
                } else {
                    //超过需要被访问的次数 count 将total改为0 重新开始计次
                    total = 0;
                    //跳转访问下一台
                    currentIndex++;
                    server = (Server) upList.get(this.currentIndex);
                    if (currentIndex > upList.size()) {
                        currentIndex = 0;
                    }
                }


                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }

}
