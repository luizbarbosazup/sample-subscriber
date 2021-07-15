package database.repository

import br.com.itau.warriors.sample.database.entity.SaleEntity
import br.com.itau.warriors.sample.database.repository.SaleEntityRepositoryImpl
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.ResultSet
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class SaleEntityRepositoryTest:AnnotationSpec() {

    val cqlSession = mockk<CqlSession>(relaxed = true)

    val repository = SaleEntityRepositoryImpl(cqlSession)

    lateinit var saleEntity: SaleEntity
    lateinit var resultset:ResultSet


    @BeforeEach
    fun setUp(){
        saleEntity = SaleEntity(productid = UUID.randomUUID(), qty=10.0)
    }

    @Test
    fun `I should be receive a saleEntity when inserted into database`(){
        every {cqlSession.execute("")} answers { resultset } //será que é necessario?, funciona sem
        val result:SaleEntity = repository.saveSaleCql(saleEntity)
        result shouldBe saleEntity
    }

}