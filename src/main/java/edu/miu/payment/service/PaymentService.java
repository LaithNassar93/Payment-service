package edu.miu.payment.service;

import edu.miu.payment.client.BankClient;
import edu.miu.payment.client.CreditClient;
import edu.miu.payment.client.PaypalClient;
import edu.miu.payment.model.PaymentRequest;
import edu.miu.payment.util.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private BankClient bankClient;
    @Autowired
    private CreditClient creditClient;
    @Autowired
    private PaypalClient paypalClient;
    
    public String Payment(PaymentRequest request) {
        PaymentMethod method=request.getPaymentMethod();
        if(method==PaymentMethod.BANK){
            return bankClient.payment(request);
        } else if (method==PaymentMethod.PAYPAL) {
            return paypalClient.payment(request);
        }else if (method==PaymentMethod.CREDIT_CARD){
            return creditClient.payment(request);
        }
        return "";
    }
}