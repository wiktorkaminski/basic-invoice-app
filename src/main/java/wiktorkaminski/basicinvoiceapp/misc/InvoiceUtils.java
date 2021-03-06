package wiktorkaminski.basicinvoiceapp.misc;

import org.springframework.stereotype.Service;
import wiktorkaminski.basicinvoiceapp.entity.Invoice;
import wiktorkaminski.basicinvoiceapp.entity.InvoiceProduct;

import java.util.Iterator;
import java.util.List;

@Service
public class InvoiceUtils {

    public static double countTotalGrossValue(Invoice invoice) {
        List<InvoiceProduct> productList = invoice.getInvoiceProductList().getProductList();
        Iterator<InvoiceProduct> productIterator = productList.iterator();
        double totalGross = 0;
        while (productIterator.hasNext()) {
            InvoiceProduct product = productIterator.next();
            totalGross += product.getPrice() * product.getQuantity() * (1 + (0.01*product.getVatRate()));
        }
        return totalGross;
    }

    public static double countTotalNetValue(Invoice invoice) {
        List<InvoiceProduct> productList = invoice.getInvoiceProductList().getProductList();
        Iterator<InvoiceProduct> productIterator = productList.iterator();
        double totalNet = 0;
        while (productIterator.hasNext()) {
            InvoiceProduct product = productIterator.next();
            totalNet += product.getPrice() * product.getQuantity();
        }
        return totalNet;
    }

    public static double countAmountToPay(Invoice invoice) {
        double grossValue = countTotalGrossValue(invoice);
        return grossValue - invoice.getAmountPaid();
    }

}
