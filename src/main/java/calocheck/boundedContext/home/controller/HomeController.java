package calocheck.boundedContext.home.controller;

import calocheck.base.util.s3.service.S3Service;
import calocheck.boundedContext.imageData.config.GCPConfigProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final S3Service s3Service;
    private final GCPConfigProperties gcpConfigProperties;

    @GetMapping("/")
    public String showMain() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(s3Service.getFileFromS3(gcpConfigProperties.getFilePath())));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }


        return "usr/home/main";
    }

    @GetMapping("/main2")
    public String showMain2() {

        return "usr/home/main2";
    }
}