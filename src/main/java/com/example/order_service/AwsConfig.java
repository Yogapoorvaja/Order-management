package com.example.order_service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {
    
    @Bean
    public AmazonS3 amazonS3() {
        return AmazonS3ClientBuilder.standard()
            .withEndpointConfiguration(
                new AwsClientBuilder.EndpointConfiguration(
                    "http://localhost:4566", 
                    "us-east-1"
                )
            )
            .withCredentials(new AWSStaticCredentialsProvider(
                new BasicAWSCredentials("test", "test")
            ))
            .build();
    }
    
    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
            .withEndpointConfiguration(
                new AwsClientBuilder.EndpointConfiguration(
                    "http://localhost:4566", 
                    "us-east-1"
                )
            )
            .withCredentials(new AWSStaticCredentialsProvider(
                new BasicAWSCredentials("test", "test")
            ))
            .build();
    }
    
    @Bean
    public AmazonSNS amazonSNS() {
        return AmazonSNSClientBuilder.standard()
            .withEndpointConfiguration(
                new AwsClientBuilder.EndpointConfiguration(
                    "http://localhost:4566", 
                    "us-east-1"
                )
            )
            .withCredentials(new AWSStaticCredentialsProvider(
                new BasicAWSCredentials("test", "test")
            ))
            .build();
    }
}