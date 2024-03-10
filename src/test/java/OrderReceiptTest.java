import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderReceiptTest {
    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        ArrayList<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order("YY", "xian", lineItems));

        String output = receipt.printReceipt();

        assertEquals("======Printing Orders======\n"
                + "YY\n" + "xian\n"
                + "milk\t10.0\t2\t20.0\n"
                + "biscuits\t5.0\t5\t25.0\n"
                + "chocolate\t20.0\t1\t20.0\n"
                + "Sales Tax\t6.5"
                + "Total Amount\t71.5", output);
    }
}
