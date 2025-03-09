package org.zerock.mallapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.mallapi.domain.SampleUser;

public interface SampleUserRespository extends JpaRepository<SampleUser, String> {

    SampleUser findByUidAndUpw(String uid, String upw);

}
