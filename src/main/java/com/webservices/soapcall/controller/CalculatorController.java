package com.webservices.soapcall.controller;

import com.webservices.soapcall.com.lavasoft.GeoIPService;
import com.webservices.soapcall.com.lavasoft.GeoIPServiceSoap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

    //http://wsgeoip.lavasoft.com/ipservice.asmx?wsdl

    @GetMapping("/add")
    public String getIpLocation(@RequestParam (name = "ipAddress") String geoIp){
        GeoIPService geoIPService = new GeoIPService();
        GeoIPServiceSoap geoIPServiceSoap = geoIPService.getGeoIPServiceSoap();
        String geoIpLocation = geoIPServiceSoap.getIpLocation(geoIp);
        System.out.println(geoIpLocation);
        return geoIpLocation;
    }
}
