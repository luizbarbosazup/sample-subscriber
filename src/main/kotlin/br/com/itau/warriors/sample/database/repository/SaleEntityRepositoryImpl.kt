package br.com.itau.warriors.sample.database.repository

import br.com.itau.warriors.sample.database.entity.SaleEntity
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.ResultSet
import com.datastax.oss.driver.api.core.cql.Row
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton

@Singleton
class SaleEntityRepositoryImpl(val cqlSession: CqlSession): SaleEntityRepository {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun saveSaleCql(saleEntity: SaleEntity):SaleEntity {


        val result:ResultSet = cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "INSERT INTO pdvdata.sale(id, productid, qty) values(?,?,?)",
                    UUID.randomUUID(),
                    saleEntity.productid,
                    saleEntity.qty
                )
        )
        logger.info("Saved Sale in database")
        logger.info("${saleEntity}")
        return saleEntity

    }
}