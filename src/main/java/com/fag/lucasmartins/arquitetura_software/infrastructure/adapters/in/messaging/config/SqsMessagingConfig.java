package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.config;

import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("aws")
@EnableSqs
public class SqsMessagingConfig {
}