package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.config;

import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSqs
public class SqsMessagingConfig {
}