package nonda.cardata.model.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MultipleMongoConfig {

    @Autowired
    private MultipleMongoProperties mongoProperties;

    @Primary
    @Bean(name = PrimaryMongoConfig.MONGO_TEMPLATE)
    public MongoTemplate primaryMongoTemplate() throws Exception {
        //把DefaultMongoTypeMapper设置为null, 不然新增的时候 会多出一列_class, 值是model的路径
        MappingMongoConverter converter =
                new MappingMongoConverter(primaryFactory(this.mongoProperties.getPrimary()), new MongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return new MongoTemplate(primaryFactory(this.mongoProperties.getPrimary()),converter);
    }

    @Bean
    @Qualifier(SecondaryMongoConfig.MONGO_TEMPLATE)
    public MongoTemplate secondaryMongoTemplate() throws Exception {
        MappingMongoConverter converter =
                new MappingMongoConverter(secondaryFactory(this.mongoProperties.getSecondary()), new MongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return new MongoTemplate(secondaryFactory(this.mongoProperties.getSecondary()),converter);
    }

    @Bean
    @Primary
    public MongoDbFactory primaryFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
                mongo.getDatabase());
    }

    @Bean
    public MongoDbFactory secondaryFactory(MongoProperties mongo) throws Exception {
         ServerAddress serverAddress = new ServerAddress(mongo.getHost(), mongo.getPort());
         List<MongoCredential> mongoCredentialList = new ArrayList<>();
         mongoCredentialList.add(MongoCredential.createCredential(mongo.getUsername(), mongo.getAuthenticationDatabase(),
         mongo.getPassword()));
         return new SimpleMongoDbFactory(new MongoClient(serverAddress,
         mongoCredentialList), mongo.getDatabase());
    }
}