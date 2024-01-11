package io.clinicway.dh.api.consumer.repository;

import io.clinicway.dh.api.consumer.entity.redis.Connector;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectorRepository extends CrudRepository<Connector, String> {
}
