package edu.miu.payment.model;

import edu.miu.payment.util.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    private String userId;
    private PaymentMethod paymentMethod;
    private double amount;
    private String email;
    private String firstName;
    private String lastName;
}
