package com.example.order_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

@SpringBootApplication
public class OrderServiceApplication implements CommandLineRunner {

    @Autowired
    private DynamoDbClient dynamoDbClient;

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            dynamoDbClient.createTable(CreateTableRequest.builder()
                .tableName("Orders")
                .keySchema(KeySchemaElement.builder()
                    .attributeName("orderId")
                    .keyType(KeyType.HASH)
                    .build())
                .attributeDefinitions(AttributeDefinition.builder()
                    .attributeName("orderId")
                    .attributeType(ScalarAttributeType.S)
                    .build())
                .billingMode(BillingMode.PAY_PER_REQUEST)
                .build());
            System.out.println("DynamoDB table created!");
        } catch (ResourceInUseException e) {
            System.out.println("Table already exists");
        }
    }
}