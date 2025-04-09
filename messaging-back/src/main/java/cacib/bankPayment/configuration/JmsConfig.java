package cacib.bankPayment.configuration;

import com.ibm.mq.jakarta.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.jakarta.wmq.WMQConstants;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;

@Configuration
@EnableJms
public class JmsConfig {

    @Bean
    public ConnectionFactory connectionFactory() throws JMSException {
        MQQueueConnectionFactory mqConnectionFactory = new MQQueueConnectionFactory();
        mqConnectionFactory.setQueueManager("QM1");
        mqConnectionFactory.setChannel("DEV.ADMIN.SVRCONN");
        mqConnectionFactory.setTransportType(WMQConstants.WMQ_CM_CLIENT);
        mqConnectionFactory.setConnectionNameList("localhost(1414)");
        mqConnectionFactory.setStringProperty( WMQConstants.USERID, "admin" );
        mqConnectionFactory.setStringProperty(WMQConstants.PASSWORD, "passw0rd");
        return mqConnectionFactory;
    }

    @Bean
    public JmsListenerContainerFactory<?> myFactory(DefaultJmsListenerContainerFactoryConfigurer configurer) throws JMSException {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory());
        return factory;
    }
}
