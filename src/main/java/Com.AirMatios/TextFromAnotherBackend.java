package Com.AirMatios;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "druk", url = "${name.service.url}")
public interface TextFromAnotherBackend {


    @GetMapping("/druk")
    public String printIt();
}
