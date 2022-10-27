package edu.miu.payment;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.SerializationFeature;
import edu.miu.payment.model.PaymentRequest;
import edu.miu.payment.util.PaymentMethod;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PaymentServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testPayment() throws Exception {
		PaymentRequest paymentRequest = new PaymentRequest("1",PaymentMethod.BANK,100.5,"laith@gmail.com","Laith","Nassar");
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson=ow.writeValueAsString(paymentRequest );
		mockMvc.perform(post("/api/payment").contentType(new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"))).content(requestJson)).andExpect(status().isOk());
	}

}
