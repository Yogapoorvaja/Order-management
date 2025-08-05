package com.example.order_service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.sns.AmazonSNS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Service
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final AmazonS3 amazonS3;
    private final AmazonSNS amazonSNS;
    
    private static final String BUCKET_NAME = "order-invoices";
    private static final String SNS_TOPIC = "order-notifications";

    @Autowired
    public OrderService(OrderRepository orderRepository,
                      AmazonS3 amazonS3,
                      AmazonSNS amazonSNS) {
        this.orderRepository = orderRepository;
        this.amazonS3 = amazonS3;
        this.amazonSNS = amazonSNS;
    }

    public Order createOrder(Order order, MultipartFile invoiceFile) throws IOException {
        String fileName = "invoice_" + order.getOrderId() + ".pdf";
        amazonS3.putObject(BUCKET_NAME, fileName, invoiceFile.getInputStream(), null);
        order.setInvoiceFileUrl(amazonS3.getUrl(BUCKET_NAME, fileName).toString());
        
        Order savedOrder = orderRepository.save(order);
        amazonSNS.publish(SNS_TOPIC, "New order: " + savedOrder.getOrderId());
        return savedOrder;
    }

    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    public Order getOrderById(String id) {
        return orderRepository.findById(id).orElse(null);
    }
}