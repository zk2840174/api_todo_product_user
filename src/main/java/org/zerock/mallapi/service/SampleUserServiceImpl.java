package org.zerock.mallapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.mallapi.domain.SampleUser;
import org.zerock.mallapi.dto.SampleUserDTO;
import org.zerock.mallapi.repository.SampleUserRespository;


@Service
@RequiredArgsConstructor
@Log4j2
public class SampleUserServiceImpl implements SampleUserService {

    private final SampleUserRespository respository;

    @Override
    public void addUser(SampleUserDTO sampleUserDTO) {

        SampleUser sampleUser = SampleUser.builder()
                .uid(sampleUserDTO.getUid())
                .upw(sampleUserDTO.getUpw())
                .uname(sampleUserDTO.getUname())
                .email(sampleUserDTO.getEmail())
                .build();


        respository.save(sampleUser);

    }

    @Override
    public SampleUserDTO getUser(String id) {
        SampleUser sampleUser =  respository.findById(id).orElseThrow();

        return SampleUserDTO.builder()
                .uid(sampleUser.getUid())
                .upw(sampleUser.getUpw())
                .uname(sampleUser.getUname())
                .email(sampleUser.getEmail())
                .build();
    }

    @Override
    public void deleteUser(String id) {

        respository.deleteById(id);
    }

    @Override
    public void updateUser(SampleUserDTO sampleUserDTO) {

        SampleUser sampleUser =  respository.findById(sampleUserDTO.getUid()).orElseThrow();

        sampleUser.changePassword(sampleUserDTO.getUpw());
        sampleUser.changeUsername(sampleUserDTO.getUname());




    }

    @Override
    public SampleUserDTO getUidAndUpw(String uid, String upw) {

        SampleUser sampleUser =  respository.findByUidAndUpw(uid, upw);

        return SampleUserDTO.builder()
                .uid(sampleUser.getUid())
                .upw(sampleUser.getUpw())
                .uname(sampleUser.getUname())
                .email(sampleUser.getEmail())
                .build();
    }
}
