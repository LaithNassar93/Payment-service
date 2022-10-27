package edu.miu.payment.client;

import edu.miu.payment.model.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "BANK-SERVICE")
public interface BankClient {
    @RequestMapping(method = RequestMethod.POST, value = "/api/bank")
    public String payment(@RequestBody PaymentRequest paymentRequest);
}
