package core.service


import br.com.itau.warriors.sample.core.model.Sale
import br.com.itau.warriors.sample.core.port.SaleEntityServicePort
import br.com.itau.warriors.sample.core.service.SaleServiceImpl
import br.com.itau.warriors.sample.database.entity.SaleEntity
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class SaleServiceImplTest:AnnotationSpec() {

    val repository = mockk<SaleEntityServicePort>(relaxed = true)
    val service = SaleServiceImpl(repository)

    lateinit var saleEntity:SaleEntity
    lateinit var sale:Sale

    @BeforeEach
    fun setUp(){
        sale = Sale(
            productid = UUID.randomUUID(),
            qty = 10.0)

        saleEntity = SaleEntity(
            productid = UUID.randomUUID(),
            qty = 10.0)
    }


    @Test
    fun `should be void when I send a sale`(){
        every{ repository.saveSaleEntity(any()) } answers { saleEntity }
        val result = service.saveSale(sale = sale)
        result shouldBe Unit
    }

}