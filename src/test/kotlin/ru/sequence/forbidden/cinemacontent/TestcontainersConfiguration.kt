package ru.sequence.forbidden.cinemacontent

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.elasticsearch.ElasticsearchContainer
import org.testcontainers.utility.DockerImageName

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

    @Bean
    @ServiceConnection
    fun postgresContainer(): PostgreSQLContainer<*> {
        return PostgreSQLContainer(DockerImageName.parse("postgres:latest"))
    }

    @Bean
    @ServiceConnection
    fun elasticsearchContainer(): ElasticsearchContainer {
        return ElasticsearchContainer(DockerImageName.parse("docker.elastic.co/elasticsearch/elasticsearch:7.17.10"))
    }

    @Bean
    @ServiceConnection(name = "openzipkin/zipkin")
    fun zipkinContainer(): GenericContainer<*> {
        return GenericContainer(DockerImageName.parse("openzipkin/zipkin:latest")).withExposedPorts(9411)
    }

}
