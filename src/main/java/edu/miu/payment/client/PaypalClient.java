package edu.miu.payment.client;

import edu.miu.payment.model.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "PAYPAL-SERVICE")
public interface PaypalClient {
    @RequestMapping(method = RequestMethod.POST, value = "/api/paypal")
    public String payment(@RequestBody PaymentRequest paymentRequest);
}
