package org.zerock.mallapi.service;

import jakarta.transaction.Transactional;
import org.zerock.mallapi.domain.SampleUser;
import org.zerock.mallapi.dto.SampleUserDTO;


@Transactional
public interface SampleUserService {


    void addUser(SampleUserDTO sampleUserDTO);

    SampleUserDTO getUser(String id);

    void deleteUser(String id);

    void updateUser(SampleUserDTO sampleUserDTO);

    SampleUserDTO getUidAndUpw(String uid, String upw);
}
