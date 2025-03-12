package org.zerock.mallapi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.mallapi.dto.ProductDTO;
import org.zerock.mallapi.dto.SampleUserDTO;
import org.zerock.mallapi.service.SampleUserService;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/sampleuser")
public class SampleUserController {

    private final SampleUserService sampleUserService;

    @PostMapping("/")
    public Map<String, String> register(SampleUserDTO sampleUserDTO){

        log.info("register: " + sampleUserDTO);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //서비스 호출
       sampleUserService.addUser(sampleUserDTO);

        return Map.of("result", sampleUserDTO.getUid());
    }

    @RequestMapping ("/login")
    public SampleUserDTO login(String uid, String upw){

        log.info("login: " + uid + " " + upw);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return sampleUserService.getUidAndUpw(uid, upw);

    }

}
