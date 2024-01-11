package io.clinicway.dh.connector.terra.datasource.observer.repository;

import io.clinicway.dh.connector.terra.datasource.observer.entity.Settings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsRepository extends JpaRepository<Settings, Long> {
}
