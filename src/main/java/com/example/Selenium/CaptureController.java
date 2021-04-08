package com.example.Selenium;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CaptureController {

    @GetMapping("/getObisCapture")
    public String convertToBase64(@RequestParam(value = "url") String url) throws InterruptedException {

        SeleniumCapture seleniumCapture = new SeleniumCapture();

        return seleniumCapture.CaptureScreen(url);
    }


}
