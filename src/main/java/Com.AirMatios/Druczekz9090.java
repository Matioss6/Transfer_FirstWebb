package Com.AirMatios;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "lol", url = "${name.service.url}")
public interface Druczekz9090 {


    @PostMapping("/druczek")
    public String druczek(@RequestParam String druk);
}
