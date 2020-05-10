package com.gebarowski.michal.speculatorapi.database.spring_data_jdbc.repository;

import com.gebarowski.michal.speculatorapi.MotherTestData;
import com.gebarowski.michal.speculatorapi.database.spring_data_jdbc.configuration.DataSourceConfig;
import com.gebarowski.michal.speculatorapi.database.spring_data_jdbc.ExchangeRateEntity;
import com.gebarowski.michal.speculatorapi.database.spring_data_jdbc.configuration.JdbcConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static com.gebarowski.michal.speculatorapi.MotherTestData.EXCHANGE_RATE_ENTITY_ID_2;
import static org.junit.jupiter.api.Assertions.*;

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
    @Disabled
    void findByIdReturnsProperEntity() {
        assertEquals(MotherTestData.EXCHANGE_RATE_ENTITY_ID_1, this.repository.findOne(MotherTestData.ID_1));
    }

    @Test
    void findAllReturnsAllEntities() {
        assertEquals(4, this.repository.findAll().size());
    }

    @Test
    void findByIdThrowsExceptionWhenNotFound() {
        assertThrows(EmptyResultDataAccessException.class, ()
                -> this.repository.findOne(99L));
    }

    @Test
    void countReturnsRowNumber() {
        assertEquals(4, this.repository.count());
    }

    @Test
    void findAllAsMapsReturnsAllEntitiesAsMap() {
        assertEquals(4, this.repository.findAllAsMaps().size());
    }

    @Test
    void saveAddsNewRecord() {
        this.repository.save(EXCHANGE_RATE_ENTITY_ID_2);
        assertEquals(4, this.repository.count());

        final ExchangeRateEntity result = this.repository.findOne(MotherTestData.ID_2);

        assertEquals(EXCHANGE_RATE_ENTITY_ID_2, result);
    }

    @Test
    void testRowCallbackHandler() {
        this.repository.logConvertedFromEur();
    }

    @Test
    void deleteRecord() {
        this.repository.deleteById(1L);
        assertEquals(3, this.repository.findAll().size());
    }
}