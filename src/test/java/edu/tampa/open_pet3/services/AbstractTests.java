package edu.tampa.open_pet3.services;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring_db.xml"
}
)
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/scripts.sql",config=@SqlConfig(encoding="UTF-8"))
public abstract class AbstractTests {
}
