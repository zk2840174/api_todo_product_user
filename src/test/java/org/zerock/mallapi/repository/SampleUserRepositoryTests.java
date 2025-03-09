package org.zerock.mallapi.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.mallapi.domain.SampleUser;

@SpringBootTest
@Log4j2
public class SampleUserRepositoryTests {

    @Autowired
    SampleUserRespository sampleUserRepository;

    @Test
    public void testSave() {

        for (int i = 1; i <= 10 ; i++) {

            SampleUser sampleUser = SampleUser.builder()
                    .uid("user"+i)
                    .upw("1111")
                    .email("user" + i + "@aaa.com")
                    .uname("USER" + i)
                    .build();

            sampleUserRepository.save(sampleUser);

        }


    }

}
