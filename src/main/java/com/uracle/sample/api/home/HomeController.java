package com.uracle.sample.api.home;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello World";
    }

    @GetMapping("/map")
    public Map<String, String> map() {
        Map<String, String> hw = new HashMap<>();
        hw.put("Hello", "World");

        return hw;
    }

    @GetMapping("/map/list")
    public List<Map<String, String>> mapList() {
        List<Map<String, String>> hwList = new ArrayList<>();


        Map<String, String> hw1 = new HashMap<>();
        hw1.put("key", "Hello");
        Map<String, String> hw2 = new HashMap<>();
        hw2.put("Hello2", "World2");

        hwList.add(hw1);
        hwList.add(hw2);

        return hwList;
    }


    @GetMapping("/vo")
    public HomeVO homeVo() {
        HomeVO homeVO = new HomeVO();
        homeVO.setKey("Hello");
        homeVO.setValue("World");

        return homeVO;
    }

    @GetMapping("/vo/list")
    public List<HomeVO> voList() {
        List<HomeVO> hwList = new ArrayList<>();

        HomeVO homeVO1 = new HomeVO();
        homeVO1.setKey("Hello1");
        homeVO1.setValue("World1");
        HomeVO homeVO2 = new HomeVO();
        homeVO2.setKey("Hello2");
        homeVO2.setValue("World2");

        hwList.add(homeVO1);
        hwList.add(homeVO2);

        return hwList;
    }

}
