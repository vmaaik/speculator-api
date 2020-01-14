package com.gebarowski.michal.speculatorapi.database.spring_data_jdbc.repository;

import com.gebarowski.michal.speculatorapi.MotherTestData;
import com.gebarowski.michal.speculatorapi.database.spring_data_jdbc.DataSourceConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(
        classes = {
                DataSourceConfig.class,
                JdbcConfiguration.class
        })
class JdbcExchangeRateRepositoryTest {

    @Autowired
    private JdbcExchangeRateRepository repository;

    @BeforeEach
    void setUp() {
        assertNotNull(repository);
    }

    @Test
    void testFindByIdReturnsEntity() {
        assertEquals(MotherTestData.EXCHANGE_RATE_ENTITY_ID_1, this.repository.findOne(MotherTestData.ID_1));
    }
}